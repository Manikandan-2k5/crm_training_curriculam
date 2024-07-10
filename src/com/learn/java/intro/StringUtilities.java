package com.learn.java.intro;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringUtilities {
	
	public static void main(String[] args) throws InterruptedException {
		StringUtilities utilities = new StringUtilities();
		utilities.diffBetweenImmutableStringsAndMutableStrings();
		utilities.differentEndodingsOfStrings();
		utilities.diffBetweenStringBufferAndStringBuilder();
	}
	
	/**
	 * <p>Showcases the difference between String and String Buffer, using concatenation and append.</p>
	 */
	public void diffBetweenImmutableStringsAndMutableStrings() {
		//Concept of Immutability in String which is vice versa in String Builder and String Buffer.
		String string = "Hello";
		System.out.println("Before Concatenation: "+string.hashCode());
		string+=" World!";
		System.out.println("After Concatenation: "+string.hashCode());//Different hash code because it creates new string.
		StringBuffer buffer = new StringBuffer("Hello");
		System.out.println("Before Append: "+buffer.hashCode());
		buffer.append(" World!");
		System.out.println("After Append: "+buffer.hashCode());//Same hash code because it modifies the internal array instead of creating a new instance. Same happens with String Builder.
	}
	
	/**
	 * <p>Showcases the different encodings which are possible to get bytes of the given string.</p>
	 */
	public void differentEndodingsOfStrings() {
		//String encodings.
		String utfString = "Hello😊";
		System.out.println("String length: "+utfString.length());
		byte[] utf8Bytes = utfString.getBytes(StandardCharsets.UTF_8);
		byte[] utf16Bytes = utfString.getBytes(StandardCharsets.UTF_16);
		System.out.println("UTF-8 encoded bytes: "+Arrays.toString(utf8Bytes));
		System.out.println("UTF-16 encoded bytes: "+Arrays.toString(utf16Bytes));
	}
	
	/**
	 * <p>Represents the difference between String builder and String buffer in terms of Synchronization./p>
	 * @throws InterruptedException 
	 */
	public void diffBetweenStringBufferAndStringBuilder() throws InterruptedException{
		
		final int actualCount = 150005;
		StringBuffer buffer = new StringBuffer("Hello");
		StringBuilder builder = new StringBuilder("Hello");
		
		//Runnable tasks for incrementing the bufferCount and buildCount, and appending buffer and build strings.
		Runnable runnable1 = () -> {for(int i=0; i<3; i++) {buffer.append("Hello");}};
		Runnable runnable2 = () -> {for(int i=0; i<3; i++) {builder.append("Hello");}};
		
		//Array for storing threads accessing buffer and builder.
		Thread[] threads = new Thread[20000];
		
		//Adding threads in the array and starting those threads
		for(int i=0; i<20000; i+=2) {
			Thread thread1 = new Thread(runnable1);
			Thread thread2 = new Thread(runnable2);
			threads[i] = thread1;
			threads[i+1] = thread2;
			thread1.start();
			thread2.start();
		}
		
		//Waiting for all the thread in the array to join, i.e waiting until all the threads finishes its tasks.
		for(Thread thread: threads) {
			try {
				thread.join();
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Actual thread modifications count: "+actualCount);
		System.out.println("String Buffer count: "+buffer.length());
		System.out.println("String Builder count: "+builder.length());
	}

}	