package Java.java7less.threading;

class B implements Runnable
{
    public void run()
    {
        for(int i=0;i<1000;i++)
        {
            System.out.println(i);
        }
    }
}

class Manager {
    public static void main(String[] args){
    B b1 = new B();
    Thread t1 = new Thread(b1);
    t1.start();

    for(int i=1000;i<2000;i++)
    {
        System.out.println(i);
    }
    }
}
