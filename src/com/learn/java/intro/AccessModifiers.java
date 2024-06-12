package com.learn.java.intro;

public class AccessModifiers {
	public int num1 = 10;
	private int num2 = 10;
	protected int num3 = 10;
	int num4 = 10;
	
	public static void main(String[] args) {
		AccessModifiers object = new AccessModifiers();
		System.out.println(object.num1);
		System.out.println(object.num2);
		System.out.println(object.num3);
		System.out.println(object.num4);
	}
}