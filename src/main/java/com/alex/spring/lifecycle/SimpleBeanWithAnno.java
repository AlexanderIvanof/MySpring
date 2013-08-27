package com.alex.spring.lifecycle;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;

/*
 * This bean is designed to display initializing properties.
 * output is
 * Initializing bean @PostConstruct
 * Initializing bean afterPropertiesSet()
 * Initializing bean
 * SimpleBean [name=Bart Simpson,
 * age=13]
 */
public class SimpleBeanWithAnno implements InitializingBean {
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
	 * @param name
	 *            the name to set
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
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	public void init() {
		System.out.println("Initializing bean");
		name = DEFAULT_NAME;

		if (age == -1) {
			throw new IllegalArgumentException("Property must be seting"
					+ SimpleBean.class);
		}
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SimpleBean [name=" + name + ",\n age=" + age + "]";
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing bean afterPropertiesSet()");
		name = "AFTER_PROPERTIES_SET";
		if (age == -1) {
			throw new IllegalArgumentException("Property must be seting"
					+ SimpleBean.class);
		}
	}

	/*
	 * If we need to run this method, we must to add <context:annotation-config/>
	 */
	@PostConstruct
	public void postConstruct() {
		System.out.println("Initializing bean @PostConstruct");
		name = "POST_CONSTRUCT";
		if (age == -1) {
			throw new IllegalArgumentException("Property must be seting"
					+ SimpleBean.class);
		}
	}

}
