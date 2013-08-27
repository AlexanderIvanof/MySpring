package com.alex.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alex.spring.beans.SayHello;

public class MySpringTest extends Assert {
	ApplicationContext context;
	
	@Before
	public void initContext(){
		context = new ClassPathXmlApplicationContext("SpringBeans.xml");
	}
	
	@Ignore
	@Test
	public void testContext(){
		assertFalse(context == null);
	}
	
	@Test
	public void testHelloBean(){
		SayHello hello1 = new SayHello();
		hello1.setName("Alexander");
		SayHello hello2 = (SayHello) context.getBean("hello");
		assertEquals(hello1, hello2);
	}
}
