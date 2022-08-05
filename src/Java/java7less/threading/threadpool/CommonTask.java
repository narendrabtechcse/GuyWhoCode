package Java.java7less.threading.threadpool;

public class CommonTask extends Thread{

    A a1 = new A();

    public void run()
    {
        while(true)
        {
            a1.goToWait();

            for (int i=0;i<10;i++)
            {
                System.out.println(getName() + " : "+i);
                Util.sleep(1000);
            }

            a1.releaseFromWait();
        }
    }
}
