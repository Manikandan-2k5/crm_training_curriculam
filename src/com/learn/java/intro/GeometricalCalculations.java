package com.learn.java.intro;

public class GeometricalCalculations {

    public static void main(String[] args) {
        GeometricalCalculations area = new GeometricalCalculations();
        System.out.println(area.areaOfSquare(4.0));
        System.out.println(area.areaOfRectangle(5.0,4.0));
        System.out.println(area.areaOfCircle(8.0));
        System.out.println(area.perimeterOfSquare(8.0));
        System.out.println(area.perimeterOfRectangle(8.0, 5.0));
        System.out.println(area.circumferenceOfCircle(8.0));
        try {
            System.out.println(area.duration(1000, 2));
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public double areaOfSquare(double side){
        if(side==0 || side==1){
            return side;
        }
        return side*side;
    }

    public double areaOfRectangle(double length, double breadth){
        if(length==0 || breadth==0){
            return 0;
        }
        return length*breadth;
    }

    public double areaOfCircle(double radius){
        if(radius==0){
            return 0;
        }
        double pi = 22.0/7.0;
        return pi*(radius*radius);
    }

    public double perimeterOfSquare(double side){
        if(side==0){
            return 0;
        }
        return 4*side;
    }

    public double perimeterOfRectangle(double length, double breadth){
        return 2*(length+breadth);
    }

    public double circumferenceOfCircle(double radius){
        if(radius==0){
            return 0;
        }
        return 2*(22.0/7)*radius;
    }

    public double duration(double distance, double speed) throws Exception{
        if(distance==0){
            return 0;
        }
        else if(speed==0){
            throw new Exception("Speed can be 0");
        }
        else{
            return distance/speed;
        }
    }

}
