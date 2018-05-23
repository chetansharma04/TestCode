package array;

import java.util.HashSet;
import java.util.Set;

public class DuplicatesInArray {

	public static void main(String[] args) {
			int[] intArray = {2,0,1,0,-1,0,1,4,2};
			
			Set<Integer> set = new HashSet<Integer>();
			Set<Integer> setDuplicate = new HashSet<Integer>();
			
			System.out.println("Original");
		for (int itr = 0; itr < intArray.length; itr++) {
			if(set.contains(intArray[itr])){
				setDuplicate.add(intArray[itr]);
			}
			set.add(intArray[itr]);
			System.out.println("intArray = "+intArray[itr]);
		}

		System.out.println("Duplicate");
		for (Integer integer : setDuplicate) {
			System.out.println(integer);
		}
		
		
	}

}
