package com.learn.java.intro;

public class AbstractClassesAndInterfaces {
	//An Interface can extend multiple interfaces.
	//All variable in interface are public, final, static
	public static void main(String[] args) {
		ConcreteClass object = new ConcreteClass();
		object.doSomething();
		object.printSomething();
	}
}

interface Interface{
	public void doSomething();
}

/**
 * <p>Partial Implementation of an Interface in an abstract class</p>
 */
abstract class AbstractClass implements Interface{
	/**
	 * <p>This method prints Something</p>
	 */
	public void printSomething() {
		System.out.println("Something");
	}
}


/**
 * <p>Full Implementation of abstract class</p>
 */
class ConcreteClass extends AbstractClass{  
	/**
	 * <p>This method prints Doing Something</p>
	 */
	public void doSomething() {
		System.out.println("Doing Something");
	}
}
