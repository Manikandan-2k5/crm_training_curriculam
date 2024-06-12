package com.learn.java.intro;

public class Constructors {
	
	int number;
	String string;
	boolean bool;
	
	public Constructors() {} // default constructor initialises all the fields with null, 1 , false according to their datatype.
	
	public Constructors(int num, String string, boolean bool) { // parameterized constructor. 'this' refers to the current object.
		this.number = num;
		this.string = string;
		this.bool = bool;
	}
	
	//defining more than one constructor is constructor overloading.
}
