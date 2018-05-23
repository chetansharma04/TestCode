package immutableTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 2 classes in this code

final class MyDataStructure {
    final List<String> list = new ArrayList<String>();

    protected void add(String s) {
        list.add(s);
    }

    /**
     * Makes a defensive copy of the List and return it
     * This way cannot modify the list itself
     *
     * @return List<String>
     */
    public List<String> getList() {
        return Collections.unmodifiableList(list);
    }
}


class DefensiveObject {

	public static void main(String[] args) {
		MyDataStructure myDataStructure = new MyDataStructure();
		myDataStructure.add("chetan");
		List<String> list = myDataStructure.getList();
//		list.add("sharma");
		for (String string : list) {
			System.out.println(string);
		}
		
		List<String> baseList = new ArrayList<String>();
		baseList.add("a");
		baseList.add("b");
		
		List<String> readOnlyCopyList =	Collections.unmodifiableList(baseList);
		readOnlyCopyList.add("c");

	}

}
