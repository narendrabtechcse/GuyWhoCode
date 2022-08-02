package Java.java7less.casting;

public class AutoWidening {

    static void test(float f)
    {
        System.out.println("float");
    }

    public static void main(String[] args)
    {
        test(10);//auto widening is happened here.

        double d = 100.09;
        int i = (int)d;

        System.out.println("i : "+i);


        double d1=100.9999;
        int j = (byte)d1;

        System.out.println("j : " + j);
    }
}
