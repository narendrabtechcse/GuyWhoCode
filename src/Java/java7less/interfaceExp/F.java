package Java.java7less.interfaceExp;

public class F implements Int1{
    public void test1()
    {
        System.out.println("test1()");
    }

    public void test2()
    {
        System.out.println("test2()");
    }

    public void test3()
    {
        System.out.println("test3()");
    }
}


class Manager3
{
    public static void main(String[] args)
    {
        F f1 = new F();
        f1.test1();
        f1.test2();
        f1.test3();
        System.out.println("done");
    }
}
