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
	
	/**
	 * <p>Initialises the Departments</p>
	 */
	private void initializeDepartments() {
		departments = new HashMap<String, Department>();
		departments.put("Science", new Department("Science", 1));
		departments.put("Arts", new Department("Arts", 2));
		departments.put("Commerce", new Department("Commerce", 3));
		departments.put("Technology", new Department("Technology", 4));
		departments.put("Aeronautical", new Department("Aeronautical", 5));
		departments.put("Engineering", new Department("Engineering", 6));
	}
	
	/**
	 * <p>Initialises the Students</p>
	 */
	private void initializeStudents() {
		students = new HashMap<String, Student>();
		students.put("Manikandan", createStudent("Manikandan", 1, "Science", "Data Science", "Artificial Intelligence"));
        students.put("Chenneelavelan", createStudent("Chenneelavelan", 2, "Arts", "Machine Learning", "Design"));
        students.put("Punith", createStudent("Punith", 3, "Commerce", "Machine Learning", "Design"));
        students.put("Gokul", createStudent("Gokul", 4, "Technology", "Data Structures/Algorithms", "Networks"));
        students.put("Surya", createStudent("Surya", 5, "Aeronautical", "Design", "Networks"));
        students.put("Praveenvasan", createStudent("Praveenvasan", 6, "Science", "Data Science", "Networks"));
        students.put("Maheshwar", createStudent("Maheshwar", 7, "Commerce", "Data Structures/Algorithms", "Artificial Intelligence"));
        students.put("Dharun", createStudent("Dharun", 8, "Engineering", "Data Science", "Artificial Intelligence"));
        students.put("Sriram", createStudent("Sriram", 9, "Technology", "Machine Learning", "Artificial Intelligence"));
        students.put("Amos", createStudent("Amos", 10, "Science", "Design", "Data Science"));
	}
	
	/**
	 * <p>Initialises the Courses</p>
	 */
	public void initializeCourses() {
		courses = new HashMap<String, Course>();
		courses.put("Data Science", new Course("Data Science", 1));
		courses.put("Artificial Intelligence", new Course("Artificial Intelligence", 2));
		courses.put("Machine Learning", new Course("Machine Learning", 3));
		courses.put("Design", new Course("Design", 4));
		courses.put("Data Structures/Algorithms", new Course("Data Structures/Algorithms", 5));
		courses.put("Networks", new Course("Networks", 6));
	}
	
	/**
	 * <p>Creates a Student object with the given name, id, department, courses and returns it.</p>
	 * @param name name of the student
	 * @param id id of the student
	 * @param department department of the student
	 * @param coursesStringArray courses of the student
	 * @return returns Student object
	 */
	public Student createStudent(String name, int id, String department, String... coursesStringArray) {
		ArrayList<Course> courseArray = createCourseList(coursesStringArray);
		return new Student(name, id).setDepartment(departments.get(department)).setCourses(courseArray);
	}
	
	/**
	 * <p>Creates and returns the course list with the given courses in the string multiple arguments parameter.</p>
	 * @param coursesStringArray multiple argument variable for list of courses.
	 * @return returns the course list.
	 */
	public ArrayList<Course> createCourseList(String... coursesStringArray){
		ArrayList<Course> courseList = new ArrayList<Course>();
		for(String course : coursesStringArray) {
			courseList.add(courses.get(course));
		}
		return courseList;
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
