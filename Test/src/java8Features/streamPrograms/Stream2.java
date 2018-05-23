package java8Features.streamPrograms;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
//ways to build/get stream
public class Stream2 {

	public static void main(String[] args) throws Exception {
		List<Integer> values = Arrays.asList(1,2,3,4,5);
		values.stream().forEach(System.out::println);
		
		//HashMap stream
		Map<Integer, String> map = new HashMap<Integer,String>();
		map.put(1, "One"); map.put(2, "Two");map.put(3, "Three");
		map.keySet().stream().forEach(System.out::println);
		map.values().stream().forEach(System.out::println);
		
		Set<String> setInteger = new HashSet<String>();
		setInteger.add("SetElement1");setInteger.add("SetElement2");setInteger.add("SetElement1");
		setInteger.stream().forEach(System.out::println);
		
		//Creating Stream of hardcoded Strings and printing each String
		Stream.of("This", "is", "Java8", "Stream").forEach(System.out::println);
		
		//Creating stream of arrays
		String[] stringArray = new String[]{"Streams", "can", "be", "created", "from", "arrays"};
		Arrays.stream(stringArray).forEach(System.out::println);
		        
		//Creating BufferedReader for a file
		BufferedReader reader = Files.newBufferedReader(Paths.get("c:/testCode/File.txt"), StandardCharsets.UTF_8);
		//BufferedReader's lines methods returns a stream of all lines
		reader.lines().forEach(System.out::println);
	}

}
