package com.learn.java.intro;


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

//Hierarchical Inheritance, Multiple Sub classes.
class Mobile{
	int price;
	double memory;
	double ram;
	int pixels;
	
	public void display() {
		System.out.println("Display");
	}
	
	public void call() {
		System.out.println("Calling");
	}
	
	public void assistant() {
		System.out.println("Mobile Assistant");
	}
}

class Samsung extends Mobile{
	@Override
	public void assistant() {
		System.out.println("Bixby");
	}
}

class Apple extends Mobile{
	@Override
	public void assistant() {
		System.out.println("Siri");
	}
}

//--------------------------
//MutiLevel Inheritance
class Animal{
	String name;
	int noOfLegs;
	int noOfHands;

	public void sound() {
		System.out.println("Animals Sound");
	}
	
}

class Cat extends Animal{
	
	boolean isCarnivore = false; 
	
	@Override
	public void sound() {
		System.out.println("Meow");
	}
	
}

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


