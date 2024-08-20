package com.learn.java.intro;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

/**
 * <p>
 * This class represents the concepts of Serialization and Deserialization.
 * Serializing an object simply means that it's fields states are being saved in disk.
 * </p>
 */
public class SerializationDeserialization {
	
	public static void main(String[] args) {
		serializeObject();
		deserializeObject();
	}

	/**
	 * <p>
	 * This method serializes an object of a particular state in order to use it in the future or store it in the file format.
	 * This does not save the state of the transient field.
	 * You can deserialize that file to get the object of the saved state.
	 * </p>
	 */
	public static void serializeObject() {
		
		SampleObject object = new SampleObject();//Object is instantiated.
		object.setNum(20);//Changing the state of the object. Saved the num value to 20.
		object.setString("I'm Manikandan");//Changing the state of the object. Saved the string value.
		object.setBool(true);//This does not save the state of the bool to true, as the field is transient.
		
		//To save this state of object and use it in the future, we can serialize it.
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("/home/manikandans/object.data");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(object);
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <p>
	 * This method deserializes the file stream to object of a saved state.
	 * </p>
	 */
	private static void deserializeObject() {
		SampleObject object = null;
		//Deserializing the file to the saved state of an object.
		try {
			FileInputStream fileInputStream = new FileInputStream("/home/manikandans/object.data");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			object = (SampleObject) objectInputStream.readObject();
		} 
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//Reading the saved values of that object
		System.out.println("num value of object: "+object.getNum());
		System.out.println("string value of object: "+object.getString());
		System.out.println("bool value of object: "+object.isBool());//This returns the current state of the bool value, and not the state when the object was serialized, as this field is transient.
	}
	
}