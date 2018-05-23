package threadPrograms;

class threadRunnable2 implements Runnable{
	
	public void run(){
		System.out.println("Thread "+Thread.currentThread().getName()+" start");
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
		
		System.out.println("Thread "+Thread.currentThread().getName()+" stop");

	}
}

public class ThreadJoin_MainLastEnd {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("main method start");
		
		Thread t1 = new Thread(new threadRunnable2());
//		t1.setName("t1");
		t1.start();
		t1.join();
		
		Thread t2 = new Thread(new threadRunnable2());
//		t2.setName("t2");
		t2.start();
		t2.join();
		
		Thread t3 = new Thread(new threadRunnable2());
//		t3.setName("t3");
		t3.start();
		t3.join();
		
		System.out.println("main method stop");
		
	}

}
