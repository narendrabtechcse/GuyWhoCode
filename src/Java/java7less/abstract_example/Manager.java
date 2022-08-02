package Java.java7less.abstract_example;

 abstract class AbstractClass {

    abstract void test1();
    abstract void test2();

    void test3()
    {
        System.out.println("test3()");
    }

    static void test4()
    {
        System.out.println("test4()");
    }



}

public class Manager
{
    public static void main(String[] args)
    {
        AbstractClass.test4();
        System.out.println("done");
    }
}
