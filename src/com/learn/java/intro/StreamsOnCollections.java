package com.learn.java.intro;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;



/**
 * <p>This class represents the implementations of Streams on Collections</p>
 */
public class StreamsOnCollections {

	public static void main(String[] args) {
		StreamsOnCollections object = new StreamsOnCollections();
		
		/**
		 * This program show cases the use of reduce method.
		 */
		object.usingReduceMethodOfStreams();
		
		/**
		 * This method show cases the use of map and filter method.
		 */
		object.mapsFiltersAndSortsOnStreams();
		
		/**
		 * This program shows the use case of forEach on streams.
		 */
		object.forEachOnStreams();
	}
	
	/**
	 * <p>
	 * This method implements the reduce method which may return Optional, or Identity objects.
	 * The reduce method is a Terminal Operation, which does not return stream.
	 * </p>
	 */
	public void usingReduceMethodOfStreams() {
		
		/**
		 * This returns Optional Integer object, as the stream might be empty, in order to avoid null conflicts.
		 * So, if there is no elements in the stream, then the get method of Optional Integer object throws NoSuchElementException. 
		 */
		List<Integer> list = java.util.Arrays.asList(1,2,3,4,5);
		Optional<Integer> sum1 = list.stream().reduce((x,y) -> x+y);
		System.out.println("Sum of elements in the list using reduce method of Stream without giving initial value: "+sum1.get());//This returns the sum.
		
		list = java.util.Arrays.asList();
		Optional<Integer> sum2 = list.stream().reduce((x,y) -> x+y);
//		System.out.println("Sum of elements in the empty list using reduce method of Stream without giving initial value: "+sum2.get());//This throws Exception as the stream is empty.
		
		
		/**
		 * This always returns a value, null will not be returned as we are giving the initial value.
		 */
		int sum3 = list.stream().reduce(0, (x,y) -> x+y);
		System.out.println("Sum of elements in the list using reduce method of Stream giving initial value: "+sum3);
		
		
		/**
		 * This program divides stream into multiple streams and executes reduce method on those streams asynchronously.
		 */
		list = java.util.Arrays.asList(1,2,3,4,5);
		/**
		 * This reduce method takes 1 initial value and 2 functions as parameter. First function is to operate on multiple streams, and the second function is to operate on the result of those streams.
		 */
		int sum4 = list.parallelStream().reduce(0, (x, y) -> x+y, (x, y) -> x+y);
		System.out.println("Sum of elements in the list using paralles stream and reduce method of Stream giving initial value: "+sum4);
	}
	
	/**
	 * <p>
	 * This method show cases the map and filter functionality on streams which are intermediate operations which again returns a stream.
	 * The collect method is a Terminal Operation which does not return stream.
	 * </p>
	 */
	public void mapsFiltersAndSortsOnStreams() {
		
		List<String> list = Arrays.asList("Apple", "Banana", "Citrus", "Dragon", "Elephant");
		/**
		 * This filters the stream by removing the elements which are having length less than or equal to 5;
		 */
		Stream stream1 = list.stream().filter((x) -> x.length()>5);
		list = (List<String>) stream1.collect(Collectors.toList());//Embedding the filtered stream to list.
		System.out.println("Filtered List: "+list);
		
		/**
		 * This map method, applies the given function to all the elements in the stream and returns the stream.
		 */
		Stream stream2 = list.stream().map((x) -> x.toUpperCase());
		list = (List<String>) stream2.collect(Collectors.toList());//Embedding the mapped stream to list.
		System.out.println("Mapped List: "+list);
		
		/**
		 * This program sorts the stream and returns the stream. If comparator is provided, then it sorts according to the comparator logic, else it sorts according to the natural ordering.	
		 */
		Stream stream3 = list.stream().sorted(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			};
		});
		list = (List<String>) stream3.collect(Collectors.toList());//Embedding the sorted stream to list.
		System.out.println("Descending Sorted List: "+list);
	}
	
	/**
	 * <p>
	 * This method show cases the use of forEach method in streams.
	 * The forEach method is also a Terminal Operation which does not return streams, but executes a function on all the elements of the stream.
	 * </p>
	 */
	public void forEachOnStreams() {
		
		List<String> list = Arrays.asList("Apple", "Banana", "Citrus", "Dragon", "Elephant");
		
		/**
		 * This just prints the all the string in the stream.
		 */
		list.stream().forEach((String x) -> System.out.println(x));
	}
	
}
