package com.learn.java.intro;

/**
 * <p>This Class show cases the usage of ThreadStackTrace for debugging.</p>
 */
public class ThreadStackTrace {
	
	public static void main(String[] args) {
		ThreadStackTrace object = new ThreadStackTrace();
		object.method1();
	}
	
	/**
	 * <p>This method gets stack trace from current thread and iterates over the elements in the stack trace array and prints all the method calls.</p>
	 */
	public void usingThreadStackTrace() {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		for(StackTraceElement element : stackTraceElements) {
			System.out.println(element);
		}
	}
	
	/**
	 * <p>Just dummy method to simulate redirecting method calls, which will be stored in Thread Stack Trace.</p>
	 */
	public void method1() {
		method2();
	}
	
	/**
	 * <p>Just dummy method to simulate redirecting method calls, which will be stored in Thread Stack Trace.</p>
	 */
	public void method2() {
		method3();
	}
	
	/**
	 * <p>This method calls usingThreadStackTrace method which prints all the method calls which lead to this method.</p>
	 */
	public void method3() {
		usingThreadStackTrace();
	}
}
