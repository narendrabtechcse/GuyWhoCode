package Java.java7less.threading;

public class SecondWayCreateThread extends Thread{

    SecondWayCreateThread()
    {
        start();
    }

    public void run()
    {
        for (int i=0;i<1000;i++)
        {
            System.out.println(i);
        }
    }

}

class Manager3{
    public static void main(String[] args)
    {
        SecondWayCreateThread a1 = new SecondWayCreateThread();

        for (int j=1000;j<2000;j++)
        {
            System.out.println(j);
        }
    }
}
