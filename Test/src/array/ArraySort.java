package array;

import java.util.Arrays;

public class ArraySort {

	public static void main(String[] args) {
		int[] intArray = {2,0,1,0,-1,0,1,4};
		
		for (int itr = 0; itr < intArray.length; itr++) {
			System.out.println("intArray = "+intArray[itr]);
		}
		Arrays.sort(intArray);
		for (int itr = 0; itr < intArray.length; itr++) {
			System.out.println("\n Sorted intArray = "+intArray[itr]);
		}
		

	}

}
