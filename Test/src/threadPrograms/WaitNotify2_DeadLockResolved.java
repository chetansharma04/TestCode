package threadPrograms;

public class WaitNotify2_DeadLockResolved {
	public static void main(String[] args) {
		final String str1 = "chetan";
		final String str2 = "sharma";
		
		Thread t1 = new Thread(){
			public void run(){
				synchronized(str1){
					//do required tasks on str1
					System.out.println("thread 1 locked str1, wating for str2");
					try {
//						Thread.sleep(20000);
						str1.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				synchronized(str2){
					//do required tasks on str2
					System.out.println("thread 1 locked str2 also");
				}
			}
		};

		Thread t2 = new Thread(){
			public void run(){
				synchronized(str2){
					//do required tasks on str2
					System.out.println("thread 2 locked str2, wating for str1");
				}
				
				synchronized(str1){
					//acquire lock on str1 --> do required tasks on str1 --> release 
					System.out.println("thread 2 locked str1 also");
					str1.notify();
				}
			}
		};

		t1.start();
		t2.start();
	}
}
