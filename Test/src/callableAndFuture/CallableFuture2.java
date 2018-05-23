package callableAndFuture;

import java.util.concurrent.Callable;

class CallableFutureThread implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}

public class CallableFuture2{

	public static void main(String[] str){
		CallableFutureThread callableFutureThread = new CallableFutureThread();
		
		Thread t1 = new Thread(callableFutureThread);
		
	}
	
}
