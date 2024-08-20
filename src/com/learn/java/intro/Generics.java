//$Id$
package com.learn.java.intro;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>This class represents the use cases of Generics.</p>
 */
public class Generics {
	
	public static void main(String[] args) {
		
		//Generic Class.
		GenericWrapper<String> stringTypeObject = new GenericWrapper<String>();
		stringTypeObject.setTypeObject("This is string type object.");
		System.out.println("String Type Object: "+stringTypeObject.getTypeObject());
		
		GenericWrapper<Integer> integerTypeObject = new GenericWrapper<Integer>();
		integerTypeObject.setTypeObject(100);
		System.out.println("Integer Type Object: "+integerTypeObject.getTypeObject());
		
		//WildCard Generics. Anonymous type of object in a collection with an lower bound, i.e only accepts object which is parent of or equal to Number.
		List<? super Number> list = new ArrayList<Number>();
		list.add(5);//Adding integer to the list.
		list.add(5.1);//Adding float to the list.
		
		System.out.println("List with a generic type of number: "+list);
		
		//Using wild card generics.
		List<Integer> array = new ArrayList<Integer>();
		array.add(11);
		array.add(19);
		array.add(25);
		array.add(30);
		array.add(43);
		integerTypeObject.unboundWildCardMethod(array);
		integerTypeObject.upperBoundWildCardMethod(array);
		integerTypeObject.lowerBoundWildCardMethod(array);
	}
	
}

/**
 * <p>This is a Generic class which wraps a type which will be only declared at compile time.</p>
 * @param <T> Any Types of Object except primitive types.
 */
class GenericWrapper<T>{
	
	T typeObject;
	/**
	 * <p>This is a Generic method which takes argument of any type of object.</p>
	 * @param typeObject any type of object.
	 */
	public void setTypeObject(T typeObject) {
		this.typeObject = typeObject;
	}
	
	/**
	 * <p>This is a Generic method which returns object of any type.</p>
	 * @return typeObject any type of object.
	 */
	public T getTypeObject() {
		return typeObject;
	}
	
	/**
	 * <p>Using unbound wild card generic for traversing a list.</p>
	 * @param list list to be traversed, whose elements type is unknown.
	 */
	public void unboundWildCardMethod(List<?> list) {
		System.out.print("[ ");
		for(Object element : list) {
			System.out.print(element+" ");
		}
		System.out.println("]");
	}
	
	/**
	 * <p>Using upper bound wild card generic for traversing a list.</p>
	 * @param list list to be traversed, whose elements type is upper bound class or its sub class.
	 */
	public void upperBoundWildCardMethod(List<? extends Number> list) {
		System.out.print("[ ");
		for(Object element : list) {
			System.out.print(element+" ");
		}
		System.out.println("]");
	}
	
	/**
	 * <p>Using lower bound wild card generic for writing a list.</p>
	 * @param list list to be appended, whose elements type is lower bound class or its super class.
	 */
	public void lowerBoundWildCardMethod(List<? super Integer> list) {
		for(int i=0; i<10; i++) {
			list.add(i+1);
		}
		System.out.println(list);
	}
	
}