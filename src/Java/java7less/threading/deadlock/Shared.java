package Java.java7less.threading.deadlock;

public class Shared {

    synchronized void test1(Shared s1)
    {
        System.out.println("test1 started");
        Util.sleep(1000);

        s1.test2(this);
        System.out.println("test1 end");
    }


    synchronized void test2(Shared s1)
    {
        System.out.println("test2 started !!");
        Util.sleep(1000);
        s1.test1(this);
        System.out.println("test2 end");
    }
}
