package Java.java7less.threading.deadlock;

public class A extends Thread{

    Shared s1,s2;

    A(Shared s1,Shared s2)
    {
        this.s1 = s1;
        this.s2 = s2;
    }

    public void run()
    {
        s1.test1(s2);
    }

}
