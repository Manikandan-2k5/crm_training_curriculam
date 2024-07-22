package com.learn.java.intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p>This class show cases the difference between Final, Static and Default keywords</p>
 */
public class FinalStaticInstanceLocal {
	
	final int finalVariable = 5;//This is final variable, which cannot be reassigned with other value.
	static int staticVariable = 10;//This is static variable, which is shared by all the instances of this class, i.e this variable belongs to the class itself.
	int instanceVariable = 15;//This is instance variable, i.e, every instance of this class has its own copy of this variable, which means it is non-static.
	
	
	public static void main(String[] args) throws IOException {
		FinalStaticInstanceLocal examples = new FinalStaticInstanceLocal();
		
		//Example for final vs static variable.
		examples.finalVariableVsStaticVariable();
		
		//Example for instance variables vs local variables
		examples.instanceVariableVsLocalVariable(35);
		
		//Example for static and instance methods.
		
		//Calling static method without any instance, i.e by using class name.
		FinalStaticInstanceLocal.staticMethod();
		
		//Calling instance method with the instance of the class, i.e by using the object instantiation of this class.
		examples.instanceMethod();
		
		//Final method of this class.
		examples.finalMethod();
		
		//A method in a Final Class.
		FinalClass finalClass = new FinalClass();
		finalClass.methodInFinalClass();
	}
	
	/**
	 * <p>Difference between final and static variable.</p>
	 */
	public void finalVariableVsStaticVariable() {
		
		//finalVariable = 5;//This causes syntax error, as finalVariable reassigning is not possible.
		
		//Static variable example.
		
		//Two Instances of Same Class.
		FinalStaticInstanceLocal object1 = new FinalStaticInstanceLocal();
		FinalStaticInstanceLocal object2 = new FinalStaticInstanceLocal();
		
		//Changing the static variable in object1.
		object1.changeStaticVariable();
		
		//But the change is visible in both object1 and object2, as they share the static variable.
		System.out.println("Static variable in object1: "+object1.getStaticVariable()+"\nStatic variable in object2: "+object2.getStaticVariable());
		
	}
	
	/**
	 * <p>Difference between instance and local variable.</p>
	 * @param methodArgumentLocalVariable local variable which is the argument passed for this method.
	 */
	public void instanceVariableVsLocalVariable(int methodArgumentLocalVariable) {
		
		int insideMethodlocalVariable = 30;//Local variable is a variable inside a method or constructor and only accessible within the method or constructor.
		
		System.out.println("Local variable which is initialized inside the method: "+insideMethodlocalVariable);
		System.out.println("Local variable which is passed as argument in the method parameters: "+methodArgumentLocalVariable);
		
		//Two Instances of Same Class.
		FinalStaticInstanceLocal object1 = new FinalStaticInstanceLocal();
		FinalStaticInstanceLocal object2 = new FinalStaticInstanceLocal();
		
		//Changing the instance variable of object1.
		object1.changeInstanceVariable();
		
		//The change is not visible in object2, as they do not share the instance variable, as they both have their own copies of it.
		System.out.println("Instance variable in object1: "+object1.getInstanceVariable()+"\nInstance variable in object2: "+object2.getInstanceVariable());
	
	}
	
	/**
	 * <p>Changes the static variable</p>
	 */
	public void changeStaticVariable() {
		staticVariable+=10;
	}
	
	/**
	 * <p>Returns the static variable</p>
	 * @return returns the static variable.
	 */
	public int getStaticVariable() {
		return staticVariable;
	}
	
	/**
	 * <p>Changes the instance variable</p>
	 */
	public void changeInstanceVariable() {
		instanceVariable+=15;
	}
	
	/**
	 * <p>Returns the instance variable</p>
	 * @return returns the instance variable.
	 */
	public int getInstanceVariable() {
		return instanceVariable;
	}
	
	/**
	 * <p>
	 * This is static method, which can be invoked without the instance of the class, just by using the class name.
	 * Example: ClassName.methodName();
	 * </p>
	 */
	public static void staticMethod() {
		System.out.println("Im in Static method. You can invoke me without any class instantiation.");
	}
	
	/**
	 * <p>
	 * This is instance method, which must be invoked with the instance of the class.
	 * Example: classInstance.methodName();
	 * </p>
	 */
	public void instanceMethod() {
		System.out.println("Im in Instance method. You must invoke me with the instance of this class.");
	}
	
	/**
	 * <p>This is final method, which cannot be overridden by the subclasses</p>
	 */
	public final void finalMethod() {
		System.out.println("Im inside Final method. No subclasses which extends this class can override this method.");
	}
	
	
}

/**
 * <p>Class which represents some scenarios in final, static, instance variables</p>
 */
class Sample extends FinalStaticInstanceLocal{
	
	/**
	 * <p>This method tries to override final method of the Parent class, which is not possible</p>
	 */
//	@Override
//	public void finalMethod() {
//		System.out.println("Trying to override final method in parent class, but it is a syntax error.");
//	}
}

/**
 * <p>This is Final class which cannot be extended by other classes</p>
 */
final class FinalClass{
	
	int num = 5;
	
	public void methodInFinalClass() {
		System.out.println("A method in Final class. A Final class cannot be extended by other classes.");
	}
}

/**
 * <p>This class produces compilation error, as a class cannot extend a final class.</p>
 */
//class SubClassOfFinalClass extends FinalClass{
//	
//	@Override
//	public void methodInFinalClass() {
//		System.out.println("An overriden method in Sub class of Final class. A Final class cannot be extended by other classes.");
//	}
//}
