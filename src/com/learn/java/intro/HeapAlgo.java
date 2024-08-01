package com.learn.java.intro;

import java.util.Arrays;

public class HeapAlgo {
    
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
        int[] a = { 1,2,3 };
        obj.heapPermutation(a, a.length);
    }
}
