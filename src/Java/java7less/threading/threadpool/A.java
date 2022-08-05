package Java.java7less.threading.threadpool;

public class A {

    synchronized void goToWait()
    {
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + " is going to wait");

        try{
            wait();
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }

        System.out.println(t.getName() + " is released from wait");
    }

    synchronized void releaseFromWait()
    {
        notify();
    }
}
