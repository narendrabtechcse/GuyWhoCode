package Java.java7less.executorscode.cachedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CachedThreadPool {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        for (int i=0;i<10;i++)
        threadPoolExecutor.execute(new LoopTaskB("Task Name " +i+ " is taken "));

        System.out.println("Maximum threads inside the pool is : "+threadPoolExecutor.getActiveCount());

        threadPoolExecutor.shutdown();

    }

}
