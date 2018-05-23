package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionSort {

	public static void main(String[] args) {
		Integer[] intArray = {2,0,1,0,-1,0,1,4};
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.addAll(Arrays.asList(intArray));
		
		for (Integer integer : list) {
			System.out.println("intArray = "+integer);
		}
		
		Collections.sort(list);
		
		System.out.println("\n Sorted ");
		for (Integer integer : list) {
			System.out.println("intArray = "+integer);
		}
		

	}

}
