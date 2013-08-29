package com.alex.spring.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alex.spring.beans.Performer;

public class AppAutoScan {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("annoscan.xml");
		
		Performer perf = (Performer) ctx.getBean("eric");
		perf.perform();

	}

}
