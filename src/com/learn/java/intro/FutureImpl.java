package com.learn.java.intro;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureImpl {
	
	public static void main(String[] args) {
		
		/*
		 * Adding elements to the array.
		 */
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		
		/*
		 * Initialising the future object.
		 */
		Future<Integer> future = calculate(numbers);
		
		/* This code will wait for 5 seconds for the future object to return the result,
		 * if not TimeoutException will be thrown.
		 * So 5 seconds are gone now, still 5 seconds are left to return the result
		 */
		get(future, 2000, TimeUnit.MILLISECONDS); 
	
		/*
		 * This code will wait until the thread returns the value or throws an exception. 
		 * If thread is interrupted or an Exception occurred during the process of task this method will terminate throwing the same error.
		 */
		get(future);
		
		System.out.println("Has the task completed: "+future.isDone());//Returns true if the task has completed or terminated due to an exception or cancelled. If it is in progress then it returns false.
		System.out.println("Has the task got cancelled: "+future.isCancelled());//Returns true if the task has been cancelled before it completed, else returns false.
		
		/*
		 * Cancels the task executing in the thread.
		 * 
		 * If the parameter is given true, then the task will be cancelled, 
		 * even when the thread is executing the task, by interrupting the thread,
		 * or even when the task is not started by the thread.
		 * 
		 * If the parameter is given false, then the task will be cancelled,
		 * only when the task is not started being executed by the thread,
		 * otherwise it cannot cancel the task.
		 * 
		 * Returns true ,if cancels else return false.
		 */
		System.out.println("Has the task been cancelled: "+future.cancel(true));
		
		
	}
	
	/**
	 * <p>This method represents, how to create a future object using an ExecutorService object which takes a Callable Interface who's call() function sums the elements in the given array and returns the total, and finally returns the Future Object.</p>
	 * @param numbers array of numbers which are to be summed up and returned.
	 * @return returns the Future Object through which we can get result.
	 */
	public static Future<Integer> calculate(ArrayList<Integer> numbers) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Integer> future = executor.submit(() -> {try{ Thread.sleep(5000);} catch(Exception e) {e.printStackTrace(); }  int sum = 0; for(int num : numbers) {sum+=num;} return sum;});
		return future;
	}
	
	/**
	 * <p>This method represents, how result is got from the Future object.</p>
	 * @param future Array of numbers to be summed up and returned by the Callable, which is in turn returned by the future object.
	 */
	public static void get(Future<Integer> future) {

		try {
			System.out.println("Sum of numbers in the array: "+future.get());//(Blocking code)This waits until the thread completes the task and returns the value or throws Exception, if the thread is interrupted or if an Exception occurred during the task.
		} 
		catch (InterruptedException e) {
			System.out.println("Task has been cancelled.");
		}
		catch (ExecutionException  e) {
			System.out.println("Some error occurred in the task.");
		}
	}
	
	/**
	 * <p>This method represents, how result is got from the Future object, within the given span of timeout.</p>
	 * @param future Array of numbers to be summed up and returned by the Callable, which is in turn returned by the future object.
	 */
	public static void get(Future<Integer> future, long timeout, TimeUnit unit) {

		try {
			System.out.println("Sum of numbers in the array: "+future.get(timeout, unit));//(Blocking code)This waits till the given timeout for the thread to complete the task and return the value or throws Exception, if the thread is interrupted or if an Exception occurred during the task. If timeout is exceeded then TimeoutException will be thrown. 
		} 
		catch (InterruptedException e) {
			System.out.println("Task has been cancelled.");
		}
		catch (ExecutionException  e) {
			System.out.println("Some error occurred in the task.");
		}
		catch(TimeoutException e) {
			System.out.println("Task is not completed in the given time.");
		}
	}
}
