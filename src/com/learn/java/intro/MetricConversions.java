package com.learn.java.intro;

public class MetricConversions {

    public static void main(String[] args) {
        MetricConversions metricConversions = new MetricConversions();
        // System.out.println(metricConversions.celsiusToFarenheit(1));
        // System.out.println(metricConversions.distanceToString(123457));
        // System.out.println(metricConversions.calculateElectricityCharge(3000));
    }
    
    public double centimetresToMetres(double num){
        return num==0 ? 0 : num/100;
    }

    public double metresToCentimeters(double num){
        return num==0 ? 0 : num*100;
    }

    public double metresToKilometres(double num){
        return num==0 ? 0 : num/1000;
    }

    public double kilometresToMetres(double num){
        return num==0 ? 0 : num*1000;
    }

    public double inchesToFeet(double num){
        return num==0 ? 0 : num/12;
    }

    public double feetToInches(double num){
        return num==0 ? 0 : num*12;
    }

    public double centToSquareFeet(double num){
        return num==0 ? 0 : num/0.002296169;
    }

    public double squareFeetToCent(double num){
        return num==0 ? 0 : num*0.002296169;
    }


    public double gramsToKilograms(double num){
        return num==0 ? 0 : num/1000;
    }

    public double kilogramsToGrams(double num){
        return num==0 ? 0 : num*1000;
    }

    public double rupeesToDollars(double num){
        return num==0 ? 0 : num/83.18;
    }

    public double dollarsToRupees(double num){
        return num==0 ? 0 : num*83.18;
    }

    public double farenheitToCelsius(double num){
        return (num-32)*(5/9);
    }

    public double celsiusToFarenheit(double num){
        return num==0 ? 32 : (num*9/5)+32;
    }

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
