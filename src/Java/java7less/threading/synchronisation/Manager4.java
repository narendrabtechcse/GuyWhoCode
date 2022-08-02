package Java.java7less.threading.synchronisation;

public class Manager4 {

    public static void main(String[] args) {
        Shared s1 = new Shared();
        Shared s2 = new Shared();

        A a1 = new A(s1);

       // B b1 = new B(s1);

        B b1 = new B(s1);

        a1.start();

        b1.start();
    }
}
