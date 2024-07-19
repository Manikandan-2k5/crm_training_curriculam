package com.learn.java.intro;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/**
 * <p>This class represents the usage of Thread Concepts.</p>
 */
public class ThreadImpl {
	
	volatile ArrayList<Integer> array = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		ThreadImpl threadImpl = new ThreadImpl();
		
		/*
		 * Creation of execution of threads.
		 */
//		Thread.currentThread().setName("Main");
//		System.out.println("Currently executing thread: "+Thread.currentThread().getName());
//		threadImpl.usingThreads();
		
		/*
		 * Modifying ArrayList using two threads without synchronizing the array.
		 * This may lead to race conditions, which is caused by thread collisions and some modifications to the array will be lost.
		 */
//		threadImpl.modifyingThreadWithoutSynchronized();
		
		/*
		 * Modifying ArrayList using two threads by synchronizing the array.
		 * This will not lead to race conditions, as the array is synchronized, only one thread can access it at a particular time, which ensures the data integrity.
		 */
//		threadImpl.modifyingThreadWithSynchronized();
		
		/*
		 * Ensuring that a variable which is non volatile, when modified by multiple threads, 
		 * the modifications will not be visible to other threads at several times.
		 */
//		threadImpl.nonVolatileVariabeModification();
		
		/*
		 * Ensuring that a variable which is volatile, when modified by multiple threads, 
		 * the modifications will be visible to other threads at all cases.
		 */
		threadImpl.volatileVariabeModification();
		
		/*
		 * Represents the scenario of deadlock which makes the program to wait for indefinite time.
		 */
//		threadImpl.deadLock();
		
		/**
		 * No Of threads this system can run.
		 */
//		threadImpl.noOfThreadsCapableInSystem();
	}
	

	/**
	 * <p>This method creates a Thread of Runnable ThreadTask and starts the thread.</p>
	 */
	public void usingThreads() {
		Thread thread = new Thread(new ThreadTask(), "Child1 of Main Thread");
		thread.start();
	}
	
	/*
	 * This method portrays how the array will be modified by two threads without synchronizing the array.
	 */
	public void modifyingThreadWithoutSynchronized() {
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		/*
		 * Creation of Thread using Lambda Expression.
		 */
		Thread thread1 = new Thread(() -> {for(int i=0; i<10; i++) {arrayList.add(i+1);}}, "Thread 1");
		Thread thread2 = new Thread(() -> {for(int i=0; i<10; i++) {arrayList.add(i+1);}}, "Thread 1");
		
		thread1.start();
		thread2.start();
		
		/*
		 * Waits for the all the threads to terminate. Throws exception if interrupted.
		 */
		try {
			thread1.join();
			thread2.join();
			//Array modified by Thread1 and Thread2.
			System.out.println("Modified Array without using synchronized: "+arrayList);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * This method portrays how the array will be modified by two threads by synchronizing the array.
	 */
	public void modifyingThreadWithSynchronized() {
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		/*
		 * Creation of Thread using Lambda Expression.
		 */
		Thread thread1 = new Thread(() -> {synchronized(array){for(int i=0; i<10; i++) {arrayList.add(i+1);}}}, "Thread 1");
		Thread thread2 = new Thread(() -> {synchronized(array){for(int i=0; i<10; i++) {arrayList.add(i+1);}}}, "Thread 1");
		
		thread1.start();
		thread2.start();
		
		/*
		 * Waits for the all the threads to terminate. Throws exception if interrupted.
		 */
		try {
			thread1.join();
			thread2.join();
			//Array modified by Thread1 and Thread2.
			System.out.println("Modified Array using synchronized: "+arrayList);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <p>This method represents that variable which is not volatile, if modified by multiple threads, 
	 * the modifications will not be visible to other threads in several cases, 
	 * as in most cases JVM itself or System tries to flush the thread cache memory into main memory, as the load barrier is inserted,
	 * and store barrier will be inserted while reading which reads from the main memory in which other threads flushed their cache data,
	 * thus making the non volatile variable visible to other threads. Note this happens in most cases but not all the cases.
	 * To ensure that modifications to one variable is visible to other threads in all cases, you should make the variable volatile, or synchronize the variable.
	 * </p>
	 */
	public void nonVolatileVariabeModification() {
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		/*
		 * Creation of Thread using Anonymous Class.
		 */
		Thread readingThread = new Thread() {
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					try {
						System.out.println("Array in reading thread: "+arrayList);
					}
					catch (ConcurrentModificationException e) {
						continue;
					}
				}
			}
		};
		
		Thread writingThread = new Thread() {
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					try {		
						arrayList.add(i+1);
						System.out.println("Array in writing thread: "+arrayList);
					}
					catch(ConcurrentModificationException e) {
						continue;
					}
				}
			}
		};
		
		writingThread.start();
		readingThread.start();
		try {
			writingThread.join();
			readingThread.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * <p>This method represents that variable which is volatile, if modified by multiple threads, 
	 * the modifications will be visible to other threads in all the cases.
	 * </p>
	 */
	public void volatileVariabeModification() {
		
		/*
		 * Creation of Thread using Anonymous Class.
		 */
		Thread readingThread = new Thread() {
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					try {
						System.out.println("Array in reading thread: "+array);
						Thread.sleep(1000);
					}
					catch (ConcurrentModificationException e) {
						continue;
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread writingThread = new Thread() {
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					try {		
						array.add(i+1);
						System.out.println("Array in writing thread: "+array);
						Thread.sleep(500);
					}
					catch(ConcurrentModificationException e) {
						continue;
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		writingThread.start();
		readingThread.start();
		
	}
	
	/**
	 * <p>This method represents a case of dead lock,
	 * which happens when a thread is holding a variable's lock,
	 * and waiting for the other thread to release lock of the variable which the later is holding, 
	 * whereas in vice versa, the other thread is waiting for the former thread to release the lock of the variable which it is holding,
	 * which turns into an indefinite block.
	 * </p>
	 */
	public void deadLock() {
		
		ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
		
		/*
		 * This thread locks arrayList1 and adds numbers, then waits to acquire the lock of arrayList2 to add numbers.
		 */
		Thread thread1 = new Thread(){
			@Override
			public void run() {
				synchronized(arrayList1) {
					for(int i=0; i<10; i++) {
						arrayList1.add(i+1);
					}
					synchronized(arrayList2) {
						for(int i=0; i<10; i++) {
							arrayList2.add(i+1);
						}
					}
				}
			}
		};
		
		/*
		 * This thread locks arrayList2 and adds numbers, then waits to acquire the lock of arrayList1 to add numbers.
		 */
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				synchronized(arrayList2) {
					for(int i=0; i<10; i++) {
						arrayList2.add(i+1);
					}
					synchronized(arrayList1) {
						for(int i=0; i<10; i++) {
							arrayList1.add(i+1);
						}
					}
				}
			}
		};
		
		thread2.start();
		thread1.start();
		
		/*
		 * Waits until the threads terminate, but unfortunately threads does not terminate, as it is a dead lock.
		 */
		try {
			thread1.join();
			thread2.join();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * <p>This method prints how much Threads can be instantiated and started in a particular system.</p>
	 */
	public void noOfThreadsCapableInSystem() {
		int count = 0;
		while(true) {
			Thread thread = new Thread(() -> { while(true) {try{Thread.sleep(1000);} catch(Exception e){e.printStackTrace();}}});
			thread.start();
			count++;
			System.out.println(count);
		}
	}
	
}

/**
 * <p>Creating a Runnable Task Class by implementing Runnable Interface</p>
 */
class ThreadTask implements Runnable{
	
	@Override
	public void run() {
		for(int i=0; i<3; i++) {
			System.out.println("Currently executing thread: "+Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
	