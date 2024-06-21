package com.learn.java.intro;
import java.util.Arrays;
import java.util.Comparator;

public class Comparators {
	public static void main(String[] args) {
		Person[] people = new Person[10];

        for (int i = 0; i < people.length; i++) {
            people[i] = new Person();
            people[i].setAadharAvailable(i % 2 == 0);
            people[i].setName("Person" + (char)(int)(((Math.random())*10)+65));
            people[i].setAge((byte)((Math.random()*10)+20-1));
            people[i].setCity("City" + (char)(int)(((Math.random())*10)+65));
            people[i].setCountry("Country" + i);
            people[i].setDob("01/01/200" + i);
            people[i].setDoorNumber("Door" + i);
            people[i].setGender(i % 2 == 0 ? "Male" : "Female");
            people[i].setLocality("Locality" + i);
            people[i].setMaritalStatus(i % 2 == 0 ? "Unmarried" : "Married");
            people[i].setMonthSalary(10000 + (i * 1000));
            people[i].setMonthlyExpense(8000 + (i * 800));
            people[i].setPhoneNumber(8610045338L + i);
            people[i].setPinCode(603100 + i);
            people[i].setQualification("Qualification" + i);
            people[i].setSalaried(i % 2 == 0);
            people[i].setTelephoneAvailable(i % 2 != 0);
            people[i].setStreet("Street" + i);
            people[i].setHobbies(new String[]{"Hobby1", "Hobby2", "Hobby3"});
        }
        
        System.out.println("Unsorted Array");
        
        for(Person person : people) {
        	System.out.println(person);
        }
        System.out.println();
        System.out.println("Sorted Array based on Person Name");
        Arrays.sort(people, Comparator.comparing(Person::getName)); //Usage of Comparator.comparing which returns a comparator to Arrays and sort it according to Person Name.
        Arrays.sort(people, Comparator.comparing(person -> person.getName())); //Usage of lambda expressions	
        for(Person person : people) {
        	System.out.println(person);
        }
        System.out.println();
        System.out.println("Sorted Array based on Person city");
        Comparator<Person> cityComparator = (person1, person2) -> person1.getCity().compareTo(person2.getCity());//Anonymous Implementation for Comparator.
        Arrays.sort(people, cityComparator);
        for(Person person : people) {
        	System.out.println(person);
        }
        
        System.out.println();
        System.out.println("Sorted Array based on Age, Name, City");
        //Multiple Level of Comparator.
        Comparator<Person> chainComparator = Comparator.comparing((Person person) -> person.getAge(), new AgeComparator())
        											   .thenComparing(Comparator.comparing((Person person) -> person.getName()))
        											   .thenComparing(Comparator.comparing((Person person) -> person.getCity()));
        												
        Arrays.sort(people, chainComparator);
        for(Person person : people) {
        	System.out.println(person);
        }
	}
}



/**
 * <p>Comparator Implementation for Age Comparison</p>
 */
class AgeComparator implements Comparator<Integer>{
	
	public int compare(Integer o1, Integer o2) {
		return o1.compareTo(o2);
	}
}