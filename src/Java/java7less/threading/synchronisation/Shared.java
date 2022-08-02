package Java.java7less.threading.synchronisation;

public class Shared {

    synchronized void test1()
    {
        for(int i=0;i<1000;i++)
        {
            System.out.println(i);
        }
    }

    synchronized void test2()
    {
        for(int j=1000;j<2000;j++)
        {
            System.out.println(j);
        }
    }
}
