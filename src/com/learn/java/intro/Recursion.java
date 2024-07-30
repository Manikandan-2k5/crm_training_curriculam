package com.learn.java.intro;

import java.util.ArrayList;

/**
 * <p>This class describes the recursion concept</p>
 */
public class Recursion {
	
	
	public static void main(String[] args) {
		Recursion recursion = new Recursion();
		System.out.println(recursion.fibonacciSeries(100));
	}
	
	/**
	 * <p>Returns the fibonacci series in an ArrayList</p>
	 * @param limit end range
	 * @return returns the fibonacci series in an ArrayList
	 */
	public ArrayList<Integer> fibonacciSeries(int limit){
		ArrayList<Integer> series = new ArrayList<Integer>();
		series.add(0);
		series.add(1);
		return recursiveMethod(series, limit);
	}
	
	/**
	 * <p>Recursive method for adding fibonacci series elements</p>
	 * @param series fibonacci series
	 * @param limit end range
	 * @return returns the fibonacci series
	 */
	public ArrayList<Integer> recursiveMethod(ArrayList<Integer> series, int limit){
		if(series.get(series.size()-1)+series.get(series.size()-2)>limit) { //Recursion Break Condition
			return series;
		}
		else {//Recursion Logic
			series.add(series.get(series.size()-1)+series.get(series.size()-2));
			return recursiveMethod(series, limit);
		}
	}
}
