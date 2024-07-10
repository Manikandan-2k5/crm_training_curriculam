//$Id$
package com.learn.java.intro;

import org.json.JSONObject;

/**
 * <p>POJO for Department details</p>
 */
public class Department {

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
		JSONObject departmentJson = new JSONObject();
		departmentJson.put("name", name);
		departmentJson.put("id", id);
		return departmentJson;
	}
	
}
