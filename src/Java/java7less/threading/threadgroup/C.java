package Java.java7less.threading.threadgroup;

public class C extends Thread{

    C(ThreadGroup tg)
    {
        super(tg,"C");
    }

    public void run()
    {
        for (int i=2000;i<3000;i++)
        {
            System.out.println(i);
        }
    }
}
