//$Id$
package com.learn.java.intro;

public class JsonUtilities {
	
	public static void main(String[] args) {
		
		JsonUtilities jsonUtilities = new JsonUtilities();
		
		//Creation of students
		Student student1 = jsonUtilities.createStudent("Manikandan", 1);
		Student student2 = jsonUtilities.createStudent("Chenneelavelan", 2);
		Student student3 = jsonUtilities.createStudent("Punith", 3);
		Student student4 = jsonUtilities.createStudent("Gokul", 4);
		Student student5 = jsonUtilities.createStudent("Surya", 5);
		Student student6 = jsonUtilities.createStudent("Praveenvasan", 6);
		Student student7 = jsonUtilities.createStudent("Maheshwar", 7);
		Student student8 = jsonUtilities.createStudent("Dharun", 8);
		Student student9 = jsonUtilities.createStudent("Sriram", 9);
		Student student10 = jsonUtilities.createStudent("Amos", 10);
		
		//Creation of Departments	
		Department department1 = jsonUtilities.createDepartment("Science", 1);
		Department department2 = jsonUtilities.createDepartment("Arts", 2);
		Department department3 = jsonUtilities.createDepartment("Commerce", 3);
		Department department4 = jsonUtilities.createDepartment("Technology", 4);
		Department department5 = jsonUtilities.createDepartment("Aeronautical", 5);
		Department department6 = jsonUtilities.createDepartment("Engineering", 6);
		

		//Creation of Courses
		Course course1 = jsonUtilities.createCourse("Data Science", 1);
		Course course2 = jsonUtilities.createCourse("Artificial Intelligence", 2);
		Course course3 = jsonUtilities.createCourse("Machine Learning", 3);
		Course course4 = jsonUtilities.createCourse("Design", 4);
		Course course5 = jsonUtilities.createCourse("Data Structures/Algorithms", 5);
		Course course6 = jsonUtilities.createCourse("Networks", 6);
		
		//Setting department for Students
		student1.setDepartment(department1);
		student2.setDepartment(department1);
		student3.setDepartment(department2);
		student4.setDepartment(department1);
		student5.setDepartment(department3);
		student6.setDepartment(department3);
		student7.setDepartment(department2);
		student8.setDepartment(department2);
		student9.setDepartment(department5);
		student10.setDepartment(department6);
		
		//Adding Courses to Students
		Course[] student1Courses = new Course[] {course1, course6};
		Course[] student2Courses = new Course[] {course2, course4};
		Course[] student3Courses = new Course[] {course3, course2};
		Course[] student4Courses = new Course[] {course1, course4};
		Course[] student5Courses = new Course[] {course5, course6};
		Course[] student6Courses = new Course[] {course3, course2};
		Course[] student7Courses = new Course[] {course5, course2};
		Course[] student8Courses = new Course[] {course3, course1};
		Course[] student9Courses = new Course[] {course1, course3};
		Course[] student10Courses = new Course[] {course5, course4};
		
		jsonUtilities.addCoursesToStudents(student1Courses, student1);
		jsonUtilities.addCoursesToStudents(student2Courses, student2);
		jsonUtilities.addCoursesToStudents(student3Courses, student3);
		jsonUtilities.addCoursesToStudents(student4Courses, student4);
		jsonUtilities.addCoursesToStudents(student5Courses, student5);
		jsonUtilities.addCoursesToStudents(student6Courses, student6);
		jsonUtilities.addCoursesToStudents(student7Courses, student7);
		jsonUtilities.addCoursesToStudents(student8Courses, student8);
		jsonUtilities.addCoursesToStudents(student9Courses, student9);
		jsonUtilities.addCoursesToStudents(student10Courses, student10);
		
		//Printing JSON Representations of Students
		System.out.println(student1.toJson());
		System.out.println(student2.toJson());
		System.out.println(student3.toJson());
		System.out.println(student4.toJson());
		System.out.println(student5.toJson());
		System.out.println(student6.toJson());
		System.out.println(student7.toJson());
		System.out.println(student8.toJson());
		System.out.println(student9.toJson());
		System.out.println(student10.toJson());
		
		//Printing JSON Representations of Courses
		System.out.println(course1.toJson());
		System.out.println(course2.toJson());
		System.out.println(course3.toJson());
		System.out.println(course4.toJson());
		System.out.println(course5.toJson());
		System.out.println(course6.toJson());
		
		//Printing JSON Representations of Departments
		System.out.println(department1.toJson());
		System.out.println(department2.toJson());
		System.out.println(department3.toJson());
		System.out.println(department4.toJson());
		System.out.println(department5.toJson());
		System.out.println(department6.toJson());
	}
	
	/**
	 * <p>Creates Student Object with the given name and id.</p>
	 * @param string student name
	 * @param id student id
	 * @return
	 */
	public Student createStudent(String name, int id) {
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		return student;
	}
	
	/**
	 * <p>Creates Course Object with the given name and id.</p>
	 * @param string course name
	 * @param id course id
	 * @return
	 */
	public Course createCourse(String name, int id) {
		Course course = new Course();
		course.setId(id);
		course.setName(name);
		return course;
	}
	
	/**
	 * <p>Creates Department Object with the given name and id.</p>
	 * @param string department name
	 * @param id department id
	 * @return
	 */
	public Department createDepartment(String name, int id) {
		Department department = new Department();
		department.setId(id);
		department.setName(name);
		return department;
	}
	
	/**
	 *<p>Adds courses in the given course array to the given student/p>
	 * @param courses array of courses
	 * @param student student
	 */
	public void addCoursesToStudents(Course[] courses, Student student) {
		for(Course course : courses) {
			student.addCourse(course);
		}
	}
}
