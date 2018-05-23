package threadPrograms.callableAndFuture;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableFuture2 implements Callable<String>{

	 @Override
	    public String call() throws Exception {
		 System.out.println("Inside call - "+Thread.currentThread().getName());
	        Thread.sleep(1000);
	        //return the thread name executing this callable task
	        return " - result = Success - "+Thread.currentThread().getName();
	    }
	    
	    public static void main(String args[]){
	        //Get ExecutorService from Executors utility class, thread pool size is 10
	        ExecutorService executor = Executors.newFixedThreadPool(2);
	        //create a list to hold the Future object associated with Callable
	        List<Future<String>> list = new ArrayList<Future<String>>();
	        //Create MyCallable instance
	        Callable<String> callable = new CallableFuture2();
	        for(int i=0; i< 4; i++){
	            //submit Callable tasks to be executed by thread pool
	            Future<String> future = executor.submit(callable);
	            // call() will start executing from this onwards, Future will be used retrieve the result only, whether success or Exception
	            //add Future to the list, we can get return value using Future
	            //executor.submit(callable).get(); will wait for thread to complete, then it will become Synchronous execution
	            list.add(future);
	        }
	        for(Future<String> fut : list){
	            try {
	                //print the return value of Future, notice the output delay in console
	                // because Future.get() waits for task to get completed
	                System.out.println(new Date()+ "::"+fut.get());
	                // fut.get(); will wait for the thread to complete to which this future object belongs to
	                // fut.isDone(); to check whether thread/task is complete, no matter success or exception
	                //fut.isCancelled() to check if thread/task is being cancelled
	            } catch (InterruptedException | ExecutionException e) {
	                e.printStackTrace();
	            }
	        }
	        //shut down the executor service now
	        executor.shutdown();
	    }
}