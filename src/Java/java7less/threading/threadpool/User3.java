package Java.java7less.threading.threadpool;

public class User3 extends Thread{

    private PoolManager pm = null;
    User3(PoolManager pm)
    {
        this.pm = pm;
    }

    public void run()
    {
        while(true)
        {
            CommonTask ct = pm.getThread();
            ct.a1.releaseFromWait();
            ct.a1.goToWait();
            pm.setThread(ct);
        }
    }

}
