package Java.java7less.executorscode.fixedSizeThreadPool;

import java.util.concurrent.TimeUnit;

public class LoopTaskA implements Runnable{

    private String name;

    public LoopTaskA(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run()
    {
        try
        {
            Long duration = (long) (Math.random() * 10);
            System.out.println("Doing a task during : " + name);
            TimeUnit.SECONDS.sleep(duration);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
