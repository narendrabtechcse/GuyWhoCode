package Java.java7less.threading.threadgroup;

public class B implements Runnable{


    public void run()
    {
        for (int i=1000;i<2000;i++)
        {
            System.out.println(i);
        }
    }

}
