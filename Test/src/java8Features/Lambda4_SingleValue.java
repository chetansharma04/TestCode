package java8Features;

@FunctionalInterface
interface SingleValueInterface{
	String displayName(String fName);
	
}

class SingleValueInterfaceImpl implements SingleValueInterface{

	@Override
	public String displayName(String fName) {
		return "Name = "+ (fName) ;
	}
	
}

public class Lambda4_SingleValue {

	public static void main(String[] args) {

		//Way 1 
		SingleValueInterface singleValueInterfaceImpl = new SingleValueInterfaceImpl();

		System.out.println(singleValueInterfaceImpl.displayName("Chetan"));
		
//		Way 2
		DisplayNameInterface2 displayNameInterface2Impl2 = new DisplayNameInterface2(){

			@Override
			public String displayName(String fName, String lName) {
				return "Anonymous Name = "+ (fName) ;
			}
			
		};
				
		System.out.println(displayNameInterface2Impl2.displayName("Chetan", "Sharma"));		
		
		// Way 3 Lambda
		SingleValueInterface singleValueInterfaceImpl3 = fName -> { return "Lambda Name = "+ (fName) ; };
		System.out.println(singleValueInterfaceImpl3.displayName("Chetan"));		
		
		
	}

}
