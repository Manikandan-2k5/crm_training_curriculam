package com.learn.java.intro;


/**
 * <p>This class show cases the usage of Thread Local, which is used to store variables(thread contexts) specific to a particular thread.</p>
 */
public class ThreadLocalImpl {
	
	public static final ThreadLocal<Integer> threadContexts = ThreadLocal.withInitial(() -> 5);
	
	public static void main(String[] args) {
		
		/**
		 * Main Thread Context setting using Thread Local.
		 */
		Thread.currentThread().setName("Main Thread");
		System.out.print("Thread Name: "+Thread.currentThread().getName()+"; ");
		System.out.println("Thread Context(Initial Value Set): "+threadContexts.get());
		threadContexts.set(30);//Setting the context for the current thread.
		System.out.print("Thread Name: "+Thread.currentThread().getName()+"; ");
		System.out.println("Thread Context (Manually value set): "+threadContexts.get());
		threadContexts.remove();//Removes the thread context for that particular thread.
		System.out.print("Thread Name: "+Thread.currentThread().getName()+"; ");
		System.out.println("Thread Context (After removing set to initial value): "+threadContexts.get());
		
		/**
		 * Thread 1and Thread 2 Context setting using Thread Local.
		 */
		
		testThreadLocal();
			
	}
	
	/**
	 * <p>This method creates 2 threads which sets thread local value and manipulates it.</p>
	 */
	public static void testThreadLocal() {
		
		Thread thread1 = new Thread(
				() -> 
					{
						System.out.print("Thread Name: "+Thread.currentThread().getName()+"; ");
						System.out.println("Thread Context(Initial Value Set): "+threadContexts.get());
						threadContexts.set(10);//Setting the context for the current thread.
						System.out.print("Thread Name: "+Thread.currentThread().getName()+"; ");
						System.out.println("Thread Context (Manually value set): "+threadContexts.get());
						threadContexts.remove();//Removes the thread context for that particular thread.
						System.out.print("Thread Name: "+Thread.currentThread().getName()+"; ");
						System.out.println("Thread Context (After removing set to initial value): "+threadContexts.get());
					}, "Thread 1"
				);
		
		Thread thread2 = new Thread(
				() -> 
					{
						System.out.print("Thread Name: "+Thread.currentThread().getName()+"; ");
						System.out.println("Thread Context(Initial Value Set): "+threadContexts.get());
						threadContexts.set(20);//Setting the context for the current thread.
						System.out.print("Thread Name: "+Thread.currentThread().getName()+"; ");
						System.out.println("Thread Context (Manually value set): "+threadContexts.get());
						threadContexts.remove();//Removes the thread context for that particular thread.
						System.out.print("Thread Name: "+Thread.currentThread().getName()+"; ");
						System.out.println("Thread Context (After removing set to initial value): "+threadContexts.get());
					}, "Thread 2"
				);
		
		thread1.start();
		try {
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread2.start();
		
	}
	
	
}
