//$Id$
package com.learn.java.intro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CollegeManagementUtil {
	
	public CollegeManagementUtil() {
		initializeDepartments();
		initializeCourses();
		initializeStudents();
	}
	
	private Map<String,Department> departments;
	private Map<String,Student> students;
	private Map<String, Course> courses;
	
	private void initializeDepartments() {
		departments = new HashMap<String, Department>();
		departments.put("Science", new Department("Science", 1));
		departments.put("Arts", new Department("Arts", 2));
		departments.put("Commerce", new Department("Commerce", 3));
		departments.put("Technology", new Department("Technology", 4));
		departments.put("Aeronautical", new Department("Aeronautical", 5));
		departments.put("Engineering", new Department("Engineering", 6));
	}
	
	private void initializeStudents() {
		students = new HashMap<String, Student>();
		ArrayList<Course> courseArray = new ArrayList<Course>();
		courseArray.add(courses.get("Data Science"));
		courseArray.add(courses.get("Artificial Intelligence"));
		students.put("Manikandan",new Student("Manikandan", 1).setDepartment(departments.get("Science")).setCourses(courseArray));
		courseArray = new ArrayList<Course>();
		courseArray.add(courses.get("Machine Learning"));
		courseArray.add(courses.get("Design"));
		students.put("Chenneelavelan",new Student("Chenneelavelan", 2).setDepartment(departments.get("Arts")).setCourses(courseArray));
		courseArray = new ArrayList<Course>();
		courseArray.add(courses.get("Machine Learning"));
		courseArray.add(courses.get("Design"));
		students.put("Punith",new Student("Punith", 3).setDepartment(departments.get("Commerce")).setCourses(courseArray));
		courseArray = new ArrayList<Course>();
		courseArray.add(courses.get("Data Structures/Algorithms"));
		courseArray.add(courses.get("Networks"));
		students.put("Gokul",new Student("Gokul", 4).setDepartment(departments.get("Technology")).setCourses(courseArray));
		courseArray = new ArrayList<Course>();
		courseArray.add(courses.get("Design"));
		courseArray.add(courses.get("Networks"));
		students.put("Surya",new Student("Surya", 5).setDepartment(departments.get("Aeronautical")).setCourses(courseArray));
		courseArray = new ArrayList<Course>();
		courseArray.add(courses.get("Data Science"));
		courseArray.add(courses.get("Networks"));
		students.put("Praveenvasan",new Student("Praveenvasan", 6).setDepartment(departments.get("Science")).setCourses(courseArray));
		courseArray = new ArrayList<Course>();
		courseArray.add(courses.get("Data Structures/Algorithms"));
		courseArray.add(courses.get("Artificial Intelligence"));
		students.put("Maheshwar",new Student("Maheshwar", 7).setDepartment(departments.get("Commerce")).setCourses(courseArray));
		courseArray = new ArrayList<Course>();
		courseArray.add(courses.get("Data Science"));
		courseArray.add(courses.get("Artificial Intelligence"));
		students.put("Dharun",new Student("Dharun", 8).setDepartment(departments.get("Engineering")).setCourses(courseArray));
		courseArray = new ArrayList<Course>();
		courseArray.add(courses.get("Machine Learning"));
		courseArray.add(courses.get("Artificial Intelligence"));
		students.put("Sriram",new Student("Sriram", 9).setDepartment(departments.get("Technology")).setCourses(courseArray));
		courseArray = new ArrayList<Course>();
		courseArray.add(courses.get("Design"));
		courseArray.add(courses.get("Data Science"));
		students.put("Amos",new Student("Amos", 10).setDepartment(departments.get("Science")).setCourses(courseArray));
	}
	
	public void initializeCourses() {
		courses = new HashMap<String, Course>();
		courses.put("Data Science", new Course("Data Science", 1));
		courses.put("Artificial Intelligence", new Course("Artificial Intelligence", 2));
		courses.put("Machine Learning", new Course("Machine Learning", 3));
		courses.put("Design", new Course("Design", 4));
		courses.put("Data Structures/Algorithms", new Course("Data Structures/Algorithms", 5));
		courses.put("Networks", new Course("Networks", 6));
	}
	
	public static void main(String[] args) {
		
		CollegeManagementUtil collegeManagementUtil = new CollegeManagementUtil();
		
		//Printing JSON Representations of Students
		System.out.println("Students Json\n");
		for(Entry<String, Student> student : collegeManagementUtil.students.entrySet()) {
			System.out.println(student.getValue().toJson());
		}
		System.out.println();
		
		//Printing JSON Representations of Courses
		System.out.println("Courses Json\n");
		for(Entry<String, Course> course : collegeManagementUtil.courses.entrySet()) {
			System.out.println(course.getValue().toJson());
		}
		System.out.println();
		
		//Printing JSON Representations of Departments
		System.out.println("Departments Json\n");
		for(Entry<String, Department> department : collegeManagementUtil.departments.entrySet()) {
			System.out.println(department.getValue().toJson());
		}
		System.out.println();
	}
	
}
