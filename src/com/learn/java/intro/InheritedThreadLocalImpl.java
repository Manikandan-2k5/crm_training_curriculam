package com.learn.java.intro;

/**
 * <p>InheritableThreadLocal class is similar to ThreadLocal class, but here, if a current thread has no initial value or no value is set for the current thread, then the current thread will take its parent thread's context value.</p>
 */
public class InheritedThreadLocalImpl {
	
	public static final InheritableThreadLocal<Integer> threadContexts = new InheritableThreadLocal<Integer>() {
		@Override
		public Integer initialValue() {
			return 10;
		}
	};
	
	public static void main(String[] args) {
		
		/**
		 * Main Thread Context setting using Thread Local.
		 */
		Thread.currentThread().setName("Main Thread");
		System.out.println("Before setting value of Parent thread(Initial value): "+threadContexts.get());
		System.out.println("Parent Thread: "+Thread.currentThread().getName());
		threadContexts.set(15);
		System.out.println("Parent Thread Context value: "+threadContexts.get());
		
		/**
		 *Thread 1 Context setting using Thread Local.
		 */
		Thread thread1 = new Thread(
		() -> 
			{
				System.out.print("Thread Name: "+Thread.currentThread().getName()+"; ");
				System.out.println("Thread Context(Parent Thread Value Set): "+threadContexts.get());
				threadContexts.set(20);//Setting the context for the current thread.
				System.out.print("Thread Name: "+Thread.currentThread().getName()+"; ");
				System.out.println("Thread Context (Manually value set): "+threadContexts.get());
				threadContexts.remove();//Removes the thread context for that particular thread.
				System.out.print("Thread Name: "+Thread.currentThread().getName()+"; ");
				System.out.println("Thread Context (After removing thread local value is set to initial value): "+threadContexts.get());
			}, "Thread 1"
		);
		
		/**
		 *Thread 2 Context setting using Thread Local.
		 */
		Thread thread2 = new Thread(
		() -> 
			{
				System.out.print("Thread Name: "+Thread.currentThread().getName()+"; ");
				System.out.println("Thread Context(Parent Thread Value Set): "+threadContexts.get());
				threadContexts.set(30);//Setting the context for the current thread.
				System.out.print("Thread Name: "+Thread.currentThread().getName()+"; ");
				System.out.println("Thread Context (Manually value set): "+threadContexts.get());
				threadContexts.remove();//Removes the thread context for that particular thread.
				System.out.print("Thread Name: "+Thread.currentThread().getName()+"; ");
				System.out.println("Thread Context (After removing thread local value is set to initial value): "+threadContexts.get());
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
