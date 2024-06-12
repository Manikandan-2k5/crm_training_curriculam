package com.learn.java.intro;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.main();
    }

    public int add(int a, int b){
        if(a==0){
            return b;
        }
        else if(b==0){
            return a;
        }
        else if(a==0 && b==0){
            return 0;
        }
        else{
            return a+b;
        }
    }

    public int subtract(int a, int b){
        if(a==0){
            return -b;
        }
        else if(b==0){
            return a;
        }
        else if(a==0 && b==0){
            return 0;
        }
        else{
            return a-b;
        }
    }

    public int multiply(int a, int b){
        if(a==0 || b==0){
            return 0;
        }
        else{
            return a*b;
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

    public int modulo(int a, int b){
        if(a<b){
            return a;
        }
        else{
            return a%b;
        }
    }

    public void main(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Calculator\n");
        char operator;
        while(true){
            System.out.print("Enter your operation: ");
            int operationInput = 0;
            try{
                operationInput = reader.read();
                reader.readLine();
            }
            catch(Exception e){
                System.out.println("Your Operation is not valid!!!\n");
                continue;
            }
            operator = (char)operationInput;
            if((int)operator==43){
                System.out.print("\nEnter First Number: ");
                int operand1;
                try{
                    operand1 = Integer.parseInt(reader.readLine());
                }
                catch(Exception e){
                    System.out.println("Your operand is not valid!!!\n");
                    continue;
                }
                System.out.print("Enter Second Number: ");
                int operand2;
                try{
                    operand2 = Integer.parseInt(reader.readLine());
                    System.out.println();
                }
                catch(Exception e){ 
                    System.out.println("Your operand is not valid!!!\n");
                    continue;
                }
                int result = add(operand1, operand2);
                System.out.println("Addition of "+operand1+" and "+operand2+" is "+result+"\n");
                System.out.print("Wana Continue(y/n): ");
                try {
                    int userContinuationChoice = reader.read();
                    System.out.println();
                    reader.readLine();
                    if(userContinuationChoice!=121 && userContinuationChoice!=89){
                        break;
                    }
                } 
                catch (Exception e) {
                    break;
                }
            }
            else if((int)operator==45){
                System.out.print("\nEnter First Number: ");
                int operand1;
                try{
                    operand1 = Integer.parseInt(reader.readLine());
                }
                catch(Exception e){
                    System.out.println("Your operand is not valid!!!\n");
                    continue;
                }
                System.out.print("Enter Second Number: ");
                int operand2;
                try{
                    operand2 = Integer.parseInt(reader.readLine());
                    System.out.println();
                }
                catch(Exception e){
                    System.out.println("Your operand is not valid!!!\n");
                    continue;
                }
                int result = subtract(operand1, operand2);
                System.out.println("Subtraction of "+operand2+" from "+operand1+" is "+result+"\n");
                System.out.print("Wana Continue(y/n): ");
                try {
                    int userContinuationChoice = reader.read();
                    System.out.println();
                    reader.readLine();
                    if(userContinuationChoice!=121 && userContinuationChoice!=89){
                        break;
                    }
                } 
                catch (Exception e) {
                    break;
                }
            }
            else if((int)operator==42){
                System.out.print("\nEnter First Number: ");
                int operand1;
                try{
                    operand1 = Integer.parseInt(reader.readLine());
                }
                catch(Exception e){
                    System.out.println("Your operand is not valid!!!\n");
                    continue;
                }
                System.out.print("Enter Second Number: ");
                int operand2;
                try{
                    operand2 = Integer.parseInt(reader.readLine());
                    System.out.println();
                }
                catch(Exception e){
                    System.out.println("Your operand is not valid!!!\n");
                    continue;
                }
                int result = multiply(operand1, operand2);
                System.out.println("Multiplication of "+operand1+" and "+operand2+" is "+result+"\n");
                System.out.print("Wana Continue(y/n): ");
                try {
                    int userContinuationChoice = reader.read();
                    System.out.println();
                    reader.readLine();
                    if(userContinuationChoice!=121 && userContinuationChoice!=89){
                        break;
                    }
                } 
                catch (Exception e) {
                    break;
                }
            }
            else if((int)operator==47){
                System.out.print("\nEnter First Number: ");
                int operand1;
                try{
                    operand1 = Integer.parseInt(reader.readLine());
                }
                catch(Exception e){
                    System.out.println("Your operand is not valid!!!\n");
                    continue;
                }
                System.out.print("Enter Second Number: ");
                int operand2;
                try{
                    operand2 = Integer.parseInt(reader.readLine());
                    System.out.println();
                }
                catch(Exception e){
                    System.out.println("Your operand is not valid!!!\n");
                    continue;
                }
                int result = 0;
                try {
                    result = divide(operand1, operand2);
                } 
                catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println();
                    continue;
                }
                System.out.println("Division of "+operand1+" by "+operand2+" is "+result+"\n");
                System.out.print("Wana Continue(y/n): "+"\n");
                try {
                    int userContinuationChoice = reader.read();
                    System.out.println();
                    reader.readLine();
                    if(userContinuationChoice!=121 && userContinuationChoice!=89){
                        break;
                    }
                } 
                catch (Exception e) {
                    break;
                }
            }
            else if((int)operator==37){
                System.out.print("\nEnter First Number: ");
                int operand1;
                try{
                    operand1 = Integer.parseInt(reader.readLine());
                }
                catch(Exception e){
                    System.out.println("Your operand is not valid!!!\n");
                    continue;
                }
                System.out.print("Enter Second Number: ");
                int operand2;
                try{
                    operand2 = Integer.parseInt(reader.readLine());
                    System.out.println();
                }
                catch(Exception e){
                    System.out.println("Your operand is not valid!!!\n");
                    continue;
                }
                int result = modulo(operand1, operand2);
                System.out.println("Remainder when "+operand1+" is divided by "+operand2+" is "+result+"\n");
                System.out.print("Wana Continue(y/n): "+"\n");
                try {
                    int userContinuationChoice = reader.read();
                    System.out.println();
                    reader.readLine();
                    if(userContinuationChoice!=121 && userContinuationChoice!=89){
                        break;
                    }
                } 
                catch (Exception e) {
                    break;
                }
            }
            else{
                System.out.println("Your Operation is not Valid!!!\n");
                continue;
            }
        }
    }

}
