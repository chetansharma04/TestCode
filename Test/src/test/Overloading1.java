package test;

import java.util.Date;

public class Overloading1 {

	public static void main(String[] args) {

		System.out.println("Chetan");
		method1("");
		
	}

	
	public static void method1(String str){
		System.out.println("In method1");
	}

	public static void method1(Date date){
		System.out.println("In method2");
	}
}
