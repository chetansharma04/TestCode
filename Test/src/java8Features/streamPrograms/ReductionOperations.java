package java8Features.streamPrograms;

import java.util.Arrays;
import java.util.List;

/*
 * map() and reduce() both are used
 * 
 * map() vs reduce() as both are used for value manipulations
 * As map() is intermediate operation it returns another Stream after operation
 * reduce() does return single value as it is terminal operation. 
 * Returns:the new stream
 * 
 * map() syntax:
	<Integer> Stream<Integer> java.util.stream.Stream.map(Function<? super Integer, ? extends Integer> mapper)
	Type Parameters:<R> The element type of the new streamParameters:
	mapper a non-interfering, stateless function to apply to each element
	
 */
public class ReductionOperations {

	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1,2,3,4,5,6);
		System.out.println("Value after reduce with Lambda= "+values.stream().map(i -> i*2).reduce(0,(t,u) -> t+u) );
		
		System.out.println("Value after reduce with Lambda= "+values.stream().map(i -> i*2).reduce(Integer::sum) );
		
		
		List<Double> valuesInDouble = Arrays.asList(1.1,2.2,3.2,4.2,5.2,6.2);
		System.out.println("Value after reduce with Lambda= "+valuesInDouble.stream().map(i -> i*2).reduce(0.0,(t,u) -> t+u) );
		System.out.println("Value after reduce with Lambda= "+valuesInDouble.stream().map(i -> i*2).reduce(Double::sum) );
		
		
		
	}

}
