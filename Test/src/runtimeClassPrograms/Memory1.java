package runtimeClassPrograms;

public class Memory1 {

	public static void main(String[] args) {

		Runtime runtime = Runtime.getRuntime();
		long mem1, mem2;
		System.out.println("Total memory = "+ runtime.totalMemory());
		System.out.println("Free memory = "+ runtime.freeMemory());
		
		runtime.gc();
		System.out.println("Memory after garbage collection");
		System.out.println("Total memory = "+ runtime.totalMemory());
		System.out.println("Free memory = "+ runtime.freeMemory());
		
		System.out.println("\nMemory after ar[] allocation");
		int[] ar = new int[1000];
		for (int i = 0; i < 1000; i++) {
			ar [i] = i;
		}
		System.out.println("Total memory = "+ runtime.totalMemory());
		System.out.println("Free memory = "+ runtime.freeMemory());
		runtime.gc();
		System.out.println("\nMemory after garbage collection");
		System.out.println("Total memory = "+ runtime.totalMemory());
		System.out.println("Free memory = "+ runtime.freeMemory());
		
	}

}
