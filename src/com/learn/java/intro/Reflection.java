package com.learn.java.intro;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * <p>This Class uses Reflection API to access and invoke methods, constructors and fields of an object at Runtime.</p>
 */
public class Reflection{

	public static void main(String[] args) {
		getFieldsOfObject();
		getMethodsOfObject();
		getConstructorsOfObject();
		initializeConstructor();
		invokeMethod();
		accessingFields();
	}
	
	/**
	 * <p>
	 * This method prints the fields in the given object, using Reflection API.
	 * Field name, type, access modifiers or printed.
	 * </p>
	 */
	public static void getFieldsOfObject() {
		
		SampleObject object = new SampleObject();
		Class<?> classOfObject = object.getClass();
		Field[] fields = classOfObject.getDeclaredFields();
		for(Field field : fields) {
			System.out.println("Field Name: "+field.getName()+"; Type: "+field.getType().getName()+"; Access Modifiers: "+Modifier.toString(field.getModifiers()));
		}
		
	}
	
	/**
	 * <p>
	 * This method prints the methods in the given object, using Reflection API.
	 * Prints the methods which are only defined in this class and not the methods in parent class.
	 * Method name, return types, access modifiers are printed.
	 * </p>
	 */
	public static void getMethodsOfObject() {
		
		SampleObject object = new SampleObject();
		Class<?> classOfObject = object.getClass();
		Method[] methods = classOfObject.getDeclaredMethods();
		for(Method method : methods) {
			System.out.println("Method Name: "+method.getName()+"; Access Modifiers: "+Modifier.toString(method.getModifiers())+"; Return type: "+method.getReturnType().getName());
			System.out.println("Parameters: ");
			for(Parameter parameter : method.getParameters()) {
				System.out.println("Parameter Name: "+parameter.getName()+"; Type: "+parameter.getType());
			}
		}
	}
	
	/**
	 * <p>
	 * This method prints the constructors in the given object, using Reflection API.
	 * Prints the constructors which are only defined in this class and not the constructors in parent class.
	 * Constructor name, access modifiers are printed.
	 * </p>
	 */
	public static void getConstructorsOfObject() {
		
		SampleObject object = new SampleObject();
		Class<?> classOfObject = object.getClass();
		Constructor<?>[] constructors = classOfObject.getConstructors();
		for(Constructor<?> constructor : constructors) {
			System.out.println("Constructor Name: "+constructor.getName()+"; Access Modifiers: "+Modifier.toString(constructor.getModifiers()));
			System.out.println("Parameters: ");
			for(Parameter parameter : constructor.getParameters()) {
				System.out.println("Parameter Name: "+parameter.getName()+"; Type: "+parameter.getType());
			}
		}
	}
	
	/**
	 * <p>
	 * This method gets constructor of a class from the Class Object, and instantiates a new object of that class using constructor object provided by the Reflection API.
	 * It may throw Exceptions, if the given Constructor is not available or the parameters are wrong. 
	 * </p>
	 */
	public static void initializeConstructor() {
		
		try {
			Class<?> classObject = Class.forName("com.learn.java.intro.SampleObject");
			Constructor<?> constructor = classObject.getConstructor(int.class, java.lang.String.class);
			SampleObject object = (SampleObject) constructor.newInstance(10, "Manikandan");
			System.out.println("To ensure object is created, print its string field: "+object.string);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * <p>
	 * This method gets method of the object, and invokes a the method  using Reflection API.
	 * It may throw Exceptions, if the given Method is not available or the parameters are wrong. 
	 * </p>
	 */
	public static void invokeMethod() {
		
		try {
			SampleObject object = new SampleObject();
			Method method = object.getClass().getMethod("display", java.lang.String.class);
			method.invoke(object, "Hello Im Manikandan");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * <p>
	 * This method gets field of the object, and sets a value for it using Reflection API.
	 * It may throw Exceptions, if the given field is not available or the given value is not the type of the field. 
	 * </p>
	 */
	public static void accessingFields() {
		
		try {
			SampleObject object = new SampleObject();
			Field field = object.getClass().getDeclaredField("num");
			field.setAccessible(true);//This makes the field accessible. This prevents encapsulation and not good to use. 
			System.out.println("Field before setting the value: "+field.get(object));
			field.set(object, 100);
			System.out.println("Field after setting the value: "+field.get(object));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

/**
 * <p>A Sample Class used for Reflection and Serialization Classes.</p>
 */
class SampleObject implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int num;
	public volatile String string;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public SampleObject() {
		this.num = 5;
		this.string = "Hello";
	}
	
	public SampleObject(int num, String string) {
		this.num = num;
		this.string = string;
	}
	
	public void display() {
		System.out.println("Hello, this is message.");
	}
	
	public void display(String message) {
		System.out.println(message);
	}
	
}