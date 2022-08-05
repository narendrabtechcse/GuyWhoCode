package javamultithreadingandconcurrencysimplifiedudemythreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Sample9 {

    private int x;

    ReadWriteLock rw_lock = new ReentrantReadWriteLock();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void incr() {

        Lock lock = rw_lock.writeLock();
        lock.lock();
        try {

            int y = getX();
            y++;

            // Just for simulation
            try { Thread.sleep(1); } catch(Exception e) {}

            setX(y);
        } finally {
            lock.unlock();
        }

    }

}

class MyThread9 extends Thread {

    Sample9 obj;

    public MyThread9(Sample9 obj) {
        this.obj = obj;
    }

    public void run() {
        obj.incr();
    }

}

public class Example9 {

    public static void main(String[] args) {

        Sample9 obj = new Sample9();
        obj.setX(10);

        MyThread9 t1 = new MyThread9(obj);
        MyThread9 t2 = new MyThread9(obj);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println( obj.getX() );
    }
}
