package com.learn.java.intro;

/**
 * <p>This class experiments the type castings</p>
 */
public class TypeCasting {
    public static void main(String[] args) {
        byte num1 = 127;
        int num2 = num1; //implicit type conversion
        num1 = (byte)num2; // explicit type casting
        float num3 = num2; //implicit type conversion
        num2 = (int)num3; // explicit type casting
        long num4 = num2; //implicit type conversion
        num2 = (int)num4; //explicit type casting
        double num5 = num3; //implicit type conversion
        num3 = (float)num5; //explicit type casting
        num5 = num2; //implicit type conversion
        num2 = (int)num5; //explicit type casting
        char letter = 'b';
        num2 = letter; //implicit type conversion from char to int
        letter = (char)num2; //explicit type casting from int to char
        // boolean bool = num2; //cannot convert int to boolean in java
        // num2 = bool; //cannot convert boolean to int in java
        String string = letter+""; // char to string
        string = String.valueOf(letter); //char to string
        // letter = string; //cannot cast from string to char  
    }
}
