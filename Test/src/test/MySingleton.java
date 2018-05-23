package test;
public class MySingleton {
		    private static MySingleton myObj;
		     public int num=1;
		    static{
		        myObj = new MySingleton();
		    }
		     
		    private MySingleton(){
		     
		    }
		     
		    public static MySingleton getInstance(){
		        return myObj;
		    }
		     
		    public void testMe(){
		        System.out.println("Hey.... it is working!!!");
		    }
		     
		    public static void main(String a[]){
		    	MySingleton ms = new MySingleton();
		    	MySingleton ms2 = getInstance();
		        ms.testMe();
		        ms2.testMe();
		        System.out.println("ms.num = "+ms.num);
		        System.out.println("ms2.num = "+ms2.num);
		        ms.num =10;
		        System.out.println("ms.num = "+ms.num);
		        System.out.println("ms2.num = "+ms2.num);
		    	
		    }
}
