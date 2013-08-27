package com.alex.spring.lifecycle;

public class SimpleBean {

	public final static String DEFAULT_NAME = "Bart Simpson";
	
	private String name;
	private int age = -1;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	public void init(){
		System.out.println("Initializing bean");
		if(name == null){
			name = DEFAULT_NAME;
		}
		
		if(age == -1){
			throw new IllegalArgumentException("Property must be seting" + SimpleBean.class);
		}
	}

	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SimpleBean [name=" + name + ",\n age=" + age + "]";
	}
	
	
}
