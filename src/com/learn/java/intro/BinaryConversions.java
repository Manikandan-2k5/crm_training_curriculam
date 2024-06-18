package com.learn.java.intro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class BinaryConversions {
	
	public static void main(String[] args) {
		BinaryConversions convertor = new BinaryConversions();
		//System.out.println(convertor.decimalToBinary(-10));
		//System.out.println(convertor.floatToBinary(10.53));
		//System.out.println(convertor.characterToBinary('z'));
		//System.out.println(convertor.stringToBinary("Hello Im Manikandan"));
		//System.out.println(convertor.emojiToBinary("😀"));
		System.out.println(convertor.fileToString("/home/manikandans/Documents/Data_Store.txt"));
	}
	
	
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
	
	public String floatToBinary(double num) {
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
	
	public String characterToBinary(char character) {
		String binaryString = "";
		int ascii = character;
		return decimalToBinary(ascii);
	}
	
	public String booleanToBinary(boolean bool) {
		if(bool) {
			return "1";
		}
		else {
			return "0";
		}
	}
	
	public String stringToBinary(String string) {
		String binaryString = "";
		for(int i=0; i<string.length(); i++) {
			binaryString+=decimalToBinary((int)string.charAt(i))+" ";
		}
		return binaryString;
	}
	
	public String emojiToBinary(String emoji) {
		String binaryString = "";
		char[] charArray = emoji.toCharArray();
		for(char character : charArray) {
			binaryString+=Integer.toBinaryString(character)+" ";
		}
		return binaryString;
	}
	
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