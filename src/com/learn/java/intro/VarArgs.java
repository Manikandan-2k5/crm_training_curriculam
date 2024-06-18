package com.learn.java.intro;

public class VarArgs {
	
	public static void main(String[] args) {
		VarArgs object = new VarArgs();
		object.sampleMethod(1,2,3);
		object.sampleMethod();
		object.sampleMethod(1,2);
		object.sampleMethod(1);
	}
	
	public void sampleMethod(int... args) { //Accepts variable no of arguments
		for(int number : args) {
			System.out.print(number);
		}
		System.out.println();
	}
}
