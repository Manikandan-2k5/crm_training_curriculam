package com.learn.java.intro;

/**
 * 
 */
public class Polymorpism {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//Runtime Polymorphism - Method Overriding
		Vehicle bike = new Bike();
		bike.noOfWheels();
		Vehicle car = new Car();
		car.noOfWheels();
		//Compile time Polymorphism - Method Overloading
		Vehicle vehicle1 = new Vehicle();
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setName("Car");
		vehicle1.setName("Bike");
		vehicle1.setName(vehicle2);
		//Method Overloading and type promotion
		Addition addition = new Addition();
//		addition.add(1, 2); positve cases: type promotes to the nearest large datatype if no method is there with that specific arguement datatype
		//negative cases: it can cause ambiguity to the compiler to invoke what method.
	}
}

class Vehicle{
	String name;
	public void noOfWheels() {
		System.out.println("No of Wheels in Vehicle");
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setName(Vehicle vehicle) {
		this.name = vehicle.name;
		java.util.Arrays.sort(new int[5]);
	}
	
}

class Bike extends Vehicle{
	@Override
	public void noOfWheels() {
		System.out.println("2 Wheels");
	}
}

class Car extends Vehicle{
	@Override
	public void noOfWheels() {
		System.out.println("4 Wheels");
	}
}

class Addition{
	/**
	 *  This method adds 2 given values and returns the sum
	 * @param a first number to sum
	 * @param b second number to sum
	 * @return the sum of a and b
	 */
	public double add(double a , int b) {
		return a+b;
	}
	public double add(int a, double b) {
		return a+b;
	}
}
