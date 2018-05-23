package clone;

class Person implements Cloneable{
	 private String name;

	    public Person(String name) {
	        this.name = name;
	    }
	
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	    	 this.name = name;
	    }	
	    
	@Override
	public Person clone(){
		 try {
	            return (Person) super.clone();
	        } catch (CloneNotSupportedException e) {
	            e.printStackTrace();
	            throw new RuntimeException();
	        }
	}
	
}

public class Cloneable1 {

	public static void main(String[] args) {
		Person p = new Person("Sam");
        Person pClone = p.clone(); // Can you do this, if clone method in Person class is not public
        System.out.println("After simple cloning");
        System.out.println("pClone = "+ pClone.getName());

        System.out.println("\nAfter another object cloning and changing variable - 'name' , no change of values in first cloned object");
        Person pClone2 = p.clone(); // Can you do this, if clone method in Person class is not public
        pClone2.setName("chetan");
        System.out.println("pClone = "+ pClone.getName());
        System.out.println("pClone2 = "+ pClone2.getName());

        System.out.println("\nAfter using == reference copy rather cloning");
        pClone2 = pClone;
        System.out.println("pClone = "+ pClone.getName());
        System.out.println("pClone2 = "+ pClone2.getName());
	
        pClone2.setName("chetan");
        System.out.println("\nthus leads to change of values in first cloned object");
        System.out.println("pClone = "+ pClone.getName());
        System.out.println("pClone2 = "+ pClone2.getName());
	
	}

}
