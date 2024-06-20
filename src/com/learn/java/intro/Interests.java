package com.learn.java.intro;


/**
 * <p>Class for Calculating Interests</p>
 */
public class Interests {

    public static void main(String[] args) {
        Interests interest = new Interests();
        System.out.println(interest.simpleInterest(1000, 0.05, 3));
        System.out.println(interest.compoundInterest(1000, 0.05, 3, (byte)1));
    }
    
    /**
     * <p>Calculates simple interest for the given principal, interest rate, duration</p>
     * @param principal Principal Amount
     * @param interestRate Interest Rate
     * @param time Duration
     * @return returns the Simple Interest
     */
    public double simpleInterest(double principal, double interestRate, double time){
        return principal*time*interestRate;
    }
    
    /**
     * <p>Returns the Compounded Interest for the given principal amount, interest rate, duration, number of times compounded.</p>
     * @param principal Principal Amount
     * @param interestRate Interest Rate
     * @param time Duration
     * @param noOfTimesCompunded Number of times Compounded
     * @return returns the compounded interest
     */
    public double compoundInterest(double principal, double interestRate, double time, byte noOfTimesCompunded){
        double accumulatedAmount =principal*Math.pow((1+(interestRate/noOfTimesCompunded)), noOfTimesCompunded*time);                                                                                                                                                                                                                                                                                                                                                                       
        return accumulatedAmount-principal;
    }
}
