package com.learn.java.intro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * <p>Program for converting Integers, Floats, Strings, Characters, Emojies, Files to Binary.</p>
 */
public class BinaryConversions {
	
	public static void main(String[] args) throws Exception {
		BinaryConversions convertor = new BinaryConversions();
		//System.out.println(convertor.decimalToBinary(-10));
		//System.out.println(convertor.floatToBinary(10.56));
		//System.out.println(convertor.characterToBinary('z'));
		//System.out.println(convertor.stringToBinary("Hello Im Manikandan"));
		//System.out.println(convertor.emojiToBinary("😀"));
		//System.out.println(convertor.fileToString("/home/manikandans/Documents/Data_Store.txt"));
	}
	
	/**
	 * <p>Converts Decimal to Binary and returns the binary as result.</p>
	 * @param num Number to be converted to Binary.
	 * @return Binary of the num.
	 */
	public String decimalToBinary(long num) {
		if(num==0) {
			return "0";
		}
		else if(num>0){
			String binary = "";
			while(num>0) {
				long remainder = num%2;
				binary = remainder+binary;
				num/=2;
			}
			return binary;
		}
		else {
			String binary = "";
			num*=-1;
			while(num>0) {
				long remainder = num%2;
				binary = remainder+binary;
				num/=2;
			}
			String complement = complement(binary);
			return binaryAddition(complement, "1");
		}
	}
	
	/**
	 * <p>Converts Float to Binary and returns the binary as result. Throws exception when num is Negative float.</p>
	 * @param num Float to be converted to Binary. Float should not be negative.
	 * @return Binary of the num.
	 */
	public String floatToBinary(double num) throws Exception {
		if(num<0) {
			throw new Exception("This function is not designed for negative numbers.");
		}
		if(num==0) {
			return "0.0";
		}
		String integerPartBinary = decimalToBinary((int)num);
		String fractionalPartBinary = "";
		double fractionalPart = num - (int)num;
		while(fractionalPart>0) {
			fractionalPartBinary+=(int)(fractionalPart*2);
			fractionalPart*=2;
			fractionalPart = fractionalPart - (int)fractionalPart;
		}
		return integerPartBinary+"."+fractionalPartBinary;
	}
	
	/**
	 * <p>Converts a Binary to its Complement by negating each bits of the binary.</p>
	 * @param binary Binary to be converted to its complement.
	 * @return Complement of the binary.
	 */
	public String complement(String binary) {
		String complement = "";
		for(int i=0; i<binary.length(); i++) {
			if(binary.charAt(i)=='0') {
				complement+='1';
			}
			else {
				complement+='0';
			}
		}
		return complement;
	}
	
	/**
	 * <p>Adds two binary operands by doing binary addition.</p>
	 * @param binary1 operand1 which is binary. Should be of base 2, otherwise result would be not as expected.
	 * @param binary2 operand2 which is binary. Should be of base 2, otherwise result would be not as expected.
	 * @return Returns Binary which is the result of adding binary1 and binary2.
	 */
	public String binaryAddition(String binary1, String binary2) {
		String carry = "0";
		String result = "";
		boolean exception = false;
		if(binary1.length()>binary2.length()) {
			int j = binary2.length()-1;
			for(int i=binary1.length()-1; i>=0; i--) {
				try {
					if(exception) {
						if(carry.equals("1") && binary1.charAt(i)=='0') {
							result="1"+result;
							carry="0";
						}
						else if(carry.equals("1") && binary1.charAt(i)=='1') {
							result="0"+result;
							carry="1";
						}
						else{
							result=binary1.charAt(i)+result;
						}
					}
					else if(binary1.charAt(i)=='0' && binary2.charAt(j)=='0') {
						if(carry.equals("0")) {
							result="0"+result;
						}
						else {
							result="1"+result;
							carry="0";
						}
					}
					else if((binary1.charAt(i)=='1' && binary2.charAt(j)=='0') || (binary1.charAt(i)=='0' && binary2.charAt(j)=='1')) {
						if(carry.equals("0")) {
							result="1"+result;
						}
						else {
							result="0"+result;
							carry = "1";
						}
					}
					else if(binary1.charAt(i)=='1' && binary2.charAt(j)=='1') {
						if(carry.equals("0")) {
							result="0"+result;
						}
						else {
							result="1"+result;
						}
						carry = "1";
					}
					j--;
				}
				catch (StringIndexOutOfBoundsException e) {
					exception = true;
					i++;
					continue;
				}
			}
		}
		else if(binary2.length()>binary1.length()){
			int j = binary1.length()-1;
			for(int i=binary2.length()-1; i>=0; i--) {
				try {
					if(exception) {
						if(carry.equals("1") && binary2.charAt(i)=='0') {
							result="1"+result;
							carry = "0";
						}
						else if(carry.equals("1") && binary2.charAt(i)=='1') {
							result="0"+result;
							carry="1";
						}
						else {
							result+=binary2.charAt(i);
						}
					}
					else if(binary1.charAt(j)=='0' && binary2.charAt(i)=='0') {
						if(carry.equals("0")) {
							result="0"+result;
						}
						else {
							result="1"+result;
							carry="0";
						}
					}
					else if((binary1.charAt(j)=='1' && binary2.charAt(i)=='0') || (binary1.charAt(j)=='0' && binary2.charAt(i)=='1')) {
						if(carry.equals("0")) {
							result="1"+result;
						}
						else {
							result="0"+result;
							carry="1";
						}
					}
					else if(binary1.charAt(j)=='1' && binary2.charAt(i)=='1') {
						if(carry.equals("0")) {
							result="0"+result;
						}
						else {
							result="1"+result;
						}
						carry="1";
					}
					j--;
				}
				catch (Exception e) {
					exception = true;
					i++;
					continue;
				}
			}
		}
		else {
			for(int i=binary2.length()-1; i>=0; i--) {
				if(i==0) {
					if(binary1.charAt(i)=='0' && binary2.charAt(i)=='0') {
						if(carry.equals("0")) {
							result="0"+result;
						}
						else {
							result="1"+result;
							carry="0";
						}
					}
					else if((binary1.charAt(i)=='1' && binary2.charAt(i)=='0') || (binary1.charAt(i)=='0' && binary2.charAt(i)=='1')) {
						if(carry.equals("0")) {
							result="1"+result;
						}
						else {
							result="10"+result;
						}
					}
					else if(binary1.charAt(i)=='1' && binary2.charAt(i)=='1') {
						if(carry.equals("0")) {
							result="10"+result;
						}
						else {
							result="11"+result;
						}
					}
				}
				if(binary1.charAt(i)=='0' && binary2.charAt(i)=='0') {
					if(carry.equals("0")) {
						result="0"+result;
					}
					else {
						result="1"+result;
						carry="0";
					}
				}
				else if((binary1.charAt(i)=='1' && binary2.charAt(i)=='0') || (binary1.charAt(i)=='0' && binary2.charAt(i)=='1')) {
					if(carry.equals("0")) {
						result="1"+result;
					}
					else {
						result="0"+result;
						carry="1";
					}
				}
				else if(binary1.charAt(i)=='1' && binary2.charAt(i)=='1') {
					if(carry.equals("0")) {
						result="0"+result;
					}
					else {
						result="1"+result;
					}
					carry="1";
				}
			}
		}
		return result;
			
	}
	
	/**
	 * <p>Converts character to binary, by taking the unicode value of the character.</p>
	 * @param character to be converted to binary.
	 * @return returns binary value of the character.
	 */
	public String characterToBinary(char character) {
		String binaryString = "";
		int ascii = character;
		return decimalToBinary(ascii);
	}
	
	/**
	 * <p>Converts true and false to 1 and 0 respectively which are the binary representation of booleans.</p>
	 * @param bool boolean value to be converted to its binary.
	 * @return returns binary value of boolean literal.
	 */
	public String booleanToBinary(boolean bool) {
		if(bool) {
			return "1";
		}
		else {
			return "0";
		}
	}
	
	/**
	 * <p>Converts string to binary by converting each character to its binary where each binary are delimited by a space.</p>
	 * @param string to be converted to binary.
	 * @return returns the binary value of string
	 */
	public String stringToBinary(String string) {
		String binaryString = "";
		for(int i=0; i<string.length(); i++) {
			binaryString+=decimalToBinary((int)string.charAt(i))+" ";
		}
		return binaryString;
	}
	
	/**
	 * <p>Converts emoji to Binary by converting each unicode of the emoji to Binary which are delimited by space.</p>
	 * @param emoji to be converted to binary.
	 * @return returns binary value of the emoji
	 */
	public String emojiToBinary(String emoji) {
		String binaryString = "";
		char[] charArray = emoji.toCharArray();
		for(char character : charArray) {
			binaryString+=Integer.toBinaryString(character)+" ";
		}
		return binaryString;
	}
	
	
	/**
	 * <p>Converts file to binary by converting each character in file to binary delimited by spaces.</p>
	 * @param fileName Name of the file which has to be converted to binary form.
	 * @return Binary value of the file.
	 */
	public String fileToString(String fileName) {
		String binaryString = "";
		File file = new File(fileName);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while(reader.ready()) {
				binaryString+=Integer.toBinaryString(reader.read())+" ";
			}
			return binaryString;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}