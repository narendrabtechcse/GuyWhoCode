package javamultithreadingandconcurrencysimplifiedudemy.ThreadGroupsEx.src;

class MyTask105 implements Runnable {
	
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

 class Main105 {

	public static void main(String[] args) {
		
		ThreadGroup myGroup = new ThreadGroup("MyGroup");
		myGroup.setMaxPriority(4);
		
		Thread myThread = new Thread(myGroup, new MyTask105(), "DemoThread");
		myThread.start();
	
		System.out.println("System threads..........");
		Thread thr = Thread.currentThread();
		ThreadGroup grp = thr.getThreadGroup();
		while (grp.getParent() != null) {
			grp = grp.getParent();
		}
		grp.list();
		
	}

}
