package com.learn.java.intro;


/**
 * <p>Given Implementation for AutoBoxing and AutoUnboxing</p>
 */
public class AutoBoxingAndAutoUnboxing {
	
	public static void main(String[] args) {
		int number1 = 5;
		Integer number2 = number1; //AutoBoxing
		number1 = number2; //AutoUnboxing
		System.out.println(number1+" "+number2);
	}
	
}
