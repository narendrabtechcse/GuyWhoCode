package Java.java7less.threading.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Manager5 {

    public static void main(String[] args) {
        Shared s1 = new Shared();
        Shared s2 = new Shared();

        A a1 = new A(s1,s2);
        B b1 = new B(s1,s2);

        a1.start();
        b1.start();


        Util.sleep(10000);

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        long[] ids = threadMXBean.findDeadlockedThreads();

        if(ids!=null)
        {
            System.out.println("Threads are under deadlock !!");

            for (long id : ids)
            {
                System.out.println(id);
            }
        }else{
            System.out.println("No threads are under deadlock !!");
        }
    }
}
