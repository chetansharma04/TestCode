package java8Features.streamPrograms;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

//test stream programs : R&D

public class StreamTest {

	public static void main(String[] args) throws Exception {

		List<Integer> values = Arrays.asList(1,2,3,4,5);
		Stream<Integer> streamList = values.stream();
		for (Iterator<Integer> iterator = streamList.iterator(); iterator.hasNext();) {
//			Integer integer = (Integer) iterator.next();
			System.out.println("Itr = "+iterator.next());
			
		}
		
		System.out.println("Reading from Arrays.asList");
		values.stream().forEach(System.out::println);
		System.out.println("Reading from Arrays.asList Ends-------------------------------\n");
		
		
		
	}

}
