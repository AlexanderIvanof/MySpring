package com.alex.spring.propertyeditor;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ExampleCustPropEditor {
	
	private Name name;

	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:custedit/custom.xml");
		context.refresh();
		
		ExampleCustPropEditor cust = (ExampleCustPropEditor) context.getBean("exampleBean");
		System.out.println(cust.name);
	}

	/**
	 * @return the name
	 */
	public Name getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(Name name) {
		this.name = name;
	}
	
	

}
