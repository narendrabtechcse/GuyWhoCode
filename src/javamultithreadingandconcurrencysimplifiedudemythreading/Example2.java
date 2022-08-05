package javamultithreadingandconcurrencysimplifiedudemythreading;

class Task2 extends Thread {

    public void run() {
        doTask();
    }

    public void doTask() {
        for(int i=1; i <= 1500; i++) {
            System.out.print("T");
        }
    }
}

public class Example2 {

    public static void main(String[] args) {

        Task2 t1 = new Task2();
        t1.start();

        for(int i=1; i <= 1500; i++) {
            System.out.print("M");
        }

    }

}