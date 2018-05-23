package java8Features;

import java.util.Arrays;
import java.util.List;

public class Lambda1 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2,3,4,5,6);
		
		for (Integer i : list) {
			System.out.println(i);
		}
		
		list.forEach(chetan -> System.out.println(chetan));

	}

}
