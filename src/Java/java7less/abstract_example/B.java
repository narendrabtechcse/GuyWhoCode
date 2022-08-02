package Java.java7less.abstract_example;


public class B extends AbstractClass {
    void test1()
    {
        System.out.println("test1()");
    }

    void test2()
    {
        System.out.println("test2()");
    }
}

class Manager1
{
    public static void main(String[] args)
    {
        B b1 = new B();
        b1.test1();
        b1.test2();
        b1.test3();
        b1.test4();
        System.out.println("done !!");
    }
}
