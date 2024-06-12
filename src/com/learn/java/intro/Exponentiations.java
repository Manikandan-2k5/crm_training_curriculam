package com.learn.java.intro;

public class Exponentiations {

    public static void main(String[] args) {
        Exponentiations exponentiations = new Exponentiations();
        System.out.println(exponentiations.square(2));
        System.out.println(exponentiations.cube(2));
    }
    public double square(int number){
        if(number==0 || number==1){
            return number;
        }
        else{
            return Math.pow(number, 2);
        }
    }
    public double cube(int number){
        if(number==0 || number==1){
            return number;
        }
        else{
            return Math.pow(number, 3);
        }
    }
}
