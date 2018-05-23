package java8Features.streamPrograms;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*Only stream.reduce() is used without stream.map().reduce()
 * 
 * ReductionOperations: are Terminal functions that provides single output
 * Performs a reduction on the elements of this stream, using an 
 * associative accumulation function, 
 * and returns an Optional describing the reduced value, if any. This is equivalent to: 

 * Not constrained to execute sequentially. 
 * The accumulator function must be an associative function.
 * 
 *  Associativity
An operator or function op is associative if the following holds:

     (a op b) op c == a op (b op c)
 
The importance of this to parallel evaluation can be seen if we expand this to four terms:

     a op b op c op d == (a op b) op (c op d)
 
So we can evaluate (a op b) in parallel with (c op d), and then invoke op on the results.
Examples of associative operations include numeric addition, min, and max, and string concatenation.

 * 
 */
public class ReductionOperations2 {

	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1,2,3,4,5,6);
		
		/*
		 * returns Optional<T> container type object, 
		 * As this also supports 'Else' that is if no value received then Else value will be provided.
		 */
		Optional<Integer> result = values.stream().reduce(Integer::sum);
		System.out.println("Value after reduce (BiFunctional) = "+result );
		
		List<Integer> values2 = Arrays.asList();
		
		Integer result2 = values2.stream().reduce(Integer::sum).orElse(100);	
		/* .orElse(100) is used with reduce() so that if no value returned then 100 will be returned, that is handling null value
		 *  If .orElse(100) provided with reduce() then return type can be as per generic/type of source (List<Integer>)
		* .orElse(<Type of Source>) syntax; 
		*/
		System.out.println("Value after reduce (BiFunctional) with orElse()= "+result2 );

		/*
		 *  Returns a possibly parallel Stream with this collection as its source. It is allowable for this method to return a sequential stream.
		 *  Means multiple threads will be created to do calculation and it will have responsibility of merging/adding intermediate values and last values too.
		 */
		Integer result3 = values2.parallelStream().reduce(Integer::sum).orElse(100);	
		System.out.println("Value after reduce (BiFunctional) with orElse() and parallel stream = "+result3 );

	}

}
