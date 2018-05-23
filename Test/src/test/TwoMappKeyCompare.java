package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoMappKeyCompare {
	public static void main(String[] args) {
		System.out.println("Chetan");
		
		Map<String, String> mapA = new HashMap<String, String>();
		mapA.put("A", "1");
		mapA.put("B", "2");
		mapA.put("C", "3");

		Map<String, String> mapB = new HashMap<String, String>();
		mapB.put("A", "1");
		mapB.put("D", "4");
		
		Set<String> keysInA = new HashSet<String>(mapA.keySet());
		Set<String> keysInB = new HashSet<String>(mapB.keySet());

		// Keys in A and not in B
		Set<String> inANotB = new HashSet<String>(keysInA);
		inANotB.removeAll(keysInB);
		
		System.out.println("inANotB = "+inANotB);
		
	}

}
