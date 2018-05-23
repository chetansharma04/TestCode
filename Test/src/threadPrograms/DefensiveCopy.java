package threadPrograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefensiveCopy {
	public static void main(String[] args) {
			List<String> readOnlyList = new ArrayList<String>();
			readOnlyList.add("aaa");
			readOnlyList.add("bbb");
			readOnlyList.add("ccc");
			System.out.println("Initial copy of readOnlyList");
			readOnlyList.forEach(System.out::println);
			
			List<String> defensiveCopy = (List<String>) Collections.unmodifiableCollection(readOnlyList);
			
			readOnlyList.add("eee");
			System.out.println("After modification readOnlyList");
			readOnlyList.forEach(System.out::println);
			
			defensiveCopy.add("fff");
			System.out.println("defensiveCopy List");
			readOnlyList.forEach(System.out::println);
			
			
			
		
		
	}

}
