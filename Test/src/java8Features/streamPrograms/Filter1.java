package java8Features.streamPrograms;

import java.util.Arrays;
import java.util.List;

public class Filter1 {

	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1,2,3,4,5,6);
		
		System.out.println("Values greater than 5 are : ");
		values.stream().filter(i -> i >= 5).forEach(System.out::println);
		
		System.out.println("Count of values greater than 5 are : "+ values.stream().filter(i -> i >= 5).count());
		System.out.println("Added values greater than 5 are : "+ values.stream().filter(i -> i >= 5).reduce(Integer::sum).orElse(0));
		
		List<Student> listOfStudent = Student.populateStudentData();
//		Student student = new Student();
		
		System.out.println("----\nCount of student = "+listOfStudent.stream().count());
		System.out.println("----\nCount of student Age > 10 = "+listOfStudent.stream().filter( student -> (student.getAge() > 10)).count());
		System.out.println("----\nNames of student Age > 10 = ");
				listOfStudent.stream().filter( student -> (student.getAge() > 10)).map(Student::getFirstName).forEach(System.out::println);
		
	}

}
