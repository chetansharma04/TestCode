package threadPrograms;

public class DeadLock1 {

	public static void main(String[] args) {
		final String str1 = "Chetan";
		final String str2 = "Sharma";

		Thread t1 = new Thread(){
			public void run(){
				synchronized(str1){
					System.out.println("Thread 1 locked str1,  Waiting for str2");
					try {
						Thread.sleep(20000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				synchronized(str2){
					System.out.println("Thread 1 locked str2");
				}
			}
		};

		//Thread 2
		Thread t2 = new Thread(){
			public void run(){
				synchronized(str2){
					System.out.println("Thread 2 locked str2,  Waiting for str1");
					try {
						Thread.sleep(20000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			
				synchronized(str1){
					System.out.println("Thread 2 locked str1");
				}
			}
		};
		
		t1.start();
		t2.start();
		
		
	}
}
