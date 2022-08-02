package Java.java7less.threading.synchronisation;

public class B extends Thread{
    Shared s1;
    B(Shared s1)
    {
        this.s1 = s1;
    }

    public void run()
    {
        s1.test2();
    }
}
