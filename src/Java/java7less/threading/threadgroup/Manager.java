package Java.java7less.threading.threadgroup;

public class Manager {

    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("first group");

        A a1 = new A(tg);
        C c1 = new C(tg);

        B b1 = new B();
        D d1 = new D();

        Thread t1 = new Thread(tg,b1);
        Thread t2 = new Thread(tg,d1);

        a1.start();
        c1.start();
        t1.start();
        t2.start();
        tg.destroy();

        System.out.println("Stopped all threads");
    }
}
