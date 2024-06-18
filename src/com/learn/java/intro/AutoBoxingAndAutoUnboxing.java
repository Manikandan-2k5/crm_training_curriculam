package com.learn.java.intro;

public class AutoBoxingAndAutoUnboxing {
	
	public static void main(String[] args) {
		int number1 = 5;
		Integer number2 = number1; //AutoBoxing, Wrapper Class of int
		number1 = number2; // Auto Unboxing
		System.out.println(number1+" "+number2);
	}
	
}
