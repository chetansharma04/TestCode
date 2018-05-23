package hashSetImplementation;

import java.util.HashMap;
import java.util.Map;

public class hashMapTest {

	
	private static transient HashMap<Object,Object> map;

	// Dummy value to associate with an Object in the backing Map
	private static final Object PRESENT = new Object();

	public boolean add(Object e) {
	   return map.put(e, PRESENT)==null;
	}


	public static void main(String[] args) {
		map = new HashMap<Object,Object>();
		System.out.println("1 = "+map.put("chetan", "1"));
		System.out.println("1 = "+map.put("chetan", "1"));
		
	}

}
