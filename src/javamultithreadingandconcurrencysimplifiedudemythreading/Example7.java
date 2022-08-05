package javamultithreadingandconcurrencysimplifiedudemythreading;

class Sample {

    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public synchronized void incr() {

        int y = getX();
        y++;

        // Just for simulation
        try { Thread.sleep(1); } catch(Exception e) {}

        setX(y);
    }

}

class MyThread7 extends Thread {

    Sample obj;

    public MyThread7(Sample obj) {
        this.obj = obj;
    }

    public void run() {
        obj.incr();
    }

}


public class Example7 {

    public static void main(String[] args) {

        Sample obj = new Sample();
        obj.setX(10);

        MyThread7 t1 = new MyThread7(obj);
        MyThread7 t2 = new MyThread7(obj);

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
