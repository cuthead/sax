package com.example.sax;

public class Beauty {
	 
	private String name;
	private String age;
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public String getAge() {
		return age;
	}
 
	public void setAge(String age) {
		this.age = age;
	}
 
	@Override
	public String toString() {
		return "beauty info [age=" + age + ", name=" + name + "]";
	}
}
