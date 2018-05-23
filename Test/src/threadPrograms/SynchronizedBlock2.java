package threadPrograms;

public class SynchronizedBlock2 {
	public static void main(String[] args) throws InterruptedException {
		SynchronizedBlock2Table obj = new SynchronizedBlock2Table();//only one shared resource
		
		SynchronizedBlock2MyThread t1=new SynchronizedBlock2MyThread(obj,1);  
		t1.start();  

		SynchronizedBlock2MyThread t2=new SynchronizedBlock2MyThread(obj,10);  
		t2.start();  
		}  
}
//shared resource
class SynchronizedBlock2Table{
	Integer num = 99;
	  void printTable(int n){
//		synchronized(this){
			System.out.println("num = "+num);
			for (int i = 1; i <= 5; i++) {
		
			System.out.println(n * i);
		
		try{  
		      Thread.sleep(400);  
		     }catch(Exception e){System.out.println(e);}  		
	   }
	  }
//	  }
}

class SynchronizedBlock2MyThread extends Thread{
	SynchronizedBlock2Table t;
	int num;
	public SynchronizedBlock2MyThread(SynchronizedBlock2Table t, int num) {
		this.t = t;
		this.num = num;
	}
	
	public void run(){
		System.out.println("Thread id = "+this.getId());
		t.printTable(num);
	}
}