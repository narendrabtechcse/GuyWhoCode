package javamultithreadingandconcurrencysimplifiedudemythreading;

class MyThread6 extends Thread {

    public void run() {

        for( ;; ) {

            if (interrupted()) {
                System.out.println("Thread is interrupted hence stopping..");
                break;
            }

            System.out.print("T");
        }

    }

}

public class Example6 {

    public static void main(String[] args) {

        MyThread6 thr = new MyThread6();
        thr.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //do not use stop() method rather use interrupt method.
        thr.interrupt();
    }

}
