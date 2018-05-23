package java8Features;

import java.util.Comparator;

@FunctionalInterface
interface DisplayNameInterface2{
	String displayName(String fName, String lName);
	
}

class DisplayNameInterface2Impl implements DisplayNameInterface2{

	@Override
	public String displayName(String fName, String lName) {
		return "Name = "+ (fName) + " - " + lName;
	}
	
}

public class Lambda3 {

	public static void main(String[] args) {

		//Way 1 
		DisplayNameInterface2 displayNameInterface2Impl = new DisplayNameInterface2Impl();

		System.out.println(displayNameInterface2Impl.displayName("Chetan", "Sharma"));
		
//		Way 2
		DisplayNameInterface2 displayNameInterface2Impl2 = new DisplayNameInterface2(){

			@Override
			public String displayName(String fName, String lName) {
				return "Anonymous Name = "+ (fName) + " - " + (lName);
			}
			
		};
				
		System.out.println(displayNameInterface2Impl2.displayName("Chetan", "Sharma"));		
		
		// Way 3 Lambda
				DisplayNameInterface2 displayNameInterface2Impl3 = (fName, lName) -> { return "Lambda Name = "+ (fName) + " - " + (lName); };
				System.out.println(displayNameInterface2Impl3.displayName("Chetan", "Sharma"));		
				
	}

}
