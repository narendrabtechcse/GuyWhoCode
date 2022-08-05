package Java.java7less.threading.threadpool;

public class Manager {
    public static void main(String[] args) {
        PoolManager pm = new PoolManager();
        pm.init();
        User1 u1 = new User1(pm);
        User2 u2 = new User2(pm);
        User3 u3 = new User3(pm);

        u1.start();
        u2.start();
        u3.start();

    }
}
