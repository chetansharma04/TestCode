package threadPrograms;

public class ThreadJoinMethod extends Thread{
	
	public ThreadJoinMethod(String string) {
		this.setName(string);
	}
	
		 public void run(){
		  for(int i=1;i<=5;i++){
		   try{
		    Thread.sleep(1000);
		   }catch(Exception e){System.out.println(e);}
		  System.out.println(this.getName()+" - "+i);
		  }
		 }
		 
	public static void main(String[] args) {
		ThreadJoinMethod t1=new ThreadJoinMethod("t1");
		ThreadJoinMethod t2=new ThreadJoinMethod("t2");
		ThreadJoinMethod t3=new ThreadJoinMethod("t3");
		 t1.start();
		 try{
		  t1.join();
		 }catch(Exception e){System.out.println(e);}
		t2.setPriority(10);
		 t2.start();
		 t3.start();
		 }

}

	

