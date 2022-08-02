package Java.java7less.threading.deadlock;

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
