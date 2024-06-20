package com.learn.java.intro;

/**
 * <p>This class provides programs for some geometric calculations</p>
 */
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
    
    
    /**
     * <p>Returns the area of the square</p>
     * @param side side of the  square
     * @return returns the area of the square
     */
    public double areaOfSquare(double side){
        if(side==0 || side==1){
            return side;
        }
        return side*side;
    }

    /**
     * <p>Returns the area of the rectangle</p>
     * @param length length of the rectangle
     * @param breadth breadth of the rectangle
     * @return returns the area of the rectangle
     */
    public double areaOfRectangle(double length, double breadth){
        if(length==0 || breadth==0){
            return 0;
        }
        return length*breadth;
    }

    /**
     * <p>Return the area of the circle</p>
     * @param radius radius of the circle
     * @return returns the area of the circle
     */
    public double areaOfCircle(double radius){
        if(radius==0){
            return 0;
        }
        double pi = 22.0/7.0;
        return pi*(radius*radius);
    }

    
    /**
     * <p>Returns the perimeter of the square</p>
     * @param side side of the square
     * @return returns the perimeter of the square 
     */
    public double perimeterOfSquare(double side){
        if(side==0){
            return 0;
        }
        return 4*side;
    }

    /**
     * <p>Returns the perimeter of the rectangle </p>
     * @param length length of the rectangle 
     * @param breadth breadth of the rectangle
     * @return returns the area of the rectangle
     */
    public double perimeterOfRectangle(double length, double breadth){
        return 2*(length+breadth);
    }

    /**
     * <p>Returns the circumference of the circle</p>
     * @param radius radius of the circle
     * @return returns the circumference of the circle
     */
    public double circumferenceOfCircle(double radius){
        if(radius==0){
            return 0;
        }
        return 2*(22.0/7)*radius;
    }

    /**
     * <p>Returns the duration of to cover a given distance with a given speed</p>
     * @param distance distance to be covered
     * @param speed speed to cover the distance
     * @return returns the duration to cover the given distance with the given speed.
     * @throws Exception
     */
    public double duration(double distance, double speed) throws Exception{
        if(distance==0){
            return 0;
        }
        else if(speed==0){
            throw new Exception("Speed can't be 0");
        }
        else{
            return distance/speed;
        }
    }

}
