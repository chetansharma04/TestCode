package stringTest;

public class StringTest1 {

	public static void main(String[] args) {
		
//		String str1 = "Chetan";
//		String str2 = new String("Chetan");
//		boolean str3 = ("String == "+str1 == str2);
//		System.out.println("String == "+str1 == str2);
//		System.out.println("String equals = "+str1.equals(str2));
		
//		String str1 = "1.1";
//		String str2 = str1.substring(0,str1.length()-1) + "";
//		System.out.println("str2 = "+str2);
		
		String busUnits = "";
		
		
		busUnits = busUnits + "busUnits2" +", "; 
		busUnits = busUnits + "busUnits3 " +", ";
		
		 busUnits = busUnits.substring(0,busUnits.length()-2) + "";
		
		System.out.println(busUnits+".");
		
		
	}

}
