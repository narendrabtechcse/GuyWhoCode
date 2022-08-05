package Java.java7less.threading.threadpool;

import java.util.ArrayList;

public class PoolManager {

    private ArrayList pool = new ArrayList();

    public void init()
    {
        CommonTask ct = null;

        for(int i=0;i<10;i++)
        {
            ct = new CommonTask();
            ct.start();
            pool.add(ct);
        }
    }

    public CommonTask getThread()
    {
        CommonTask ct = null;
        if(pool.size()>0)
        {
            ct = (CommonTask) pool.remove(0);
        }else{
            ct = new CommonTask();
        }

        return ct;
    }

    public void setThread(CommonTask ct)
    {

        if(ct!=null)
        {
            if(pool.size()<10)
            {
                pool.add(ct);
            }else{
                ct=null;
            }
        }
    }

    public void releaseAll()
    {
        CommonTask ct = null;
        for(int i=0;i<pool.size();i++)
        {
            ct=(CommonTask) pool.remove(0);
            ct = null;
        }
        pool = null;
    }
}
