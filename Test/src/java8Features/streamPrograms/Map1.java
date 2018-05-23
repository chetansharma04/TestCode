package java8Features.streamPrograms;

import java.util.List;

public class Map1 {

	public static void main(String[] args) {
		List<Student> studentList =  Student.populateStudentData();
//		studentList.forEach(System.out::println);
		
		studentList.stream().map(Student::getFirstName).forEach(System.out::println);
		

	}

}
