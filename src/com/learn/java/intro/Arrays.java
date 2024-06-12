package com.learn.java.intro;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Arrays {
    public static void main(String[] args) {
        Arrays arrayFunctions = new Arrays();
        int[] array = new int[]{-1,-2,-8,-3,-1,0,3,-3,1,-9,6};
        int[] array1 = new int[]{1,3,2,4,5,2,2,4,5,2,2};
        int[] emptyArray = new int[]{};
        int[] array2 = new int[]{1};
        // arrayFunctions.printElementsAndIndex(array);
        // try {
        //     System.out.println("Second Largest Element: "+arrayFunctions.secondLargestElement(array1));
        // } 
        // catch (Exception e) {
        //     e.printStackTrace();
        // }
        // try {
        //     System.out.println("Third Smallest Element: "+arrayFunctions.thirdSmallestElement(array));
        // } 
        // catch (Exception e) {
        //     e.printStackTrace();
        // }
        // arrayFunctions.print(arrayFunctions.copy(array));
        // arrayFunctions.reversePrint(array);
        // arrayFunctions.print(arrayFunctions.reverse(array));
        // arrayFunctions.sumOfOddAndEvenIndexNumbers(array2);
        // arrayFunctions.occurenceAndPositions(array, 6);
        // arrayFunctions.replace(5, 3, array1);
        // arrayFunctions.print(array1);
        // arrayFunctions.sort(array2, false);
        // arrayFunctions.print(array);
        // arrayFunctions.print(arrayFunctions.concatenate(array, array1));
        // try {
        //     array1 = arrayFunctions.deleteDuplicates(array1);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        // arrayFunctions.print(array1);
        // int[] setArray = arrayFunctions.getSetArray();
        // arrayFunctions.print(setArray);
        // int[] incrementalArray = arrayFunctions.getIncrementalArray();
        // arrayFunctions.print(incrementalArray);
        // arrayFunctions.splitOddEven(array);
        int[][] nestedArray1 = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] nestedArray2 = new int[][]{{1,2,3}};
        int[][] matrix = new int[][] {{1,0,0},{0,1,0},{0,0,1}};
        // System.out.println("Is two matrices are equal: "+arrayFunctions.twoMatricesEquals(nestedArray1, nestedArray2));
        // arrayFunctions.print2DArray(nestedArray);
        // arrayFunctions.addMatrix(nestedArray1, nestedArray2);
        // arrayFunctions.subtractMatrix(nestedArray1, nestedArray2);
        //arrayFunctions.multiplyMatrix(nestedArray1, nestedArray2);
        //arrayFunctions.transposeOfMatrix(nestedArray1);
        //System.out.println(arrayFunctions.isIdentityMatrix(matrix));
        //System.out.println(arrayFunctions.isScalarMatrix(matrix));
        //System.out.println(arrayFunctions.isDiagonalMatrix(matrix));
    }

    public void printElementsAndIndex(int[] array){
        if(array.length==0){
            System.out.println("Array is empty.");
        }
        else{
            for(int i=0; i<array.length; i++){
                System.out.println(array[i]+" at index "+i);
            }
        }
    }

    public int secondLargestElement(int[] array) throws Exception{
        if(array.length==0){
            throw new Exception("Array is empty.");
        }
        else if(array.length<2){
            throw new Exception("Array length should be greater than or equal to 2 inorder to find second largest value");
        }
        else{
            int first = array[0];
            int second = array[1];
            for(int i: array){
                if(i<first && i>second){
                    second = i;
                }
                else if(i>first){
                    int temp = first;
                    first = i;
                    second = temp;
                }
                else{
                    continue;
                }
            }
            return second;
        }
    }

    public int thirdSmallestElement(int[] array) throws Exception{
        if(array.length==0){
            throw new Exception("Array is empty.");
        }
        else if(array.length<3){
            throw new Exception("Array length should be greater than or equal to 3 inorder to find third smallest value");
        }
        else{
            int first = array[0];
            int second = array[1];
            int third = array[2];
            for(int i: array){
                if((i>first && i>second) && i<third){
                    third = i;
                }
                else if(i>first && i<second){
                    int temp = second;
                    second = i;
                    third = temp;
                }
                else if(i<first){
                    int temp = first;
                    first = i;
                    third = second;
                    second = temp;
                }
                else{
                    continue;
                }
            }
            return third;
        }
    }

    public void print(int[] array){
        System.out.print("[");
        for(int i=0; i<array.length; i++){
            if(i==array.length-1){
                System.out.print(array[i]);
                continue;
            }
            System.out.print(array[i]+",");
        }
        System.out.print("]\n");
    }

    public int[] copy(int[] array){
        if(array.length==0){
            return new int[0];
        }
        else{
            int[] copy = new int[array.length];
            int index = 0;
            for(int i: array){
                copy[index] = i;
                index++;
            }
            return copy;
        }
    }

    public void reversePrint(int[] array){
        System.out.print("[");
        for(int i=array.length-1; i>=0; i--){
            if(i==0){
                System.out.print(array[i]);
                continue;
            }
            System.out.print(array[i]+",");
        }
        System.out.print("]\n");
    }

    public int[] rinteverse(int[] array){
        if(array.length<=1){
            return array;
        }
        else{
            int backIndex = array.length-1;
            for(int i=0; i<array.length/2; i++){
                int temp = array[backIndex];
                array[backIndex] = array[i];
                array[i] = temp;
                backIndex--;
            }
            return array;
        }
    }

    public void sumOfOddAndEvenIndexNumbers(int[] array){
        if(array.length==0){
            System.out.println("Even index numbers sum: "+0);
            System.out.println("Odd index numbers sum: "+0);
        }
        else{
            int evenSum = 0;
            int oddSum = 0;
            for(int i=0; i<array.length; i++){
                if(i%2==0){
                    evenSum+=array[i];
                }
                else{
                    oddSum+=array[i];
                }
            }
            System.out.println("Even index numbers sum: "+evenSum);
            System.out.println("Odd index numbers sum: "+oddSum);
        }
    }

    public void occurenceAndPositions(int[] array, int num){
        if(array.length==0){
            System.out.println("Array is Empty");
        }
        else if(array.length==1 && array[0]==num){
            System.out.println("The Number "+num+" is at the position: "+0);
            System.out.println("Occurence of "+num+": "+1);
        }
        else if(array.length==1 && array[0]!=num){
            System.out.println("Number not found");
        }
        else{
            int occurence = 0;
            for(int i=0; i<array.length; i++){
                if(array[i]==num){
                    System.out.println("The Number "+num+" is at the position: "+i);
                    occurence++;
                }
            }
            if(occurence==0){
                System.out.println("Number not found");
            }
            else{
                System.out.println("Occurence of "+num+": "+occurence);
            }
        }
    }

    public void replace(int num1, int num2, int[] array){
        if(array.length==0){
            System.out.println("Array is Empty");
        }
        else if(array.length==1 && array[0]==num1){
            array[0]=num2;
        }
        else if(array.length==1 && array[0]!=num1){
            System.out.println("Number not found");
        }
        else{
            boolean isPresent = false;
            for(int i=0; i<array.length; i++){
                if(array[i]==num1){
                    isPresent = true;
                    array[i] = num2;
                    break;
                }
            }
            if(!isPresent){
                System.out.println("Number not found");
            }
        }
    }

    public void sort(int[] array, boolean ascending){
        if(array.length==0){
            System.out.println("Array is Empty");
        }
        else if(array.length==1){
            //No sorting needed as it contains one element.
        }
        else{
            if(ascending){
                for(int i=0; i<array.length; i++){
                    for(int j=0; j<i+1; j++){
                        if(array[i]<array[j]){
                            int temp = array[j];
                            array[j] = array[i];
                            array[i] = temp;
                        }
                    }
                }
            }
            else{
                for(int i=0; i<array.length; i++){
                    for(int j=0; j<i+1; j++){
                        if(array[i]>array[j]){
                            int temp = array[j];
                            array[j] = array[i];
                            array[i] = temp;
                        }
                    }
                }
            }
        }

    }

    public int[] concatenate(int[] array1, int[] array2){
        if(array1.length==0 && array2.length==0){
            return new int[0];
        }
        else if(array1.length==0){
            return array2;
        }
        else if(array2.length==0){
            return array1;
        }
        else{
            int[] result = new int[array1.length+array2.length];
            int index = 0;
            for(int i: array1){
                result[index] = i;
                index++;
            }
            for(int i: array2){
                result[index] = i;
                index++;
            }
            return result;
        }
    }

    public int[] deleteDuplicates(int[] array) throws Exception{
        if(array.length<=1){
            return array;
        }
        else{
            HashMap<Integer, Integer> occurences = new HashMap<Integer, Integer>();
            int deleteKey = maximum(array)+1;
            for(int i=0; i<array.length; i++){
                if(occurences.get(array[i])==null){
                    occurences.put(array[i], 1);
                }
                else{
                    occurences.put(array[i], occurences.get(array[i])+1);
                }
            }
            for(int i=array.length-1; i>=0; i--){
                if(occurences.get(array[i])>1){
                    occurences.put(array[i], occurences.get(array[i])-1);
                    for(int j=i; j<array.length; j++){
                        if(j==array.length-1){
                            array[j] = deleteKey;
                            break;
                        }
                        array[j] = array[j+1];
                    }
                }
            }
            int length = 0;
            for(int i=0; i<array.length; i++){
                if(array[i]==deleteKey){
                    break;
                }
                length++;
            }
            int[] duplicateLessArray = new int[length];
            for(int i=0; i<length; i++){
                duplicateLessArray[i] = array[i];
            }
            array = duplicateLessArray;
            return array;
        }
    }   

    public int maximum(int[] array) throws Exception{
        if(array.length==0){
            throw new Exception("Array is Empty.");
        }
        else if(array.length==1){
            return array[0];
        }
        else{
            int maximum = 0;
            for(int i=0; i<array.length; i++){
                if(i==0){
                    maximum = array[i];
                }
                else{
                    if(array[i]>maximum){
                        maximum=array[i];
                    }
                }
            }
            return maximum;
        }
    }

    public int[] getSetArray(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[5];
        System.out.println("Enter values(Integer) for an array of size "+array.length);
        System.out.println("All the values should be Unique.\n");
        for(int i=0; i<array.length; i++){
            try{
                System.out.print("Enter value "+(i+1)+": ");
                int value = reader.read();
                reader.readLine();
                while(true){
                    if((value>=65 && value<=90) || (value>=97 && value<=122)){
                        System.out.println("Wrong Number Format !!!\n");
                    }
                    else if(isPresent(array, Integer.parseInt((char)value+""))){
                        System.out.println("Already this value exists in array\n");
                    }
                    else{
                        break;
                    }
                    System.out.print("Enter value "+(i+1)+": ");
                    value = reader.read();
                    reader.readLine();
                }
                System.out.println();
                array[i] = Integer.parseInt((char)value+"");
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return array;
    }

    public boolean isPresent(int[] array, int num){
        if(array.length==0){
            return false;
        }
        else if(array.length==1 && array[0]==num){
            return true;
        }
        else if(array.length==1 && array[0]!=num){
            return false;
        }
        else{
            for(int i: array){
                if(i==num){
                    return true;
                }
            }
            return false;
        }
    }

    public int[] getIncrementalArray(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[5];
        System.out.println("Enter values(Integer) for an array of size "+array.length);
        System.out.println("All the values should be larger than the previous value except first value.\n");
        for(int i=0; i<array.length; i++){
            try{
                System.out.print("Enter value "+(i+1)+": ");
                int value = reader.read();
                reader.readLine();
                while(true){
                    if((value>=65 && value<=90) || (value>=97 && value<=122)){
                        System.out.println("Wrong Number Format !!!");
                    }
                    else if(i!=0 && !isGreaterThan(Integer.parseInt((char)value+""), array[i-1])){
                        System.out.println("This Number is smaller than or equal to Last Number !!!");
                    }
                    else if(i==0){
                        break;
                    }
                    else{
                        break;
                    }
                    System.out.print("Enter value "+(i+1)+": ");
                    value = reader.read();
                    reader.readLine();
                }
                System.out.println();
                array[i] = Integer.parseInt((char)value+"");
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return array;
    }

    public boolean isGreaterThan(int num1, int num2){
        if(num1>num2){
            return true;
        }
        return false;
    }

    public void splitOddEvinten(int[] array){
        if(array.length==0){
            System.out.println("Array is Empty");
        }
        else{
            ArrayList<Integer> evenArray = new ArrayList<Integer>();
            ArrayList<Integer> oddArray = new ArrayList<Integer>();
            for(int i: array){
                if(i%2==0){
                    evenArray.add(i);
                }
                else{
                    oddArray.add(i);
                }
            }
            System.out.println("Even Elements: "+evenArray);
            System.out.println("Odd Elements: "+oddArray);
        }
    }

    public void print2DArray(int[][] array){
        for(int i=0 ;i<array.length; i++){
            if(i==0){
                System.out.print("[[");
            }
            else{
                System.out.print("[");
            }
            for(int j=0; j<array[i].length; j++){
                if(j==array[i].length-1){
                    System.out.print(array[i][j]);
                }
                else{
                    System.out.print(array[i][j]+",");
                }
            }
            if(i==array.length-1){
                System.out.println("]]");
            }
            else{
                System.out.print("],");
            }
        }
    }
    
    public void printMatrix(int[][] array){
        for(int i=0 ;i<array.length; i++){
        	System.out.print("[");
            for(int j=0; j<array[i].length; j++){
                if(j==array[i].length-1){
                    System.out.print(array[i][j]);
                }
                else{
                    System.out.print(array[i][j]+" ");
                }
            }
            System.out.print("]\n");
        }
    }

    public int minimum(int[] array) throws Exception{
        if(array.length==0){
            throw new Exception("Array is Empty.");
        }
        else if(array.length==1){
            return array[0];
        }
        else{
            int minimum = 0;
            for(int i=0; i<array.length; i++){
                if(i==0){
                    minimum = array[i];
                }
                else{
                    if(array[i]<minimum){
                        minimum=array[i];
                    }
                }
            }
            return minimum;
        }
    }

    public boolean twoMatricesEquals(int[][] matrix1, int[][] matrix2){
        int matrix1RowLength = matrix1.length;
        int matrix1Columnlength = matrix1[0].length;
        int matrix2RowLength = matrix2.length;
        int matrix2Columnlength = matrix2[0].length;

        if(matrix1RowLength!=matrix2RowLength || matrix1Columnlength!=matrix2Columnlength){
            return false;
        }
        else{
            for(int i=0; i<matrix1RowLength; i++){
                for(int j=0; j<matrix2Columnlength; j++){
                    if(matrix1[i][j]!=matrix2[i][j]){
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public void addMatrix(int[][] matrix1, int[][] matrix2){
        int matrix1RowLength = matrix1.length;
        int matrix1Columnlength = matrix1[0].length;
        int matrix2RowLength = matrix2.length;
        int matrix2Columnlength = matrix2[0].length;
        int[][] resultMatrix = new int[matrix1RowLength][matrix2Columnlength];
        if(matrix1RowLength!=matrix2RowLength || matrix1Columnlength!=matrix2Columnlength){
            System.out.println("Order of two matrices are not equal, hence cannot add two matrices.");
        }
        else{
            for(int i=0; i<matrix1RowLength; i++){
                for(int j=0; j<matrix2Columnlength; j++){
                    resultMatrix[i][j] = matrix1[i][j]+matrix2[i][j];
                }
            }
            System.out.println("Result Matrix: ");
            printMatrix(resultMatrix);
        }
    }

    public void subtractMatrix(int[][] matrix1, int[][] matrix2){
        int matrix1RowLength = matrix1.length;
        int matrix1Columnlength = matrix1[0].length;
        int matrix2RowLength = matrix2.length;
        int matrix2Columnlength = matrix2[0].length;
        int[][] resultMatrix = new int[matrix1RowLength][matrix2Columnlength];
        if(matrix1RowLength!=matrix2RowLength || matrix1Columnlength!=matrix2Columnlength){
            System.out.println("Order of two matrices are not equal, hence cannot add two matrices.");
        }
        else{
            for(int i=0; i<matrix1RowLength; i++){
                for(int j=0; j<matrix2Columnlength; j++){
                    resultMatrix[i][j] = matrix1[i][j]-matrix2[i][j];
                }
            }
            System.out.println("Result Matrix: ");
            printMatrix(resultMatrix);
        }
    }

    public void multiplyMatrix(int[][] matrix1, int[][] matrix2){
        int matrix1RowLength = matrix1.length;
        int matrix1Columnlength = matrix1[0].length;
        int matrix2RowLength = matrix2.length;
        int matrix2Columnlength = matrix2[0].length;
        int[][] resultMatrix = new int[matrix1RowLength][matrix2Columnlength];
        if(matrix1Columnlength!=matrix2RowLength){
            System.out.println("Multiplication betwwen the two matrices is not possible.");
        }
        else{
        	int matrix1RowIndex = 0;
        	int matrix2RowIndex = 0;
        	int matrix1ColumnIndex = 0;
        	int matrix2ColumnIndex = 0;
            for(int i=0; i<matrix1RowLength; i++) {
            	for(int j=0; j<matrix2Columnlength; j++) {
            		int sum = 0;
            		for(int k=0; k<matrix2RowLength; k++) {
            			sum += matrix1[matrix1RowIndex][matrix1ColumnIndex]*matrix2[matrix2RowIndex][matrix2ColumnIndex]; 
                		matrix1ColumnIndex++;
                		matrix2RowIndex++;
            		}
            		resultMatrix[i][j] = sum;
            		matrix2RowIndex = 0;
            		matrix2ColumnIndex++;
            		matrix1ColumnIndex = 0;
            	}
            	matrix1RowIndex++;
            	matrix1ColumnIndex = 0;
            	matrix2RowIndex = 0;
            	matrix2ColumnIndex = 0;
            }
            System.out.println("Result Matrix: ");
            printMatrix(resultMatrix);
        }
    }
    
    public void transposeOfMatrix(int[][] matrix) {
    	int rows = matrix.length;
    	int columns = matrix[0].length;
    	int[][] transpose = new int[columns][rows];
    	for(int i=0; i<columns; i++) {
    		for(int j=0; j<rows; j++) {
    			transpose[i][j] = matrix[j][i];
    		}
    	}
    	printMatrix(transpose);
    }
    
    public boolean isSquareMatrix(int[][] matrix) {
    	if(matrix.length==0) {
    		return false;
    	}
    	else if(matrix.length!=matrix[0].length) {
    		return false;
    	}
    	else {
    		for(int i=0; i<matrix.length; i++) {
    			if(matrix[i].length!=matrix.length) {
    				return false;
    			}
    		}
    		return true;
    	}
    }
    
    public boolean isIdentityMatrix(int[][] matrix) {
    	if(!isSquareMatrix(matrix)) {
    		return false;
    	}
    	else {
    		for(int i=0; i<matrix.length; i++) {
    			for(int j=0; j<matrix[i].length; j++) {
    				if(i==j && matrix[i][j]==1) {
    					continue;
    				}
    				else if(i!=j && matrix[i][j]==0) {
    					continue;
    				}
    				else {
    					return false;
    				}
    			}
    		}
    		return true;
    	}
    }
    
    public boolean isScalarMatrix(int[][] matrix) {
    	if(!isSquareMatrix(matrix)) {
    		return false;
    	}
    	else {
    		int key = matrix[0][0];
    		for(int i=0; i<matrix.length; i++) {
    			for(int j=0; j<matrix[i].length; j++) {
    				if(i==j && matrix[i][j]==key) {
    					continue;
    				}
    				else if(i!=j && matrix[i][j]==0) {
    					continue;
    				}
    				else {
    					return false;
    				}
    			}
    		}
    		return true;
    	}
    }
    
    public boolean isDiagonalMatrix(int[][] matrix) {
    	if(!isSquareMatrix(matrix)) {
    		return false;
    	}
    	else {
    		for(int i=0; i<matrix.length; i++) {
    			for(int j=0; j<matrix[i].length; j++) {
    				if(i==j) {
    					continue;
    				}
    				else if(i!=j && matrix[i][j]==0) {
    					continue;
    				}
    				else {
    					return false;
    				}
    			}
    		}
    		return true;
    	}
    }
}
