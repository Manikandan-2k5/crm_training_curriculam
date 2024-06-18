package com.learn.java.intro;

public class BitwiseOperators {
	
	public static void main(String[] args) {
		BitwiseOperators bitOperators = new BitwiseOperators();
		System.out.println(bitOperators.and(10, 5));
		System.out.println(bitOperators.or(10, 5));
		System.out.println(bitOperators.xor(10, 5));
		System.out.println(bitOperators.complement(5));
		System.out.println(bitOperators.leftShift(10, 1));
		System.out.println(bitOperators.rightShift(10, 1));
		System.out.println(bitOperators.unsignedRightShift(-10, 1));
	}
	
	
	/**
	 * <p>Takes the binary value of both operands and does 'and' operation for each bit of both the binary values and returns the decimal value of resulting binary value </p>
	 * @param num1
	 * @param num2
	 * @return 
	 */
	public int and(int num1, int num2) {
		return num1 & num2;
	}
	
	
	/**
	 * <p>Takes the binary value of both operands and does 'or' operation for each bit of both the binary values and returns the decimal value of resulting binary value</p>
	 * @param num1
	 * @param num2
	 * @return 
	 */
	public int or(int num1, int num2) {
		return num1 | num2;
	}
	
	/**
	 * <p>Takes the binary value of both operands and does 'xor' operation for each bit of both the binary values and return the decimal value of the resulting binary value</p>
	 * @param num1
	 * @param num2
	 * @return
	 */
	public int xor(int num1, int num2) {
		return num1 ^ num2;
	}
	
	
	/**
	 * <p>Takes the binary value of the operand and complements each bit and return decimal value of the resulting binary value</p>
	 * @param num
	 * @return
	 */
	public int complement(int num){
		return ~num;
	}
	
	/**
	 * <p>Takes the binary value of operand1 and moves each bit operand2 times left maintaining the signed bit.</p>
	 * @param num1
	 * @param num2
	 * @return
	 */
	public int leftShift(int num1, int num2) {
		return num1<<num2;
	}
	
	/**
	 * <p>Takes the binary value of operand1 and moves each bit operand2 times right maintaining the signed bit. </p>
	 * @param num1
	 * @param num2
	 * @return
	 */
	public int rightShift(int num1, int num2) {
		return num1>>num2;
	}
	
	/**
	 * <p>Takes the binary value of operand1 and moves each bit operand2 times right without considering the signed bit. </p>
	 * @param num1
	 * @param num2
	 * @return
	 */
	public int unsignedRightShift(int num1, int num2) {
		return num1>>>num2;
	}
}
