package com.learn.java.intro;

public class Arithmetic {

    public static void main(String[] args) {
        Arithmetic arithmetic = new Arithmetic();
        // arithmetic.printProblemResults();
        // arithmetic.oddOrEven(4);
        // try {
        //     System.out.println(arithmetic.factorial(0));
        // } 
        // catch (Exception e) {
        //     e.printStackTrace();
        // }
        // try {
        //     System.out.println(arithmetic.sumOfNNumbers(2));
        // } 
        // catch (Exception e) {
        //     e.printStackTrace();
        // }
        // arithmetic.multiplicationTables(11, 20);
        // System.out.println("Is Prime: "+arithmetic.isPrime(2));
        // arithmetic.bigAndSmallValuesInList(new int[]{1,2,1,3});
        // arithmetic.totalAndAverageOfRange(-5, -5);
        // arithmetic.totalAndAverageOfOddAndEven(5, 10);
        // arithmetic.primeNumbersBetween1To100();
        // System.out.println("Is Palindrome: "+arithmetic.isPalindrome(-10101));
        // arithmetic.oddOrEven(0);
        // try {
        //     arithmetic.factorial(-5);
        // } 
        // catch (Exception e) {
        //     e.printStackTrace();
        // }
    }

    public int product(int a, int b, int c){
        if(a==0 || b==0 || c==0){
            return 0;
        }
        return a*b*c;
    }

    public int difference(int a, int b){
        return a-b;
    }

    public void swap(int a, int b){
        if(a==b){
            System.out.println("Before Swap: "+a+" "+b);
            System.out.println("After Swap: "+a+" "+b);
        }
        else{
            System.out.println("Before Swap: "+a+" "+b);
            a = a+b;
            b = a-b;
            a = a-b;
            System.out.println("After Swap: "+a+" "+b);
        }
    }

    public int divide(int a, int b) throws Exception{
        if(a==0){
            return 0;
        }
        else if(b==0){
            throw new Exception("Anything divided by 0 is undefined.");
        }
        else{
            return a/b;
        }
    }

    public void oddOrEven(int num){
        String type = num%2==0 ? "Even": "Odd";
        System.out.println(type);
    }

    public void printProblemResults(){
        byte a = -5;
        byte b = 8;
        byte c = 6;
        byte d = 55;
        byte e = 9;
        byte f = 20;
        byte g = -3;
        byte h = 5;
        byte i = 15;
        byte j = 3;
        byte k = 2;
        int result =  a+b*c;
        System.out.println(result);
        result = (d+e) % e;
        System.out.println(result);
        result = f + g*h / b;
        System.out.println(result);
        result =  h + i / ((j * k) - b) % j;
        System.out.println(result);
    }

    public int sumOfNNumbers(int n) throws Exception{
        if(n<=0){
            throw new Exception("Only Natural Numbers are accepted in calculating sum of N Natural Numbers");
        }
        return (n*(n+1))/2;
    }

    public int factorial(int number) throws Exception{
        if(number<0){
            throw new Exception("Factorial function is not defined for negative Numbers");
        }
        else{
            int result = 1;
            while(number>1){
                result*=number;
                number-=1;
            }
            return result;
        }
    }

    public void multiplicationTables(int number, int range){
        for(int i=1; i<range+1; i++){
            System.out.println(number+" * "+i+" = "+number*i);
        }
    }

    public boolean isPrime(int number){
        if(number<=1){
            return false;
        }
        else{
            int factorRange = number/2;
            for(int i = 2; i<factorRange+1; i++){
                if(number%i==0){
                    return false;
                }
            }
            return true;
        }
    }

    public void bigAndSmallValuesInList(int[] array){
        if(array.length==0){
            System.out.println("Array is Empty");
        }
        else if(array.length==1){
            System.out.println("Big Value: "+array[0]);
            System.out.println("Small Value: "+array[0]);
        }
        else{
            int small = array[0];
            int big = array[0];
            for(int i: array){
                if(i>big){
                    big = i;
                }
                else if(i<small){
                    small = i;
                }
                else{
                    continue;
                }
            }
            System.out.println("Big Value: "+big);
            System.out.println("Small Value: "+small);
        }
    }

    public void oddNumbersInGivenRange(int start, int end){
        if(start < end){
            for(int i = start; i <= end; i++){
                if(i%2!=0){
                    System.out.println(i);
                }
            }
        }
        else if(start > end){
            for(int i = start; i >= end; i--){
                if(i%2!=0){
                    System.out.println(i);
                }
            }
        }
        else if(start==end && start%2!=0){
            System.out.println(start);
        }

        else{
            System.out.println("No Odd Numbers in the given Range.");
        }
    }

    public void totalAndAverageOfRange(int start, int end){
        if(start==end){
            System.out.println("Average: "+start);
            System.out.println("Total: "+start);
        }
        else{
            int average = 0;
            int total = 0;
            for(int i = start; i < end+1; i++){
                total+=i;
            }
            average = total/((end-start)+1);
            System.out.println("Average: "+average);
            System.out.println("Total: "+total);
        }
    }

    public void totalAndAverageOfOddAndEven(int start, int end){
        if(start==end && start%2==0){
            System.out.println("Even Average: "+start+", Even Total: "+start);
            System.out.println("Odd Average: "+0+", Odd Total: "+0);
        }
        else if(start==end && start%2!=0){
            System.out.println("Even Average: "+0+", Even Total: "+0);
            System.out.println("Odd Average: "+start+", Odd Total: "+start);
        }
        else{
            int evenAverage = 0;
            int evenTotal = 0;
            int evenCount = 0;
            int oddAverage = 0;
            int oddTotal = 0;
            int oddCount = 0;
            for(int i = start; i < end+1; i++){
                if(i%2==0){
                    evenTotal+=i;
                    evenCount++;
                }
                else{
                    oddTotal+=i;
                    oddCount++;
                }
            }
            evenAverage = evenTotal/evenCount;
            oddAverage = oddTotal/oddCount;
            System.out.println("Even Average: "+evenAverage+", Even Total: "+evenTotal);
            System.out.println("Odd Average: "+oddAverage+", Odd Total: "+oddTotal);
        }
    }

    public void primeNumbersBetween1To100(){
        for(int i = 2; i<100+1; i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }
    }

    public boolean isPalindrome(int number){
        if(number<0){
            System.out.println("Palindromes are not applicable for negative numbers");
            return false;
        }
        else if(number%10==number){
            return true;
        }
        else{
            int copy = number;
            int reverse = 0;
            int length = (int)Math.pow(10, String.valueOf(copy).length()-1);
            while(copy>0){
                int remainder = copy%10;
                reverse+=remainder*length;
                length/=10;
                copy/=10;
            }
            if(number==reverse){
                return true;
            }
            return false;
        }
    }
}
