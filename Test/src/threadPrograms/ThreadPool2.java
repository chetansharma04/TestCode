package threadPrograms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*using threadRunnable class from same package
 * 
*/

public class ThreadPool2 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("main method start");
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		for (int i = 0; i < 10; i++) {
			WorkerThread workerThread = new WorkerThread(""+i);
			executorService.execute(workerThread);
		}
		
		
		executorService.shutdown();
		
		System.out.println("main method stop");
	}

}
