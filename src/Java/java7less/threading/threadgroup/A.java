package Java.java7less.threading.threadgroup;

public class A extends Thread{

    A(ThreadGroup tg)
    {
        super(tg,"A");
    }

    public void run()
    {
        for (int i=0;i<1000;i++)
        {
            System.out.println(i);
        }
    }
}
