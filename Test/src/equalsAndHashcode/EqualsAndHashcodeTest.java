package equalsAndHashcode;

public class EqualsAndHashcodeTest {

	public static void main(String[] args) {
		
		String str1 = new String("Chetan");
		String str2 = new String("Sharma");
		
		System.out.println("str1.equals(str2) = "+str1.equals(str2) );
		System.out.println("str1.hashCode() = "+str1.hashCode() );
		System.out.println("str2.hashCode() = "+str2.hashCode() );

	}

}
