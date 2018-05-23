package stringTest;

public class StringEqualsTest {

	public static void main(String[] args) {
		
		String str1 = "Chetan";
		String str2 = new String("Chetan");
		System.out.println("String == "+str1 == str2);
		System.out.println("String equals = "+str1.equals(str2));
		
		
		String str3 = new String("chetan");
		System.out.println("\nString equals = "+str1.equals(str3));
		System.out.println("String equals = "+str1.equalsIgnoreCase(str3));
		
		
		//equals or == for Integer
		
		Integer num1 = new Integer(10);
		Integer num2 = new Integer(10);
		System.out.println("\nInteger == "+(num1 == num2));
		System.out.println("Integer == "+(num1.intValue() == num2.intValue()));
		System.out.println("Integer == "+(num1.equals(num2)));
		
		
		Integer num3 = new Integer(30);
	}

}
