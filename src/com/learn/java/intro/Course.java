//$Id$
package com.learn.java.intro;


import org.json.JSONObject;

/**
 * <p>POJO for Course details</p>
 */
public class Course {
	
	String name;
	private int id;
	
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
	
	
	/**
	 * <p>Formats and returns JSON representation of this.</p>
	 * @return JSON object of this.
	 */
	public JSONObject toJson() {
		JSONObject courseJson = new JSONObject();
		courseJson.put("name", name);
		courseJson.put("id", id);
		return courseJson;
	}
	
}
