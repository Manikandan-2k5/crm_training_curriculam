package com.learn.java.intro;

public class AnotherClassSamePackage {
	public static void main(String[] args) {
		AccessModifiers object = new AccessModifiers();
		System.out.println(object.num1);
//		System.out.println(object.num2);    private variable can be only accessible inside the class
		System.out.println(object.num3);
		System.out.println(object.num4);
	}
}
