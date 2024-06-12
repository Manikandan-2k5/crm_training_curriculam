package com.learn.java.intro;

public class Interests {

    public static void main(String[] args) {
        Interests interest = new Interests();
        System.out.println(interest.simpleInterest(1000, 0.05, 3));
        System.out.println(interest.compoundInterest(1000, 0.05, 3, (byte)1));
    }
    public double simpleInterest(double principal, double interestRate, double time){
        return principal*time*interestRate;
    }
    public double compoundInterest(double principal, double interestRate, double time, byte noOfTimesCompunded){
        double accumulatedAmount =principal*Math.pow((1+(interestRate/noOfTimesCompunded)), noOfTimesCompunded*time);                                                                                                                                                                                                                                                                                                                                                                       
        return accumulatedAmount-principal;
    }
}
