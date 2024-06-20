package com.learn.java.intro;


/**
 * <p>This class explains the concept of Inheritance</p>
 */
public class Inheritance {
	public static void main(String[] args) {
		//Hierarchical Inheritance, Multiple Sub classes.
		Samsung samsung = new Samsung();
		Apple apple = new Apple();
		samsung.assistant();
		apple.assistant();
		//MutiLevel Inheritance
		Cheetah cheetah = new Cheetah();
		cheetah.sound();
		System.out.println(cheetah.name);
	}
}

/**
 * <p>Mobile Class</p>
 */
class Mobile{
	int price;
	double memory;
	double ram;
	int pixels;
	
	/**
	 * <p>Function for Display</p>
	 */
	public void display() {
		System.out.println("Display");
	}
	
	/**
	 * <p>Function for Calling</p>
	 */
	public void call() {
		System.out.println("Calling");
	}
	
	/**
	 * <p>Function for Assistant</p>
	 */
	public void assistant() {
		System.out.println("Mobile Assistant");
	}
}


/**
 * <p>Samsung Class Extension of Mobile Class</p>
 */
class Samsung extends Mobile{
	@Override
	public void assistant() {
		System.out.println("Bixby");
	}
}

/**
 * <p>Apple Class Extension of Mobile Class</p>
 */
class Apple extends Mobile{
	@Override
	public void assistant() {
		System.out.println("Siri");
	}
}


//--------------------------
//MutiLevel Inheritance
/**
 * <p>Parent Class</p>
 */
class Animal{
	String name;
	int noOfLegs;
	int noOfHands;

	/**
	 * <p>Animal makes sound</p>
	 */
	public void sound() {
		System.out.println("Animals Sound");
	}
	
}

/**
 * Cat Class Extension of Animal Class
 */
class Cat extends Animal{
	
	boolean isCarnivore = false; 
	
	@Override
	public void sound() {
		System.out.println("Meow");
	}
	
}

/**
 * <p>Cheetah Class Extension of Cat Class</p>
 */
class Cheetah extends Cat{
	
	public Cheetah() {
		super.isCarnivore = true; //Accessing Parent's field
		super.name = "Cheetah"; //Accessing Grand Parent's field
	}
	
	@Override
	public void sound() {
		System.out.println("Roar");
	}
	
}


