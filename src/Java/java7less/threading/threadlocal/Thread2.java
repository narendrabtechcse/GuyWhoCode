package Java.java7less.threading.threadlocal;

public class Thread2 extends Thread{


    ThreadLocal t = null;
    Thread2(ThreadLocal t)
    {
        this.t = t;
    }

    public void run()
    {
        System.out.println("5 : "+ t.get());
        t.set(50);
        Util.sleep(100);
        System.out.println("6 : "+ t.get());

        t.set(60);

        Util.sleep(100);

        System.out.println(" 7 : "+t.get());

        t.set(70);

        Util.sleep(100);

        System.out.println("8 : "+t.get());

        t.set(80);
    }

}
