package com.learn.java.intro;


/**
 * <p>This class implements the Nested Class feature in java</p>
 */
public class NestedClasses {
	
	static int staticVariable = 100;
	private int privateVariable = 100;

	
	public static void main(String[] args) {
		NestedClasses outerClass = new NestedClasses();
		NestedClasses.StaticClass staticClass  = new NestedClasses.StaticClass();
		staticClass.displayStaticFields();
		NestedClasses.InnerClass innerClass = outerClass.new InnerClass();
		innerClass.displayAllFields();
		outerClass.localClassMethod();
		
		Runnable greet = ()-> {//Anonymous Class
			System.out.println("Hello Everyone !!!");
		};
		
		greet.run();
	}
	
	/**
	 * <p>Static Nested Class</p>
	 */
	static class StaticClass{
		public void displayStaticFields() {//Only static fields of outer class is accessible.
			System.out.println(staticVariable);
			//System.out.println(privateVariable); Instance fields cannot be accessible.
		}
	}
	
	/**
	 * <p>Inner Nested Class</p>
	 */
	class InnerClass{
		public void displayAllFields() { // All fields of outer class are accessible.
			System.out.println(staticVariable);
			System.out.println(privateVariable); 
		}
	}
	
	/**
	 * <p>This method implements the local class</p>
	 */
	public void localClassMethod() {
		int num1 = 100;
		final int num2 = 100;
		int num3 = 100;
		num3 = 50; //reassigning the value.
		/**
		 * <p>Local Nested Class</p>
		 */
		class LocalClass{// final local variable are only accesible.
			public void displayLocalFinalFields() {
				System.out.println(num1);
				System.out.println(num2);
				//System.out.println(num3); //Cannot access modified local variable
				System.out.println(staticVariable);
				System.out.println(privateVariable);
			}
		}
		LocalClass localObject = new LocalClass();
		localObject.displayLocalFinalFields();
	}
	
}
