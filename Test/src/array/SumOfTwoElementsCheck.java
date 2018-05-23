package array;

public class SumOfTwoElementsCheck {

	public static void main(String[] args) {
		int[] intArray = {2,0,1,0,-1,0,1,4};
		
		int sumToCheck = 3;
		
		System.out.print("intArray = ");
		for (int itr = 0; itr < intArray.length; itr++) {
			System.out.print(intArray[itr]+", ");
		}

		System.out.println("\nTwo no.s are ");
		for (int itr = 0; itr < intArray.length; itr++) {
			for (int itr2 = 1; itr2 < intArray.length; itr2++) {
				if(sumToCheck == (intArray[itr] + intArray[itr2])){
					System.out.println((intArray[itr] +" , "+ intArray[itr2]));
				}
			}
		
		}

		
	}

}
