package javamultithreadingandconcurrencysimplifiedudemy.DaemonThreadEx.src;

class MyTask1 implements Runnable {
	
	@Override
	public void run() {
		for (;;) {
			System.out.print("T");
		}
	}
}

class Main101 {

	public static void main(String[] args) {
		
		Thread thr = new Thread(new MyTask1());
		thr.setDaemon(true);
		thr.start();
		
		for (int i=1; i <= 200; i++) {
			System.out.print(" M ");
		}
	}
}

