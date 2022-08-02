package Java.java7less.casting;

class A{
    int i =10;
}

class B extends A
{
    int j = 20;
}

class C extends B
{
    int k = 30;
}

public class UpDownVar {
    public static void main(String[] args)
    {

        A a1 = new B();
        System.out.println(a1.i);
        // System.out.println(a1.j); // compilation error

        B b1 = (B)a1;
        System.out.println(b1.i);
        System.out.println(b1.j);
    }
}
