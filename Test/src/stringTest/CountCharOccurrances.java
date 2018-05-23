package stringTest;

import java.util.HashSet;
import java.util.Set;

public class CountCharOccurrances {
	public static void main(String[] args) {
		String str = "abcdaser;kgu986khgfkhgf";
		System.out.println("str = "+str);

		char[] charArray = str.toCharArray();
		Set<Character> charSet = new HashSet<Character>();
		
		 for (int i = 0; i < charArray.length; i++) {
	          charSet.add(charArray[i]);
	      }
		 
		
//		int count = Stream.of(str).filter("a".equalsIgnoreCase(str))
		long count = str.chars().filter(ch -> ch=='a').count();
		System.out.println("count of 'a' = "+count);
	}
}