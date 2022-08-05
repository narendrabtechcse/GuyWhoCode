package Java.java7less.threading.threadlocal;

public class Thread1 extends Thread
{

    ThreadLocal t = null;
    Thread1(ThreadLocal t)
    {
        this.t = t;
    }

    public void run()
    {
        System.out.println("1 : "+ t.get());
        t.set(10);
        Util.sleep(100);
        System.out.println("2 : "+ t.get());

        t.set(20);

        Util.sleep(100);

        System.out.println(" 3 : "+t.get());

        t.set(30);

        Util.sleep(100);

        System.out.println("4 : "+t.get());

        t.set(40);
    }

}
