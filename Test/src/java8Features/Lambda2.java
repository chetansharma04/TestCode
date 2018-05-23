package java8Features;

@FunctionalInterface
interface DisplayNameInterface{
	String displayName(String firstName, String lastName);
}

class  DisplayNameImpl implements DisplayNameInterface{

	@Override
	public String displayName(String firstName, String lastName) {
		return "My name is: "+ (firstName + " - " + lastName);
	}
}

public class Lambda2 {
	public static void main(String[] args) {

		DisplayNameImpl displayNameImpl1 = new DisplayNameImpl();
		System.out.println("Name is: "+displayNameImpl1.displayName("Chetan", "Sharma"));
		
		//using Lambda
		DisplayNameInterface displayNameImpl2 = (fName, lName) -> {return "My name is: "+ (fName + " - " + lName);};
		System.out.println(displayNameImpl2.displayName("Chetan", "Sharma"));
	}
}
