package Java.java7less.threading.threadgroup;

public class D implements Runnable{

    public void run()
    {
        for (int i = 3000;i<4000;i++)
        {
            System.out.println(i);
        }
    }
}
