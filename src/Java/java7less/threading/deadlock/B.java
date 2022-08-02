package Java.java7less.threading.deadlock;

public class B extends Thread{

    Shared s1,s2;

    B(Shared s1,Shared s2)
    {
        this.s1 = s1;
        this.s2 = s2;
    }

    public void run()
    {
        s2.test2(s1);
    }
}
