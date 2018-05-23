package java8Features;

@FunctionalInterface
interface I1{
	void convertAndShow(String str);
}

class StringParser2 {
	StringParser2(){}
	
	StringParser2(String str){
		System.out.println("In StringParser2 Constructor with str = "+str);
	}
	public void convertLowerCase(String str){
		System.out.println(str.toLowerCase());
	}
	
	static void convertUpperCase(String str){
		System.out.println(str.toUpperCase());
	}
}

class MyPrinter2{
	public static void myPrinter(String str, I1 i1Obj){
		i1Obj.convertAndShow(str);
	}
}
public class MethodReference_Simple3 {

	public static void main(String[] args) {
		StringParser2 stringParser = new StringParser2();
		MyPrinter2.myPrinter("Chetan Sharma", stringParser::convertLowerCase);// instance method reference
		MyPrinter2.myPrinter("Chetan Sharma", StringParser2::convertUpperCase);// static or class method reference
		MyPrinter2.myPrinter("Chetan Sharma", StringParser2::new);// Constructor method reference
		
		
	}

}
