package OpenTextAssignment;

import java.util.concurrent.Future;

public interface TaskExecutor {
    /**
     * Submit new task to be queued and executed.
     *
     * @param task Task to be executed by the executor. Must not be null.
     * @return Future for the task asynchronous computation result.
     */
    <T> Future<T> submitTask(OrderedTaskExecutor.Task<T> task);
}
