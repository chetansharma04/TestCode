package threadPrograms;
//running example of synchronized method
public class SynchronizedMethod1 {
	public static void main(String[] args) throws InterruptedException {
		SynchronizedMethod1Table obj = new SynchronizedMethod1Table();//only one object  
		SynchronizedMethod1MyThread1 t1=new SynchronizedMethod1MyThread1(obj,2);  
		t1.start();  

		SynchronizedMethod1MyThread1 t2=new SynchronizedMethod1MyThread1(obj,3);  
		t2.start();  
		}  
}
//shared resource
class SynchronizedMethod1Table{
	  synchronized void printTable(int n){
		  System.out.println("Thread id = "+Thread.currentThread().getId());
		  for (int i = 1; i <= 5; i++) {
			System.out.println(n * i);
		try{  
		      Thread.sleep(400);  
		     }catch(Exception e){System.out.println(e);}  		
	   }
	  }
}

class SynchronizedMethod1MyThread1 extends Thread{
	SynchronizedMethod1Table t;
	int num;
	public SynchronizedMethod1MyThread1(SynchronizedMethod1Table t, int num) {
		this.t = t;
		this.num = num;
	}
	
	public void run(){
		t.printTable(num);
	}
}