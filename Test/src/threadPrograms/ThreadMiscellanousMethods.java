package threadPrograms;

class  MiscThread extends Thread{
}

public class ThreadMiscellanousMethods {
	public static void main(String[] args) {
		MiscThread miscThread = new MiscThread();
		System.out.println("getId() = "+miscThread.getId());
		System.out.println("getName() = "+miscThread.getName());
		System.out.println("getPriority() = "+miscThread.getPriority());
		System.out.println();	
		MiscThread miscThread2 = new MiscThread();
		System.out.println("getId() = "+miscThread2.getId());
		System.out.println("getName() = "+miscThread2.getName());
		System.out.println("getPriority() = "+miscThread.getPriority());
	}
}