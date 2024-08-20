package com.learn.java.intro;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>This class show cases the uses of AtomicWrapperClasses, which makes sure that all the a compound operation to its value is atomic, i.e no other thread interrupts this operation while processing.</p>
 */
public class AtomicWrapperClasses {

	AtomicInteger num = new AtomicInteger(0);
	int number = 0;
	
	public static void main(String[] args) {
		
		AtomicWrapperClasses object = new AtomicWrapperClasses();
		
		/**
		 * Incrementing using Atomic Integer
		 */
		object.withAtomic();
		
		/**
		 * Incrementing using Non Atomic Integer
		 */
		object.withoutAtomic();
		
	}
	
	/**
	 * This method increments the Atomic Integer num by 1 for 50000 times, which are incremented by 2 threads.
	 * This atomic integer makes sure that no other thread will read or write this object until the current thread completes its compound operation.
	 * It prevents the variable from data inconsistencies due to race conditions internally, so that we don't need to externally synchronize this variable.
	 */
	public void withAtomic() {
		
		
		Thread thread1 = new Thread(() -> { for(int i=0; i<25000; i++){num.incrementAndGet();}});
		Thread thread2 = new Thread(() -> { for(int i=0; i<25000; i++){num.incrementAndGet();}});
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		}
		catch(InterruptedException e) {
			System.out.println("Thread Interrupted.");
		}
		
		System.out.println("Result of incrementing a atomic integer 50000 times: "+num);
		
	}
	
	/**
	 * This method increments the Non Atomic Integer number by 1 for 50000 times, which are incremented by 2 threads.
	 * Incrementing Non Atomic Integer without external synchronization will lead to data inconsistencies, due to race conditions.
	 * So whenever modifying variables of non atomic type, externally synchronize it.
	 */
	public void withoutAtomic() {
		
		
		Thread thread1 = new Thread(() -> { for(int i=0; i<25000; i++){number++;}});
		Thread thread2 = new Thread(() -> { for(int i=0; i<25000; i++){number++;}});
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		}
		catch(InterruptedException e) {
			System.out.println("Thread Interrupted.");
		}
		
		System.out.println("Result of incrementing a non atomic integer 50000 times: "+number);	
	}
}
