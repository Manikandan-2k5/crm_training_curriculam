package com.learn.java.intro;
import java.util.ArrayList;

public class Patterns {
    public static void main(String[] args) {
        Patterns pattern = new Patterns();
        // pattern.fibonacciSeries(0);
        // System.out.println("Is Armstrong Number: "+pattern.isArmStrongNumber(408));
        // pattern.printAllArmstrongNumberBetweenRange(100, 999);
        // System.out.println("Is Strong Number: "+pattern.isStrongNumber(5));
        // pattern.pattern1(5);
        // pattern.pattern2(5);
        // pattern.pattern3(5, 2);
        // pattern.pattern4(3);
        // pattern.pattern5(9);
        // pattern.pattern7(7);
//        pattern.pattern8(5,5);
    }

    public void fibonacciSeries(int limit){
        int first = 0;
        int second = 1;
        ArrayList<Integer> fibonacciArray = new ArrayList<Integer>();
        fibonacciArray.add(first);
        fibonacciArray.add(second);
        int valueToBeAdded = first+second;
        while(valueToBeAdded<=limit){
            fibonacciArray.add(valueToBeAdded);
            int arraySize = fibonacciArray.size();
            valueToBeAdded = fibonacciArray.get(arraySize-1)+fibonacciArray.get(arraySize-2);
        }
        System.out.println(fibonacciArray);
    }

    public boolean isArmStrongNumber(int number){
        int result = 0;
        int copy = number;
        while(copy>0){
            int remainder = copy%10;
            result+=Math.pow(remainder, 3);
            copy/=10;
        }
        if(result==number){
            return true;
        }
        return false;
    }

    public void printAllArmstrongNumberBetweenRange(int start, int end){
        for(int i=start; i<=end; i++){
            if(isArmStrongNumber(i)){
                System.out.println(i);
            }
        }
    }

    public boolean isStrongNumber(int number){
        int result = 0;
        int copy = number;
        while(copy>0){
            int remainder = copy%10;
            int digitFactorial = 1;
            while(remainder>0){
                digitFactorial *= remainder;
                remainder--;
            }
            result+=digitFactorial;
            copy/=10;
        }
        if(result==number){
            return true;
        }
        return false;
    }

    public void pattern1(int number){
        for(int i=0; i<number; i++){
            for(int j=0; j<i+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void pattern2(int number){
        for(int i=0; i<number; i++){
            for(int j=0; j<i+1; j++){
                System.out.print(j+1);
            }
            System.out.println();
        }
    }

    public void pattern3(int number, int increment){
        for(int i=1; i<number+1; i++){
            int lastNum = -1;
            for(int j=1; j<i+1; j++){
                if(j==1){
                    System.out.print(j);
                    lastNum = j;
                }
                else{
                    System.out.print(lastNum+increment);
                    lastNum+=increment;
                }
            }
            System.out.println();
        }
    }

    public void pattern4(int num){
        int gap = num;
        for(int i=0; i<num; i++){
            for(int k=0; k<gap; k++){
                System.out.print(" ");
            }
            for(int j=0; j<i+1; j++){
                System.out.print("*");
            }
            gap--;
            System.out.println();
        }
    }

    public void pattern5(int num){
        int gap = num;
        int patternNum = 0;
        for(int i=0; i<num; i++){
            for(int k=0; k<gap; k++){
                System.out.print(" ");
            }
            for(int j=0; j<i+1; j++){
                System.out.print(i+patternNum);
            }
            gap--;
            System.out.println();
        }
    }

    public void pattern6(int num){
        int gap = num;
        for(int i=0; i<num; i++){
            int patternNum = i;
            for(int k=0; k<gap; k++){
                System.out.print(" ");
            }
            for(int j=0; j<i+1; j++){
                System.out.print(patternNum+1);
                patternNum--;
            }
            for(int k=0; k<i+1; k++){
                System.out.print(k+1);
            }
            gap--;
            System.out.println();
        }
    }

    public void pattern7(int num){
        int decreaseLines = num;
        for(int i=0; i<(num*2)-1; i++){
            if(i<num){
                for(int j=0; j<i+1; j++){
                    System.out.print(j+1);
                }
                System.out.println();
            }
            else{
                for(int j=1; j<decreaseLines; j++){
                    System.out.print(j);
                }
                decreaseLines--;
                System.out.println();
            }
            
        }
        
    }

    public void pattern8(int num, int increment){
    	int gap = num*3;
    	int lastNumLeft = 1;
    	int lastNumRight= 1;
    	for(int i=0; i<(num*2)-1; i++) {
       		if(i<num) {
    			if(lastNumLeft>=10) {
        			gap--;
        		}
        		for(int j=0; j<gap; j++) {
        			System.out.print(" ");
        		}
        		for(int k=lastNumLeft; k>=1; k-=increment) {
        			System.out.print(k);
        		}
        		for(int k=1; k<=lastNumRight; k+=increment) {
        			System.out.print(k);
        		}
        		System.out.println();
        		if(i==num-1) {
        			continue;
        		}
        		lastNumLeft+=increment;
        		lastNumRight+=increment;
        		gap--;
    		}
       		else {
       			if(i==num) {
       				if(lastNumLeft>=10) {
       					gap+=2;
       				}
       				else {
       					gap++;
       				}
       				lastNumLeft-=increment;
       				lastNumRight-=increment;
       			}
       			if(i!=num && lastNumLeft+increment>=10) {
       				gap++;
       			}
       			for(int j=0; j<gap; j++) {
        			System.out.print(" ");
        		}
        		for(int k=lastNumLeft; k>=1; k-=increment) {
        			System.out.print(k);
        		}
        		for(int k=1; k<=lastNumRight; k+=increment) {
        			System.out.print(k);
        		}
        		System.out.println();
        		lastNumLeft-=increment;
        		lastNumRight-=increment;
        		gap++;
       		}
    	}
    }


}
