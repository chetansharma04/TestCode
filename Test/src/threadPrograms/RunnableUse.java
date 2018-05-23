package threadPrograms;

class threadRunnable implements Runnable{
	public void run(){
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
	}
}

public class RunnableUse {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new threadRunnable());
		t1.start();
	}
}
