package threadPrograms;

import java.util.concurrent.atomic.AtomicInteger;

//R&D of synchronized method
public class SynchronizedMethod2 {
	public static void main(String[] args) throws InterruptedException {
		SynchronizedMethod2Table obj = new SynchronizedMethod2Table();//only one shared object  
		SynchronizedMethod2MyThread1 t1=new SynchronizedMethod2MyThread1(obj,2);  
		t1.start();  
		t1.setPriority(Thread.MAX_PRIORITY);
		
		SynchronizedMethod2MyThread2 t2=new SynchronizedMethod2MyThread2(obj,3);  
		t2.start();  
		}  
}
//shared resource
class SynchronizedMethod2Table{
	AtomicInteger num = new AtomicInteger(99);
	synchronized void  printTable(int n){
		 {
			 System.out.println("this = "+this.getClass().getName());
		for (int i = 1; i <= 3; i++) {
			System.out.println("Thread id = "+Thread.currentThread().getId());
			System.out.println("num = "+(num.incrementAndGet()));
		try{  
		      Thread.sleep(2000);  
		     }catch(Exception e){System.out.println(e);}  		
	   }
		 }
	  }
	
	synchronized void changeNum(){
		{
		System.out.println("Thread id = "+Thread.currentThread().getId());
		num.set(88);
		System.out.println("changed num = " + num +"\n");
		}
	}
	
}

class SynchronizedMethod2MyThread1 extends Thread{
	SynchronizedMethod2Table t;
	int num;
	public SynchronizedMethod2MyThread1(SynchronizedMethod2Table t, int num) {
		this.t = t;
		this.num = num;
	}
	
	public void run(){
		t.printTable(num);
	}
}

class SynchronizedMethod2MyThread2 extends Thread{
	SynchronizedMethod2Table t;
	int num;
	public SynchronizedMethod2MyThread2(SynchronizedMethod2Table t, int num) {
		this.t = t;
		this.num = num;
	}
	
	public void run(){
		t.changeNum();
		t.printTable(num);
	}
}