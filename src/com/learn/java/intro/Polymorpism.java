package com.learn.java.intro;

/**
 * <p>This class explains Polymorphism</p>
 */
public class Polymorpism {
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

/**
 * <p>Vehicle Class(Parent)</p>
 * <p>Runtime Polymorphism</p>
 */
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
	}
	
}

/**
 * <p>Bike Class(Child)</p>
 */
class Bike extends Vehicle{
	@Override
	public void noOfWheels() {
		System.out.println("2 Wheels");
	}
}

/**
 * <p>Car Class(Child)</p>
 */
class Car extends Vehicle{
	@Override
	public void noOfWheels() {
		System.out.println("4 Wheels");
	}
}


/**
 * <p>This class explains the pros and cons of Type promotion in method overloading. </p>
 */
class Addition{
	public double add(double a , int b) {
		return a+b;
	}
	public double add(int a, double b) {
		return a+b;
	}
}
