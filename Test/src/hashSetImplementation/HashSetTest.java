package hashSetImplementation;

import java.util.HashMap;
import java.util.HashSet;

public class HashSetTest {

	public static void main(String[] args) {

		HashMap hm = new HashMap<String,String>();
		hm.put(1, "One");

		HashSet hs = new HashSet();
		hs.add("chetan");
		
		int num = 10 ;
		char ch = 'a';
		float fl = 1.1f;
		
		System.out.println("num = "+num);
		System.out.println("ch = "+ch);
		System.out.println("fl = "+fl);
		
		Integer intNum = 20;
		intNum = intNum +10;
		System.out.println("intNum = "+intNum);
		
		num = intNum;
		System.out.println("num = "+num);
		
			
		

	}

}
