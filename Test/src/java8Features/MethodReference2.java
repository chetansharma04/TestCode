package java8Features;

interface Parser{
	String show(String str);
}

class StringParser{
	public String convertLowerCase(String str){
		return str.toLowerCase();
	}
}

class MyPrinter{
	public static void myPrinter(String str, Parser parser){
		str= parser.show(str);
		System.out.println(str);
	}
}

public class MethodReference2 {

	public static void main(String[] args) {
		StringParser stringParser = new StringParser();
		String str = "Chetan Sharma";

		MyPrinter.myPrinter(str, stringParser::convertLowerCase);
	}
}
