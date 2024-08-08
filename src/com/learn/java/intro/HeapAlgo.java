package com.learn.java.intro;

import java.util.Arrays;

/**
 * <p>Efficient Algorithm for finding all permutations for the given array of elements.</p>
 */
public class HeapAlgo {
    
	/**
	 * <p>Recursive method which swaps elements of the array to find different permutations.</p>
	 * @param a array of elements
	 * @param size no of selected elements from the array for permutation.
	 */
    public void heapPermutation(int a[], int size) {
    	if (size == 1) {
        	System.out.println(Arrays.toString(a));
        	return;
    	}

    	for (int i = 0; i < size; i++) {
        	heapPermutation(a, size - 1);
        	if (size % 2 == 1) {
         		int temp = a[0];
            	a[0] = a[size - 1];
            	a[size - 1] = temp;
        	} 
        	else {
            	int temp = a[i];
            	a[i] = a[size - 1];
            	a[size - 1] = temp;
        	}
    	}
    }

    
    public static void main(String args[])
    {
        HeapAlgo obj = new HeapAlgo();
        int[] a = { 1,2,3,4,5,6,7,8,9,10,11 };
        obj.heapPermutation(a, a.length);
    }
    
}
