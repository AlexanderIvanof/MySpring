package com.alex.spring.run;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.alex.spring.methodreplacer.TargetBean;

public class AppReplace {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:replace.xml");
		context.refresh();
		
		// without replace
		TargetBean without = (TargetBean) context.getBean("target");
		
		// with replace
		TargetBean with = (TargetBean) context.getBean("replacement");
		
		System.out.println(without.formatMessage("Hello"));
		
		System.out.println(with.formatMessage("NotHello"));
	}

}
