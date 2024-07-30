package com.learn.java.intro;

import java.util.ArrayList;


public class BackTracking {
	
	static int[] intArray;
	static int permutations = 0;
	
	public static void main(String[] args) {
//		intArray = new int[] {1,2,3,4,5,6,7,8,9,10,11,12};
//		ArrayList<int[]> result = new ArrayList<int[]>();
//		long startTime = System.currentTimeMillis();
//		BackTracking.combinations(intArray, 0);
//		long endTime = System.currentTimeMillis();
//		System.out.println("Time Taken: "+(endTime-startTime)+"ms");
//		System.out.println("Permutations: "+permutations);
		flames("Manikandan", "Maanickavasagar");
		
	}

	/**
	 * <p>This method finds all possible permutations for the given int[] array of elements.</p>
	 * @param elementArray array to be traversed.
	 * @param index cursor pointer for the array.
	 */
	public static void combinations(int[] elementArray, int index) {
		
		if(index==elementArray.length-1) {
			Arrays.print(elementArray);
			permutations++;
		}
		
		else {
			for(int i=index; i<elementArray.length; i++) {
				int temp = elementArray[index];
				elementArray[index] = elementArray[i];
				elementArray[i] = temp;
				combinations(elementArray.clone(), index+1);
			}
		}
		
	}
	
	/**
	 * <p>
	 * This is the initiator for flames process. 
	 * This method removes the common characters in the given names only once.
	 * And the remaining characters count is the interval for strike.
	 * After this, it will call the recursive method {@code} recurseFlame to find the relationship between both the names.
	 * </p>
	 * @param name1 name of first person.
	 * @param name2 name of second person.
	 */
	public static void flames(String name1, String name2) {
		
		char[] name1Chars = name1.toCharArray();
		char[] name2Chars = name2.toCharArray();
		
		strikeCommonCharactersOnce(name1Chars, name2Chars);
		
		ArrayList<String> escapedChars = new ArrayList<String>();
		
		for(char character : name1Chars) {
			if(character=='_') {
				continue;
			}
			escapedChars.add(character+"");
		}
		
		for(char character : name2Chars) {
			if(character=='_') {
				continue;
			}
			escapedChars.add(character+"");
		}
		
		ArrayList<String> flamesArray = new ArrayList<String>(java.util.Arrays.asList(new String[] {"F", "L", "A", "M", "E"}));
		int intervalForStrike = escapedChars.size();
		int pointer = 1;
		recurseFlame(0, intervalForStrike, pointer, flamesArray);
		System.out.println(flamesArray.get(0));
		
		
	}
	
	/**
	 * <p>Recursive method for finding the flame result.</p>
	 * @param index current index of the flamesArray.
	 * @param intervalForStrike interval of characters to strike the last character after the interval.
	 * @param pointer cursor for the interval.
	 * @param flamesArray array which contains F,L,A,M,E.
	 */
	public static void recurseFlame(int index, int intervalForStrike, Integer pointer, ArrayList<String> flamesArray) {
		if(flamesArray.size()==1) {
			return;
		}
		else if(pointer==intervalForStrike) {
			flamesArray.remove(index);
			if(index>=flamesArray.size()-1) {
				recurseFlame(0, intervalForStrike, 1, flamesArray);
			}
			else {
				recurseFlame(index, intervalForStrike, 1, flamesArray);
			}
		}
		else if(index==flamesArray.size()-1) {
			recurseFlame(0, intervalForStrike, pointer+1, flamesArray);
		}
		else {
			recurseFlame(index+1, intervalForStrike, pointer+1, flamesArray);
		}
	}
	
	/**
	 * <p>This method converts the common characters in both char[] to '_' once.</p>
	 * @param charArray1 char[] to be traversed.
	 * @param charArray2 char[] to be traversed.
	 */
	public static void strikeCommonCharactersOnce(char[] charArray1, char[] charArray2) {
		
		for(int i=0; i<charArray1.length; i++) {
			for(int j=0; j<charArray2.length; j++) {
				if(charArray2[j]=='_') {
					continue;
				}
				if(charArray1[i]==charArray2[j]) {
					charArray1[i] = '_';
					charArray2[j]= '_';
					break;
				}
			}
		}
		
	}
	
}
