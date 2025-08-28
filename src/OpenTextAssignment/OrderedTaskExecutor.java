package OpenTextAssignment;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class OrderedTaskExecutor implements TaskExecutor {

    private final ExecutorService executor;
    private final BlockingQueue<QueuedTask<?>> taskQueue = new LinkedBlockingQueue<>();
    private final Map<UUID, Object> activeGroups = new ConcurrentHashMap<>();
    private final AtomicBoolean isDispatcherRunning = new AtomicBoolean(false);

    public OrderedTaskExecutor(int maxConcurrency) {
        if (maxConcurrency <= 0) throw new IllegalArgumentException("Concurrency must be > 0");
        this.executor = Executors.newFixedThreadPool(maxConcurrency);
        startDispatcher(); // start task dispatcher
    }

    @Override
    public <T> Future<T> submitTask(Task<T> task) {
        if (task == null) throw new IllegalArgumentException("Task cannot be null");

        QueuedTask<T> queuedTask = new QueuedTask<>(task);
        taskQueue.offer(queuedTask); // Non-blocking queue insertion
        return queuedTask.future;
    }

    private void startDispatcher() {
        if (isDispatcherRunning.compareAndSet(false, true)) {
            Thread dispatcherThread = new Thread(() -> {
                while (true) {
                    try {
                        QueuedTask<?> queuedTask = taskQueue.take(); // Blocking call

                        UUID groupId = queuedTask.task.taskGroup().groupUUID();

                        synchronized (getGroupLock(groupId)) {
                            if (activeGroups.putIfAbsent(groupId, Boolean.TRUE) == null) {
                                executor.submit(() -> {
                                    try {
                                        queuedTask.run();
                                    } finally {
                                        // remove from active groups
                                        activeGroups.remove(groupId);
                                        synchronized (getGroupLock(groupId)) {
                                            getGroupLock(groupId).notifyAll(); // allow next task in same group
                                        }
                                    }
                                });
                            } else {
                                // group is busy, requeue and retry later
                                taskQueue.offer(queuedTask);
                                Thread.sleep(10); // yield to avoid tight loop
                            }
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }, "TaskDispatcher");
            dispatcherThread.setDaemon(true);
            dispatcherThread.start();
        }
    }

    private final Map<UUID, Object> groupLocks = new ConcurrentHashMap<>();

    private Object getGroupLock(UUID groupId) {
        return groupLocks.computeIfAbsent(groupId, k -> new Object());
    }

    private static class QueuedTask<T> {
        final Task<T> task;
        final CompletableFuture<T> future = new CompletableFuture<>();

        QueuedTask(Task<T> task) {
            this.task = task;
        }

        void run() {
            try {
                T result = task.taskAction().call();
                future.complete(result);
            } catch (Exception e) {
                future.completeExceptionally(e);
            }
        }
    }

    /**
     * Representation of computation to be performed by the {@link TaskExecutor}.
     *
     * @param taskUUID Unique task identifier.
     * @param taskGroup Task group.
     * @param taskType Task type.
     * @param taskAction Callable representing task computation and returning the result.
     * @param <T> Task computation result value type.
     */
    public record Task<T>(
            UUID taskUUID,
            TaskGroup taskGroup,
            TaskType taskType,
            Callable<T> taskAction
    ) {
        public Task {
            if (taskUUID == null || taskGroup == null || taskType == null || taskAction == null) {
                throw new IllegalArgumentException("All parameters must not be null");
            }
        }
    }

    /**
     * Task group.
     *
     * @param groupUUID Unique group identifier.
     */
    public record TaskGroup(
            UUID groupUUID
    ) {
        public TaskGroup {
            if (groupUUID == null) {
                throw new IllegalArgumentException("All parameters must not be null");
            }
        }
    }

    /**
     * Enumeration of task types.
     */
    public enum TaskType {
        READ,
        WRITE
    }


}
