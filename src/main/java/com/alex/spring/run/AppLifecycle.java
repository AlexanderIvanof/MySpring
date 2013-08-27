package com.alex.spring.run;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.alex.spring.lifecycle.SimpleBean;
import com.alex.spring.lifecycle.SimpleBeanWithAnno;

public class AppLifecycle {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:lifecycle/init-meth.xml");
		context.refresh();
		
		SimpleBean sb1 = getBean("simpleBean1", context);
		SimpleBean sb2 = getBean("simpleBean2", context);
//		SimpleBean sb3 = getBean("simpleBean3", context);
		SimpleBeanWithAnno sb4 = (SimpleBeanWithAnno) context.getBean("simpleBean4");
		System.out.println(sb4);
	}

	private static SimpleBean getBean(String beanName, ApplicationContext ctx) {
		try {
			SimpleBean sb = (SimpleBean) ctx.getBean(beanName);
			System.out.println(sb);
			return sb;
		} catch (BeanCreationException e) {
			System.out.println("Bean config exception " + e.getMessage() + " in " + e.getBeanName());
			return null;
		}
	}

}
