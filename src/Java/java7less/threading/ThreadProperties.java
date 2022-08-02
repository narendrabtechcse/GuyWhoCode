package Java.java7less.threading;

public class ThreadProperties {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();

        System.out.println(t.getId());


        System.out.println(t.getContextClassLoader());

        System.out.println(t.getName());

        System.out.println(t.getPriority());

        System.out.println(t.getStackTrace());

        System.out.println(t.getThreadGroup());

        System.out.println(t.getUncaughtExceptionHandler());



    }
}
