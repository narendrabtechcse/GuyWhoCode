package Java.java7less.threading.threadpool;

public class Util {
    static void sleep(long millis)
    {
        try{
            Thread.sleep(millis);
        }catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }
}
