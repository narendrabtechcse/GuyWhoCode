package OpenTextAssignment;

import java.util.UUID;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        OrderedTaskExecutor executor = new OrderedTaskExecutor(3); // max 3 concurrent tasks

        OrderedTaskExecutor.TaskGroup group1 = new OrderedTaskExecutor.TaskGroup(UUID.randomUUID());
        OrderedTaskExecutor.TaskGroup group2 = new OrderedTaskExecutor.TaskGroup(UUID.randomUUID());

        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            executor.submitTask(new OrderedTaskExecutor.Task<>(
                    UUID.randomUUID(),
                    group1,
                    OrderedTaskExecutor.TaskType.READ,
                    () -> {
                        System.out.println("Group1 Task " + finalI + " started.");
                        Thread.sleep(1000);
                        System.out.println("Group1 Task " + finalI + " finished.");
                        return finalI;
                    }
            ));
        }

        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            executor.submitTask(new OrderedTaskExecutor.Task<>(
                    UUID.randomUUID(),
                    group2,
                    OrderedTaskExecutor.TaskType.WRITE,
                    () -> {
                        System.out.println("Group2 Task " + finalI + " started.");
                        Thread.sleep(500);
                        System.out.println("Group2 Task " + finalI + " finished.");
                        return finalI;
                    }
            ));
        }

        Thread.sleep(8000); // wait for all to finish
    }
}

