package collectionTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.sdgc.truops.lmur.core.util.StringUtil;

public class SetTest {

	public static void main(String[] args) {
		String toOtherEmails = "chetan;sharma";
//		String[] toOtherEmailsTemp = toOtherEmails.split(";");
//		
//		for (int i = 0; i < toOtherEmailsTemp.length; i++) {
//			System.out.println("toOtherEmailsTemp = "+toOtherEmailsTemp[i]);
//		}
		
		Set<String> mySet2 = new HashSet<String>();
		mySet2.add("chetan");
		
		if(!StringUtil.isNullAndBlankCheck(toOtherEmails)){
			mySet2.addAll(Arrays.asList(toOtherEmails.split(";")));
		}
		
		
		for (String string : mySet2) {
			System.out.println("string = " +string);
		}
		
	}

}
