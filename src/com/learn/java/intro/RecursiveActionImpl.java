package com.learn.java.intro;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * <p>This class is an implementation of RecursiveAction, which recursively divides the nested array into smaller segments and sorts.</p>
 */
public class RecursiveActionImpl extends RecursiveAction{
	

	private int[][] nestedArray;
	private int start;
	private int end;
	private static final int THRESHOLD = 1;

	public RecursiveActionImpl(int[][] nestedArray, int start, int end) {
		this.nestedArray = nestedArray;
		this.start = start;
		this.end = end;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		int[][] arrayOfArrays = {
			    {21, 22, 20, 19},
			    {10, 3, 5, 7, 2, 1},
			    {14, 11, 18},
			    {6, 12, 13},
			    {27, 25, 24, 23},
			    {30, 29},
			    {9, 8},
			    {16, 15, 17},
			    {35, 32, 31},
			    {4},
			    {28, 26},
			    {36},
			    {40, 38, 37},
			    {41, 42, 39},
			    {33},
			    {43, 44, 45},
			    {50, 46, 47, 48},
			    {52, 49},
			    {51},
			    {54, 53, 55}
			};

		RecursiveActionImpl mainTask = new RecursiveActionImpl(arrayOfArrays, 0, arrayOfArrays.length);
		
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		pool.invoke(mainTask);
		
		System.out.print("Sorted Nested Array: ");
		Arrays.print2DArray(arrayOfArrays);
		
		int[] array = {1,2,3,4,5,6,7,8,9};
		
		RecursiveTaskImpl recursiveTask = new RecursiveTaskImpl(array, 0, array.length, 9);
		pool.invoke(recursiveTask);
		System.out.println("Index of the given element: "+recursiveTask.get());
		
	}
	
	@Override
	protected void compute() {
		
		if(end-start>THRESHOLD) {
			
			int mid = start + (end-start)/2;
			
			RecursiveActionImpl subTask1 = new RecursiveActionImpl(nestedArray, start, mid);
			RecursiveActionImpl subTask2 = new RecursiveActionImpl(nestedArray, mid, end);
			
			subTask1.fork();
			subTask2.fork();
			
			subTask1.join();
			subTask2.join();
			
		}
		
		else {
			java.util.Arrays.sort(nestedArray[start]);
		}
		
	}
	
}

/**
 * <p>
 * This class is an implementation of RecursiveTask, which recursively divides the array into smaller segments and and finds the index of the given element.
 * Input array should be sorted.
 * </p>
 */
class RecursiveTaskImpl extends RecursiveTask<Integer>{
	
	private int[] array;
	private int start;
	private int end;
	private int element;

	public RecursiveTaskImpl(int[] array, int start, int end, int element) {
		this.array = array;
		this.start = start;
		this.end = end;
		this.element = element;
	}

	@Override
	protected Integer compute() {
		
		
		if(start>end) {
			return -1;
		}
		
		int mid = start+(end-start)/2;
		
		if(element==array[mid]) {
			return mid;
		}
		
		else {
			
			if(element>array[mid]) {
				RecursiveTaskImpl subtask = new RecursiveTaskImpl(array, mid+1, end, element);
				subtask.fork();
				return subtask.join();
				
			}
			else {
				RecursiveTaskImpl subtask = new RecursiveTaskImpl(array, start, mid-1, element);
				subtask.fork();
				return subtask.join();
			}
			
		}
	}
	
	
	
}
