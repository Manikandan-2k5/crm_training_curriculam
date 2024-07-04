package com.learn.java.intro;

/**
 * <p>This class implements all types of Exceptions</p>
 */
public class Exceptions {
	public static void main(String[] args) throws CheckedException{
		MathFunctions mathFunction = new MathFunctions();
//		System.out.println(mathFunction.positiveSum(-3, 2)); //This method throws CheckedException and it mandates the developer to either handle the exception with try catch block or declare throws CheckedException in the method signature.
//		System.out.println(mathFunction.negativeSum(5, 7));// This method throws exception during run time and does not mandates the use to handle the exception.
		try {
			System.out.println(mathFunction.divide(5, 0));//If dividend is zero, this will throw Chained Exception.
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Finally block is executed after the catch block before the program terminates.");
		}
	}
}

class MathFunctions{
	public int positiveSum(int a, int b) throws CheckedException{
		if(a<=0 || b<=0) {
			throw new CheckedException("Invalid Arguments. Arguments should be of type Integer and grater than 0.");
		}
		else {
			return a+b;
		}
	}
	
	public int negativeSum(int a, int b) {
		if(a>=0 || b>=0) {
			throw new UnCheckedException("Invalid Arguments. Arguments should be of type Integer and lesser than 0.");
		}
		else {
			return a+b;
		}
	}
	
	public int divide(int a, int b)  throws CheckedException{
		try {
			return a/b;
		}
		catch (Exception e) {
			throw new CheckedException("Divisor should not be 0", e);//Chained Exception
		}
	}
}


/**
 * <p>Exception which should be handled in the code by try catch block or declared in the method signature that this method throws Exception.</p>
 */
class CheckedException extends Exception{
	
	public CheckedException() {
		super();
	}
	
	public CheckedException(String message) {
		super(message);
	}
	
	public CheckedException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CheckedException(Throwable cause) {
		super(cause);
	}
	
}

/**
 * <p>Exception which may or may not be handled in the code by try catch block or declared in the method signature that this method throws Exception.</p>
 */
class UnCheckedException extends RuntimeException{
	
	public UnCheckedException() {
		super();
	}
	
	public UnCheckedException(String message) {
		super(message);
	}
	
	public UnCheckedException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public UnCheckedException(Throwable cause) {
		super(cause);
	}
}