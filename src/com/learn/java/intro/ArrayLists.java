package com.learn.java.intro;

import java.util.ArrayList;

/**
 * <p>This class implements the important functionalities of the class ArrayList</p>
 */
public class ArrayLists {
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(1);// Inserts an element in the end of an array. If the capacity if full then it will resize its array buffer by assigning a new array buffer of doubled capacity and adds all the elements.
		ArrayList<Integer> tempArray = new ArrayList<Integer>(array);// Initialising a new ArrayList by passing a copy of other ArrayList in the constructor.
		System.out.println(array);
		array.add(0,2);//Inserts an element at a given index and shifts the elements from the given index to the right and increments the size.
		System.out.println(array);
		array.set(1, 3); //Replaces an element at the given index, this does not increments the size.
		System.out.println(array);
		array.remove(0); //Removes the element at a given index, and shifts the elements after the given index towards left and decrements the size by 1.
		System.out.println(array);
		array.remove(Integer.valueOf(3)); //Removes the first occurrence of the given element, and shifts the elements after the given index towards left and decrements the size by 1.
		System.out.println(array);
		array.addAll(tempArray); //Inserts the given ArrayList at the end of the ArrayList.
		System.out.println(array);
		array.addAll(0,tempArray);//Inserts the given ArrayList at the given index and shifts all the elements from the given index to right.
		System.out.println(array);
	}
}
