package generics;
import java.util.ArrayList;
import java.util.List;

public class GenericsTest {
	
	public static void main(String[] args) {
		List lst1 = new ArrayList();
		lst1.add("Chetan");
		lst1.add("sharma");

		for (Object obj : lst1) {
			if(((String)obj).equalsIgnoreCase(("chetan"))){
				lst1.remove(obj);
			}
		}
		
		System.out.println("\nlst1===");
		for (Object obj : lst1) {
			System.out.println(obj);
		}
		
		List<String> lst2 = new ArrayList<String>();
		lst2.addAll(lst1);
		for (String string : lst2) {
			if(string.equals("chetan")){
				lst2.remove(string);
			}
		}
		
		System.out.println("\nlst2===");
		for (String string : lst2) {
			System.out.println(string);
		}

		
	}

}
