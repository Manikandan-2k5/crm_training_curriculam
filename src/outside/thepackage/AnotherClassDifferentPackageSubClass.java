package outside.thepackage;

import com.learn.java.intro.AccessModifiers;

public class AnotherClassDifferentPackageSubClass extends AccessModifiers{
	public static void main(String[] args) {
		AnotherClassDifferentPackageSubClass object = new AnotherClassDifferentPackageSubClass();
		System.out.println(object.num1);
//		System.out.println(object.num2); private variable can be accessible only inside its class.
		System.out.println(object.num3);
//		System.out.println(object.num4); default variables cannot be accessible in different packages
	}
}
