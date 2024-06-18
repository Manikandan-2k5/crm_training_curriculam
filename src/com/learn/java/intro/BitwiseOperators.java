package com.learn.java.intro;

public class BitwiseOperators {
	
	public static void main(String[] args) {
		BitwiseOperators bitOperators = new BitwiseOperators();
		bitOperators.and(0, 0);
		bitOperators.or(0, 0);
		bitOperators.xor(0, 0);
		bitOperators.complement(0);
		bitOperators.leftShift(0, 0);
		bitOperators.rightShift(0, 0);
		bitOperators.unsignedRightShift(0, 0);
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
