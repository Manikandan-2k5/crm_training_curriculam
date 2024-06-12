package com.learn.java.intro;

public class LimitCheck {
    public static void main(String[] args) {
        byte num1 = (byte)128;                  //Cannot convert from int to byte
        short num2 = (short) 32768;             //Cannot convert from int to short
        // int num3 = 2147483648;                  //Literal of type int is out of range
        // long num4 = 9223372036854775808l;       //Literal of type long is out of range
    }
}
