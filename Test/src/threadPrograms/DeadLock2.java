package threadPrograms;

public class DeadLock2 {
	public static void main(String[] args) {
		final String str1 = "chetan";
		final String str2 = "sharma";
		
		Thread t1 = new Thread(){
			public void run(){
				synchronized(str1){
					System.out.println("thread 1 locked str1, wating for str2");
					try {
						Thread.sleep(20000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				synchronized(str2){
					System.out.println("thread 1 locked str2 also");
				}
			}
		};

		Thread t2 = new Thread(){
			public void run(){
				synchronized(str2){
					System.out.println("thread 2 locked str2, wating for str1");
					try {
						Thread.sleep(20000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				synchronized(str1){
					System.out.println("thread 2 locked str1 also");
				}
			}
		};

		t1.start();
		t2.start();
	}
}
