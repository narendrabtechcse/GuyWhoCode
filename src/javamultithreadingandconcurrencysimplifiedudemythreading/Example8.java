package javamultithreadingandconcurrencysimplifiedudemythreading;


class Sample8 {

    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void incr() {
        int y = getX();
        y++;

        // Just for simulation
        try { Thread.sleep(1); } catch(Exception e) {}

        setX(y);
    }

}

class MyThread8 extends Thread {

    Sample8 obj;

    public MyThread8(Sample8 obj) {
        this.obj = obj;
    }

    public void run() {
        synchronized(obj) {
            obj.incr();
        }
    }

}


public class Example8 {

    public static void main(String[] args) {

        Sample8 obj = new Sample8();
        obj.setX(10);

        MyThread8 t1 = new MyThread8(obj);
        MyThread8 t2 = new MyThread8(obj);

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

