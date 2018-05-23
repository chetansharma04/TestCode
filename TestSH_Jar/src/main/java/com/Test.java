package com;


public class Test {

private	Test(){
		
	}
	public static void main(String[] args) {
 
		int[] a = {4,8,16};
		int i= +1;
		a[++i] = --i;
		float f = (float) (i%1.2);

    System.out.println("result = " + (a[0]+a[1]+a[2]));

}
}