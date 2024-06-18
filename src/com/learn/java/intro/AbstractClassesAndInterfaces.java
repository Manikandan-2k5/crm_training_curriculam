package com.learn.java.intro;

public class AbstractClassesAndInterfaces {
	public static void main(String[] args) {
		ConcreteClass object = new ConcreteClass();
		object.doSomething();
		object.printSomething();
	}
}

interface Interface{
	public void doSomething();
}

abstract class AbstractClass implements Interface{ // Partial Implementation of an Interface in an abstract class
	public void printSomething() {
		System.out.println("Something");
	}
}

class ConcreteClass extends AbstractClass{ //Full Implementation of abstract class 
	public void doSomething() {
		System.out.println("Doing Something");
	}
}
