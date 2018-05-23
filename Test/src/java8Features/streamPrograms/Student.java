package java8Features.streamPrograms;

import java.util.ArrayList;
import java.util.List;

public class Student {

	static List<Student> populateStudentData(){
		List<Student> studentsList = new ArrayList<Student>();
		Student student1 = new Student();
		student1.age = 10;
		student1.score = 60;
		student1.firstName = "Chetan";
		student1.lastName = "Sharma";
		studentsList.add(student1);
		
		Student student2 = new Student();
		student1.score = 70;
		student2.age = 11;
		student2.firstName = "Snehlata";
		student2.lastName = "Sharma";
		studentsList.add(student2);
		
		Student student3 = new Student();
		student3.score = 90;
		student3.age = 12;
		student3.firstName = "Vanshika";
		student3.lastName = "Sharma";
		studentsList.add(student3);
		
		return studentsList;
		
	}
	
	String firstName;
	String lastName;
	Integer age;
	Integer score;
	
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	

}
