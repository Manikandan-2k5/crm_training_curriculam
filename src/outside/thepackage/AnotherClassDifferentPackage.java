package outside.thepackage;

import com.learn.java.intro.AccessModifiers;

public class AnotherClassDifferentPackage extends AccessModifiers{
	public static void main(String[] args) {
		AccessModifiers object = new AccessModifiers();
		System.out.println(object.num1);
//		System.out.println(object.num2); private variable can be accessible only inside its class.
//		System.out.println(object.num3); protected variable can be accessible only when the accessing class is inside the same package or the accessing class is a sub class of that class even though it is in different package
//		System.out.println(object.num4); default variables cannot be accessible in different packages
	}
}