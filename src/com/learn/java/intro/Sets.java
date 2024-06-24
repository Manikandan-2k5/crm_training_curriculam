package com.learn.java.intro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;


public class Sets {
	public static void main(String[] args) {
		Sets setFunction = new Sets();
		//setFunction.hashSetFunctions();
		//setFunction.linkedHashSetFunctions();
		setFunction.treeSetFunctions();
	}
	
	public void hashSetFunctions() {
		//HashSet gives an unordered set which means that it is not ordered as like we insert elements or like any other sorting techniques
		//Does not add duplicate values in the set when we try to add a duplicate value.
		HashSet<Integer> set = new HashSet<Integer>();
		ArrayList<Integer> array  = new ArrayList<>();
		array.add(5);
		array.add(6);
		array.add(16);
		array.add(23);
		array.add(25);
		array.add(20);
		array.add(17);
		//Adding Elements
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(5);//duplicate value will not be added
		set.add(6);
		set.add(7);
		set.add(8);
		set.add(9);
		set.add(6);
		set.add(7);//duplicate value will not be added
		set.add(8);//duplicate value will not be added
		set.add(11);
		set.add(12);
		set.add(19);
		set.add(14);
		System.out.println("Added Elements: "+set);// output of the set will be unordered collection of unique elements
		//Adding a collection
		set.addAll(array); //This allows to add the elements of a specified collection. If the element is already in the set, then it is ignored.
		System.out.println("Added a collection: "+set);				
		//set.clear();//clears the set.
		//System.out.println(set);
		HashSet<Integer> clonedSet = (HashSet<Integer>) set.clone();//returns a shallow copy of the set.changes made in cloned set does not affect the original set.
		System.out.println("Cloned Set: "+clonedSet);
		System.out.println("Is Set contains 5: "+set.contains(5));//returns true if the given element is present in the array else returns false.
		System.out.println("Is Set Empty: "+set.isEmpty());//returns true if the set is empty.
		System.out.println("Using Iterator to print Elements");
		Iterator<Integer> setIterator = set.iterator();//returns the iterator for the set to iterate over their objects.
		while(setIterator.hasNext()) {
			System.out.print(setIterator.next()+" ");
		}
		System.out.println();
		System.out.println("Is set contains all the elements of the given collection: "+set.containsAll(array));//checks whether all elements in the given array is present in the set.
		System.out.println("Object array of the set: "+set.toArray());//returns an Object[] which contains all the elements in the set
		System.out.println("Integer array of the given set: "+set.toArray(new Integer[0]));//returns an array of the given array type in the argument which contains all the elements in the set
		System.out.println("Is 5 removed from set: "+ set.remove(5));//removes the element from the set.returns true if the set has changed from one state to other.
		System.out.println("Set after the removal of 5: "+set);
		set.retainAll(array);//removes all elements from the set which are not the element of the given collection
		System.out.println("Set contains only the elements in the given collection: "+set);
		set.removeAll(array);//remove all the elements from set which are present in the given collection.
		System.out.println("Set after removing all the elements which are present in the given collection: "+set);
		System.out.println("Length of the set: "+set.size());//returns the length of the size.
	}
	
	public void linkedHashSetFunctions() {
		//LinkedHashSet gives an insertion ordered set which means that it is ordered as like we insert elements.
		//Does not add duplicate values in the set when we try to add a duplicate value.
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		ArrayList<Integer> array  = new ArrayList<>();
		array.add(5);
		array.add(6);
		array.add(16);
		array.add(23);
		array.add(25);
		array.add(20);
		array.add(17);
		//Adding Elements
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(5);//duplicate value will not be added
		set.add(6);
		set.add(7);
		set.add(8);
		set.add(9);
		set.add(6);
		set.add(7);//duplicate value will not be added
		set.add(8);//duplicate value will not be added
		set.add(11);
		set.add(12);
		set.add(19);
		set.add(14);
		System.out.println("Added Elements: "+set);// output of the set will be collection of unique elements and the order will be as same as we inserted every elements.
		//Adding a collection
		set.addAll(array); //This allows to add the elements of a specified collection. If the element is already in the set, then it is ignored.
		System.out.println("Added a collection: "+set);				
		//set.clear();//clears the set.
		//System.out.println(set);
		LinkedHashSet<Integer> clonedSet = (LinkedHashSet<Integer>) set.clone();//returns a shallow copy of the set.changes made in cloned set does not affect the original set.
		System.out.println("Cloned Set: "+clonedSet);
		System.out.println("Is Set contains 5: "+set.contains(5));//returns true if the given element is present in the array else returns false.
		System.out.println("Is Set Empty: "+set.isEmpty());//returns true if the set is empty.
		System.out.println("Using Iterator to print Elements");
		Iterator<Integer> setIterator = set.iterator();//returns the iterator for the set to iterate over their objects.
		while(setIterator.hasNext()) {
			System.out.print(setIterator.next()+" ");
		}
		System.out.println();
		System.out.println("Is set contains all the elements of the given collection: "+set.containsAll(array));//checks whether all elements in the given array is present in the set.
		System.out.println("Object array of the set: "+set.toArray());//returns an Object[] which contains all the elements in the set
		System.out.println("Integer array of the given set: "+set.toArray(new Integer[0]));//returns an array of the given array type in the argument which contains all the elements in the set
		System.out.println("Is 5 removed from set: "+ set.remove(5));//removes the element from the set.returns true if the set has changed from one state to other.
		System.out.println("Set after the removal of 5: "+set);
		set.retainAll(array);//removes all elements from the set which are not the element of the given collection
		System.out.println("Set contains only the elements in the given collection: "+set);
		set.removeAll(array);//remove all the elements from set which are present in the given collection.
		System.out.println("Set after removing all the elements which are present in the given collection: "+set);
		System.out.println("Length of the set: "+set.size());//returns the length of the size.		
	}
	
	
	public void treeSetFunctions() {
		TreeSet<Integer> treeSet1 = new TreeSet<Integer>();//A tree set stores all the elements in a sorted order. If the element implements comparable then it will sort according to that, else we can give comparator instance in the initialisation of the tree set. Ignores duplicate values.
		treeSet1.add(9);
		treeSet1.add(8);
		treeSet1.add(3);
		treeSet1.add(4);
		treeSet1.add(5);
		treeSet1.add(6);
		treeSet1.add(7);
		treeSet1.add(2);
		treeSet1.add(1);
		System.out.println("Tree Set: "+treeSet1);//print the set in an order according to the implementation of the  compareTo() method in the element class.
		Comparator<Integer> descendingOrderComparator = (Integer num1, Integer num2) -> num2 - num1;
		TreeSet<Integer> treeSet2 = new TreeSet<Integer>(descendingOrderComparator);//Passing custom comparator to order the tree set. sorts the trees set according to the comparator logic.
		treeSet2.addAll(treeSet1);//Adding a collection to the tree set, duplicate elements are ignored.
		System.out.println("Tree Set reverse order using Comparator: "+treeSet2);//prints the tree set in an order, who's logic is given by the comparator.
		System.out.println("First element: "+treeSet2.first()); //prints the first element in the set according to the comparator logic.
		System.out.println("Last element: "+treeSet2.last()); //prints the last element in the set according to the comparator logic.
		System.out.println("First element (removed after printing): "+treeSet2.pollFirst());//Prints and removes the first element from the set.
		System.out.println("Last element (rmeoved after printing): "+treeSet2.pollLast());//Prints and removes the last element from the set.
		System.out.println("Tree set after polling first and last element: "+treeSet2);//first and last element in the tree set are removed.
		System.out.println("The highest element in the set which is less than 5: "+treeSet1.lower(5));//prints the highest element in the set which is less than the given element.
		System.out.println("The lowest element in the set which is greater than 5: "+treeSet1.higher(5));//prints the lowest element in the set which is greater than the given element.
		System.out.println("The highest element in the set which is less than or equal to 5: "+treeSet1.floor(5));//prints the highest element in the set which is less than or equal to the given element.
		System.out.println("The lowest element in the set which is greater than equal to 5: "+treeSet1.ceiling(5));//prints the lowest element in the set which is greater than or equal to the given element.
	}
}
