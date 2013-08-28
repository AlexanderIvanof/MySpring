package com.alex.spring.nsaop3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class RunAOP {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:aopconf/aop.xml");
		ctx.refresh();
		
		MyBean bean = (MyBean) ctx.getBean("myBean");
		bean.execute();
	}

}
