package java8Features;

import java.util.Arrays;
import java.util.List;

public class MethodReference1 {

	public static void main(String[] args) {

		List<String> values = Arrays.asList("Chetan","Sharma");
		values.forEach(System.out::println);
		/*
		 *  '::' means provided input 'println' is a method. not a variable. 
		 *  without this, program will consider this as a variable input
		 *  
		 */

		
	}

}
