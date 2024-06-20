package com.learn.java.intro;

/**
 * <p>Gives implementation for the Exponentiation operation</p>
 */
public class Exponentiations {

    public static void main(String[] args) {
        Exponentiations exponentiations = new Exponentiations();
        System.out.println(exponentiations.square(2));
        System.out.println(exponentiations.cube(2));
    }
    
    /**
     * <p>Gives the square of the given number</p>
     * @param number number to be squared
     * @return return the square of the number
     */
    public double square(int number){
        if(number==0 || number==1){
            return number;
        }
        else{
            return Math.pow(number, 2);
        }
    }
    
    /**
     * <p>Gives the cube of the given number</p>
     * @param number number to be cubed
     * @return returns the cube of the number
     */
    public double cube(int number){
        if(number==0 || number==1){
            return number;
        }
        else{
            return Math.pow(number, 3);
        }
    }
}
