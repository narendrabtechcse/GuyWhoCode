package Java.java7less.threading.deadlock;

public class Manager5 {

    public static void main(String[] args) {
        Shared s1 = new Shared();
        Shared s2 = new Shared();

        A a1 = new A(s1,s2);
        B b1 = new B(s1,s2);

        a1.start();
        b1.start();
    }
}
