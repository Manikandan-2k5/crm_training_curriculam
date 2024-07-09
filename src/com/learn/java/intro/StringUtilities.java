package com.learn.java.intro;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringUtilities {
	public static void main(String[] args) {
		//Concept of Immutability in String which is vice versa in String Builder and String Buffer.
		String string = "Hello";
		System.out.println("Before Concatenation: "+string.hashCode());
		string+=" World!";
		System.out.println("After Concatenation: "+string.hashCode());//Different hash code because it creates new string.
		StringBuffer buffer = new StringBuffer("Hello");
		System.out.println("Before Append: "+buffer.hashCode());
		buffer.append(" World!");
		System.out.println("After Append: "+buffer.hashCode());//Same because it modifies the internal array instead of creating a new instance. Same happens with String Builder.
		
		//Synchronization
		StringBuilder builder = new StringBuilder("Hello World!");
		Runnable runnable1 = () -> {for(int i=0; i<3; i++) {buffer.append("Hello ");}};
		Runnable runnable2 = () -> {for(int i=0; i<3; i++) {builder.append("Hello ");}};
		
		Thread thread1 = new Thread(runnable1);
		Thread thread2 = new Thread(runnable2);
		
		Thread thread3 = new Thread(runnable1);
		Thread thread4 = new Thread(runnable2);
		
		Thread thread5 = new Thread(runnable2);
		Thread thread6 = new Thread(runnable2);
		
		Thread thread7 = new Thread(runnable2);
		Thread thread8 = new Thread(runnable2);
		Thread thread9 = new Thread(runnable2);
		Thread thread10 = new Thread(runnable2);
		
		Thread thread11 = new Thread(runnable2);
		Thread thread12 = new Thread(runnable2);
		Thread thread13 = new Thread(runnable2);
		Thread thread14 = new Thread(runnable2);
		
		thread3.start();
		thread5.start();
		thread1.start();
		thread8.start();
		thread9.start();
		thread2.start();
		thread12.start();
		thread13.start();
		thread6.start();
		thread7.start();
		thread10.start();
		thread4.start();
		thread14.start();
		thread11.start();
		
		try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
    		thread6.join();
    		thread7.join();
    		thread8.join();;
    		thread9.join();
    		thread10.join();
    		thread11.join();
    		thread12.join();
    		thread13.join();
    		thread14.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
//		System.out.println(buffer.toString());//All the string appends will be perfectly appended as it is synchronized.
//		System.out.println(builder.toString());//Some string appends will be corrupted as it is not synchronized.
		
		
		//String encodings.
		String utfString = "Hello😊";
		System.out.println("String length: "+utfString.length());
		System.out.println();
		byte[] utf8Bytes = utfString.getBytes(StandardCharsets.UTF_8);
		byte[] utf16Bytes = utfString.getBytes(StandardCharsets.UTF_16);
		System.out.println("UTF-8 encoded bytes: "+Arrays.toString(utf8Bytes));
		System.out.println("UTF-16 encoded bytes: "+Arrays.toString(utf16Bytes));
	}
}	