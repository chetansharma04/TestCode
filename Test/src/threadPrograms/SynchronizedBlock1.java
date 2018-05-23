package threadPrograms;

public class SynchronizedBlock1 {
	public static void main(String[] args) throws InterruptedException {
		Table2 obj = new Table2();//only one object  
		MyThread2 t1=new MyThread2(obj,1);  
		t1.start();  

		MyThread2 t2=new MyThread2(obj,10);  
		t2.start();  
		}  
}
//shared resource
class Table2{
	  void printTable(int n){
		synchronized(this){
			for (int i = 1; i <= 5; i++) {
		
			System.out.println(n * i);
		
		try{  
		      Thread.sleep(400);  
		     }catch(Exception e){System.out.println(e);}  		
	   }
	  }
	  }
}

class MyThread2 extends Thread{
	Table2 t;
	int num;
	public MyThread2(Table2 t, int num) {
		this.t = t;
		this.num = num;
	}
	
	public void run(){
		System.out.println("Thread id = "+this.getId());
		t.printTable(num);
	}
}