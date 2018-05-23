package threadPrograms;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {

	public static void main(String[] args) {
		AtomicInteger ai = new AtomicInteger(10);
		System.out.println("ai = "+ai.getAndIncrement());
		System.out.println("ai = "+ai.incrementAndGet());

	}

}
