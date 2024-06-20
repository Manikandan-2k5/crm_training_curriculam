package com.learn.java.intro;


/**
 * <p>This class provides program for metric calculations</p>
 */
public class MetricConversions {

    public static void main(String[] args) {
        MetricConversions metricConversions = new MetricConversions();
        // System.out.println(metricConversions.celsiusToFarenheit(1));
        // System.out.println(metricConversions.distanceToString(123457));
        // System.out.println(metricConversions.calculateElectricityCharge(3000));
    }
    
    
    /**
     * <p>Returns the metre unit value of given number in centimetre unit</p>
     * @param num number in centimetre unit
     * @return returns the metre value of the give number in centimetre unit 
     */
    public double centimetresToMetres(double num){
        return num==0 ? 0 : num/100;
    }

    /**
     * <p>Returns the centimetre unit value of given number in metre unit</p>
     * @param num number in metre unit
     * @return returns the centimetre value of the give number in metre unit 
     */
    public double metresToCentimeters(double num){
        return num==0 ? 0 : num*100;
    }

    
    /**
     * <p>Returns the kilometre unit value of given number in metre unit</p>
     * @param num number in metre unit
     * @return returns the kilometre value of the give number in metre unit 
     */
    public double metresToKilometres(double num){
        return num==0 ? 0 : num/1000;
    }

    /**
     * <p>Returns the metre unit value of given number in kilometre unit</p>
     * @param num number in kilometre unit
     * @return returns the metre value of the give number in kilometre unit 
     */
    public double kilometresToMetres(double num){
        return num==0 ? 0 : num*1000;
    }

    /**
     * <p>Returns the Inch unit value of given number in Feet unit</p>
     * @param num number in Inch unit
     * @return returns the Inch unit value of the give number in Feet unit 
     */
    public double inchesToFeet(double num){
        return num==0 ? 0 : num/12;
    }

    /**
     * <p>Returns the Feet unit value of given number in Inch unit</p>
     * @param num number in Feet unit
     * @return returns the Feet unit value of the give number in Inch unit 
     */
    public double feetToInches(double num){
        return num==0 ? 0 : num*12;
    }

    
    /**
     * <p>Returns the square unit value of the given cent unit value</p>
     * @param num cent unit value
     * @return returns the square unit value of the given cent unit value.
     */
    public double centToSquareFeet(double num){
        return num==0 ? 0 : num/0.002296169;
    }

    /**
     * <p>Returns the cent unit value of the given square unit value</p>
     * @param num square unit value
     * @return returns the cent unit value of the given square unit value.
     */
    public double squareFeetToCent(double num){
        return num==0 ? 0 : num*0.002296169;
    }


    /**
     * <p>Returns the kilograms unit value of the given grams unit value</p>
     * @param num grams unit value
     * @return returns the kilograms unit value of the given grams unit value.
     */
    public double gramsToKilograms(double num){
        return num==0 ? 0 : num/1000;
    }

    /**
     * <p>Returns the grams unit value of the given kilograms unit value</p>
     * @param num kilograms unit value
     * @return returns the grams unit value of the given kilograms unit value.
     */
    public double kilogramsToGrams(double num){
        return num==0 ? 0 : num*1000;
    }

    /**
     * <p>Returns dollar value of the given rupees value</p>
     * @param num rupee value
     * @return returns the dollar value of the given rupee value
     */
    public double rupeesToDollars(double num){
        return num==0 ? 0 : num/83.18;
    }

    /**
     * <p>Returns rupee value of the given dollars value</p>
     * @param num dollars value
     * @return returns the rupee value of the given dollars value
     */
    public double dollarsToRupees(double num){
        return num==0 ? 0 : num*83.18;
    }

    /**
     * <p>Returns celsius value of the given farenheit value</p>
     * @param num farenheit value
     * @return returns the celsius value of the given farenheit value
     */
    public double farenheitToCelsius(double num){
        return (num-32)*(5/9);
    }

    /**
     * <p>Returns farenheit value of the given celsius value</p>
     * @param num celsius value
     * @return returns the farenheit value of the given celsius value
     */
    public double celsiusToFarenheit(double num){
        return num==0 ? 32 : (num*9/5)+32;
    }

    /**
     * <p>Returns the String representation of the given distance</p>
     * @param distance to be converted to String
     * @return returns the String representation of the given distance.
     */
    public String distanceToString(long distance){
        int metre = 100;
        int kiloMetre = 100000;
        double feet = 30.48;
        String distanceString = "";
        if(distance>=kiloMetre){
            int kms = (int)(distance/kiloMetre);
            distanceString+=(kms+"Km ");
            distance = distance-(kms*kiloMetre);
            int ms = (int)(distance/metre);
            distanceString+=(ms+"m ");
            distance = distance-(ms*metre);
            int feets = (int)(distance/feet);
            distanceString+=(feets+"feet ");
            distance = (long)((int)distance-(feets*feet));
            int cms = (int)distance;
            distanceString+=(cms+"cm");
        }
        else if(distance>=metre){
            int ms = (int)(distance/metre);
            distanceString+=(ms+"m ");
            distance = distance-(ms*metre);
            int feets = (int)(distance/feet);
            distanceString+=(feets+"feet ");
            distance = (long)((int)distance-(feets*feet));
            int cms = (int)distance;
            distanceString+=(cms+"cm");
        }
        else if(distance>=feet){
            int feets = (int)(distance/feet);
            distanceString+=(feets+"feet ");
            distance = (long)((int)distance-(feets*feet));
            int cms = (int)distance;
            distanceString+=(cms+"cm");
        }
        else{
            distanceString+=(distance+"cm");
        }
        return distanceString;
    }

    
    /**
     * <p>Returns the Charge for the given electric units</p>
     * @param units electric units
     * @return returns the charge for the given electric units
     */
    public double calculateElectricityCharge(int units){
        double charge = 0;
        float firstUnitExceedCharge = 2.50f;
        float secondUnitExceedCharge = 3.0f;
        float thirdUnitExceedCharge = 5.0f;
        float fourthUnitExceedCharge = 7.0f;
        short firstUnitRange = 100;
        short secondUnitRange = 200;
        short thirdUnitRange = 200;
        short fourthUnitRange = 500;
        if(units<=100){
            charge = 0;
        }
        else{
            if(units>100 && units<=300){
               charge += (units-firstUnitRange)*firstUnitExceedCharge;
            }
            else if(units>300 && units<=500){
                charge += secondUnitRange*firstUnitExceedCharge;
                charge += (units-secondUnitRange-firstUnitRange)*secondUnitExceedCharge;
            }
            else if(units>500 && units<=1000){
                charge += secondUnitRange*firstUnitExceedCharge;
                charge += thirdUnitRange*secondUnitExceedCharge;
                charge += (units-thirdUnitRange-secondUnitRange-firstUnitRange)*thirdUnitExceedCharge;
            }
            else{
                charge += secondUnitRange*firstUnitExceedCharge;
                charge += thirdUnitRange*secondUnitExceedCharge;
                charge += fourthUnitRange*thirdUnitExceedCharge;
                charge += (units-fourthUnitRange-thirdUnitRange-secondUnitRange-firstUnitRange)*fourthUnitExceedCharge;
            }
        }
        return charge;
    }

}
