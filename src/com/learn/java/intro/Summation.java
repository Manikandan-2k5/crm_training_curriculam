package com.learn.java.intro;

public class Summation {
    public static void main(String[] args) {
        Summation summation = new Summation();
        System.out.println(summation.sum(15_000, 15_000));
    }

    public int sum(int a, int b){
        return a+b;
    }
}
