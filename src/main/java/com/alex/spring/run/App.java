package com.alex.spring.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alex.spring.beans.City;



public class App {

	private static ApplicationContext context;

	
	/**
	 * @param args
	 * @throws <code>java.leng.Exception</code> - some of <b>row</b> can have an error
 	 */
	public static void main(String[] args) throws Exception {
		 context = new ClassPathXmlApplicationContext("property_init.xml");

		 City city = (City) context.getBean("lviv");
		 System.out.println(city);

	}

}
