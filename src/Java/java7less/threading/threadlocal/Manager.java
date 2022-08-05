package Java.java7less.threading.threadlocal;

public class Manager {

    public static void main(String[] args) {

        ThreadLocal t = new ThreadLocal();

        Thread1 t1 = new Thread1(t);

        Thread2 t2 = new Thread2(t);

        t.set(90);

        t1.start();

        Util.sleep(50);

        System.out.println("9 : "+ t.get());

        t2.start();

        Util.sleep(5000);

        System.out.println(" 10 : "+ t.get());
    }
}
