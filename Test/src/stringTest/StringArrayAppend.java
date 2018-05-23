package stringTest;

import org.apache.commons.lang.ArrayUtils;

public class StringArrayAppend {

	public static void main(String[] args) {


		String[] searchResultList = new String[]{"a","b"};
		String[] resultList = new String[]{"c","d"};
			
		String[] append = (String[]) ArrayUtils.addAll(searchResultList, resultList);
		for (String string : append) {
			System.out.println("append = "+string);
		}
		
		
	}

}
