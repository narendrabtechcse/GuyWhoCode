package Java.java7less.executorscode.cachedThreadPool;

import Java.java7less.executorscode.fixedSizeThreadPool.LoopTaskA;

import java.util.concurrent.TimeUnit;

public class LoopTaskB implements Runnable{

    private String name ;

    public String getName()
    {
        return name;
    }

    LoopTaskB(String name)
    {
        this.name = name;
    }


    @Override
    public void run() {

            Long duration = (long)Math.random()*10;
            System.out.println("Running the task : " + name);
            try {
                TimeUnit.SECONDS.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}
