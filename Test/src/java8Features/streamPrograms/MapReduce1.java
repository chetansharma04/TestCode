package java8Features.streamPrograms;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class MapReduce1 {

	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1,2,3,4,5,6);
		
//		System.out.println(values.stream().map(i -> i * 2).reduce(0, (c,e) -> c + e));
		
		Stream<Integer> stream = values.stream();// will convert all values to stream, that is reference to stream type object
		System.out.println("Stream Iteration");//Stream = java.util.stream.ReferencePipeline$Head@6d06d69c
		stream.forEach(System.out::println);
		
		/*		map converts value from one format to another or select a column from pojo (select <columnName> from table)
*		As it is intermediate operation thus will return another Stream
*		syntax map(Function mapper);
*		other Map type operations mapToDouble(ToDoubleFunction mapper) returns DoubleStream
*
		Function is an interface in java.util.funcation package
		This is a functional interface that accepts one argument and produces a result. 
		whose functional method is apply(Object).
		Function<T t, R r); // t= input parameter, R = return type
		Type Parameters:<T> the type of the input to the function<R> the type of the result of the function
**/		
		Function<Integer, Integer> function1 = new Function<Integer, Integer>(){
			public Integer apply(Integer i){
				return i * 2 ;
			}
		};
		
		Stream<Integer> stream2 = values.stream();// as we cannot use old Stream object, thus created new stream
		System.out.println("After Map-Function withou Lambda");
		Stream<Integer> streamMap = stream2.map(function1);
		streamMap.forEach(System.out::println);
		
		//above code in Lambda Expression
		Stream<Integer> stream3 = values.stream();// as we cannot use old Stream object
		System.out.println("After Map-Function in Lambda format");
		Stream<Integer> streamMap2 = stream3.map(i -> i*2);
		streamMap2.forEach(System.out::println);
		//above code in Lambda Expression ends
		
		Stream<Integer> stream4 = values.stream();// as we cannot use old Stream object
		System.out.println("After Map-Function in Lambda format");
		Stream<Integer> streamMap5 = stream4.map(i -> i*2);
		
		//Create Binary operator for stream.reduce()
		BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer t, Integer u) {
				
				return t + u;
			}
		};
		
		
		Integer result = values.stream().map(i -> i*2).reduce(0,binaryOperator); 
		/* Terminal function that provides single value as output for the stream
		 * reduce first parameter is start parameter, second is Functional Interface 
		 * in our example 1,2,3,4,5,6  --> using map() converted to 2,4,6,8,10,12 
		 * reduce will do 0 (first parameter in reduce) + 2 = 2, 2 + 4 = 6, 6 + 6 = 12, 12 + 8 = 20, 20 + 10 = 30, 30 + 12 = 42
		 * 
		 * // @Override
			public Integer apply(Integer t, Integer u) {    ..... }
			
			Is an un-implemented method in BinaryOperator Extended interface 
			BiFunction<T, U, R> a @FunctionalInterface
			Represents a function that accepts two arguments and produces a result. This is the two-arity specialization of Function. 
			This is a functional interface whose functional method is apply(Object, Object).
			Type Parameters:<T> the type of the first argument to the function<U> the type of the second argument to the function<R> the type of the result of the function
		 */
		System.out.println("Value after reduce without Lambda= "+result);
		
		
		//Above code after Lambda
		System.out.println("Value after reduce with Lambda= "+values.stream().map(i -> i*2).reduce(0,(t,u) -> t+u) );
		
		
		
	}

}
