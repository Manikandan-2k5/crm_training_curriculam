//$Id$
package com.learn.java.intro;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * <p>POJO for Student details</p>
 */
public class Student {
	
	private String name;
	private int id;
	Department department;
	ArrayList<Course> courses = new ArrayList<Course>();
	
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
		
	public ArrayList<Course> getCourses() {
		return courses;
	}

	public Student setCourses(ArrayList<Course> courses) {
		this.courses = courses;
		return this;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public Student setDepartment(Department department) {
		this.department = department;
		return this;
	}
	
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	/**
	 * <p>Formats and returns JSON representation of this.</p>
	 * @return JSON object of this.
	 */
	public JSONObject toJson() {
		JSONObject studentJson = new JSONObject();
		studentJson.put("name", name);
		studentJson.put("id", id);
		studentJson.put("department", department.toJson());
		JSONArray coursesArray = new JSONArray();
		for(Course course : courses) {
			coursesArray.put(course.toJson());
		}
		studentJson.put("courses", coursesArray);
		return studentJson;
	}

	
}
