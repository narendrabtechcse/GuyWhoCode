package Java.java7less.threading;

class A extends Thread{

    public void run()
    {
        for(int i=0;i<1000;i++)
        {
            System.out.println(i);
        }
    }
}

class Manager1{
    public static void main(String[] args)
    {
        A a1 = new A();
        a1.start();
        for(int j=1000;j<2000;j++)
        {
            System.out.println(j);
        }
    }
}
