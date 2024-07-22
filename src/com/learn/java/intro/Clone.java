package com.learn.java.intro;
import java.util.ArrayList;

/**
 * <p>This class uses the clone method to represent the cloning of the object, and represents the difference between Deep and Shallow Copy.</p>
 */
public class Clone {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		//Example of clone method.
		//Clone method actually does a shallow copy.
		//Shallow copy is copying the main object, but not the inner objects of that object, i.e this only copies the pointer or references to the inner objects.
		//So, when an inner object is modified in the original object, then the modification will be visible to the copied object.
		Employee employee1 = new Employee("Manikandan", 18);
		Employee shallowCopyEmployee1 = (Employee) employee1.clone();//Cloning the employee1 object, shallow copying.
		Employee colleagueOfEmployee1 = new Employee("Sairam", 26);//Creating a colleague for employee1.
		
		employee1.addColleagues(colleagueOfEmployee1);//Adding colleagues to employee1, which will be reflected in shallowCopyEmployee1.
		
		System.out.println("Employee 1: "+employee1);
		System.out.println("Shallow Copy Employee of Employee1: "+shallowCopyEmployee1);
		
		//Example of Deep Copy
		//Using deepCopyMethod of the Employee which creates a new copy of the object and also creates new copies of the inner objects.
		//This makes sure that modifications in one inner object will not be reflected in the copied object.
		
		Employee deepCopyEmployee1 = (Employee) employee1.deepCopy();
		Employee anotherColleagueOfEmployee1 = new Employee("Prasanna", 26);//Creating a colleague for employee1.
		
		employee1.addColleagues(anotherColleagueOfEmployee1);//Adding colleagues to employee1, which will not be reflected in deepCopyEmployee1.
 		System.out.println("Employee 1: "+employee1);
		System.out.println("Deep Copy Employee of Employee1: "+deepCopyEmployee1);
	}
	
}

/**
 * <p>This is POJO for Employee</p>
 */
class Employee implements Cloneable{
	
	String name;
	int age;
	ArrayList<Employee> colleagues;
	
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
		this.colleagues = new ArrayList<Employee>();
	}
	
	/**
	 * <p>Adds the given employee in the colleagues list.</p>
	 * @param employee colleague
	 */
	public void addColleagues(Employee employee) {
		colleagues.add(employee);
	}
	
	/**
	 * This method clones the current object and returns. Its a shallow copy, i.e only the object and its primitive types are deep copied and all its object fields are copied by their references.
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	
	public String toString() {
		return "Name: "+this.name+" Age: "+this.age+" Colleagues: "+this.colleagues;
	}
	
	/**
	 * <p>This method creates a deep copy of this object. First it clones this object and then, deep copies the colleagues array.</p>
	 * @return returns the deep copied Employee.
	 * @throws CloneNotSupportedException
	 */
	public Object deepCopy() throws CloneNotSupportedException {
		Employee copy = (Employee) this.clone();
		copy.colleagues = new ArrayList<Employee>(this.colleagues);
		return copy;
	}
	
}