package threadPrograms;

// A thread is created using class Thread 
// main method start first and end last using join() with each thread

class NewThread extends Thread{
	public void run(){
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
	}
}

public class ThreadUse {
	public static void main(String[] args) throws InterruptedException {
		NewThread t1 = new NewThread();
		t1.start();
	}
}
