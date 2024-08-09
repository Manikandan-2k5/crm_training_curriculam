package com.learn.java.intro;


/**
 * <p>This class implements all the methods of Object class.
 * notify(), notifyAll(), wait() methods are implemented in ManualLockImpl class and clone() method is implemented in Clone class.
 * </p>
 */
public class ObjectImpl {
	
	public static void main(String[] args) {
		ObjectSample sampleObject1 = new ObjectSample();
		ObjectSample sampleObject2 = new ObjectSample();
		System.out.println("Printing object1: "+sampleObject1);//This will call toString method internally.
		System.out.println("Printing object2: "+sampleObject2);//This will call toString method internally.
		System.out.println("Hashcode of object1: "+sampleObject1.hashCode());
		System.out.println("Hashcode of object2: "+sampleObject2.hashCode());
		System.out.println("Checking equality between object1 and object2: "+sampleObject1.equals(sampleObject2));
		System.gc();//To check if finalize method is being called.
	}
	
}

class ObjectSample{
	
	String nameOfObject;
	
	public ObjectSample() {
		this.nameOfObject = "sampleObject"+Math.random()*1000000000;
	}
	
	public ObjectSample(String name) {
		this.nameOfObject = name;
	}
	
	/**
	 * <p>
	 * This method returns the string representation of the object. By default it returns className+@+hashCode. 
	 * When you print the object, internally toString method is called and the string value is printed.
	 * </p>
	 */
	@Override
	public String toString() {
		return nameOfObject;
	}
	
	/**
	 * <p>This method returns a hexadecimal value, which is generated according to the memory address of the object by native code.</p>
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	/**
	 * <p>
	 * This method by default returns true, if the this object's reference and given object's reference points to same memory address, else returns false.
	 * You can override this method to check the equality of the object by its value and not by its reference pointer.
	 * In this method we are checking the equality in terms of their name.
	 * </p>
	 */
	@Override
	public boolean equals(Object obj) {
		if(this.nameOfObject==((ObjectSample)obj).nameOfObject) {
			return true;
		}
		return false;
	}
	
	/**
	 * <p>
	 * This method is called when the object is being garbage collected.
	 * Its deprecated.
	 * </p>
	 */
	@Override
	protected void finalize() throws Throwable {
		System.out.println("In finalize method.");
		super.finalize();
	}
}