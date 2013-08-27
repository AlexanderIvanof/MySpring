package com.alex.spring.run;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.Resource;

public class AppResorce {

	public static void main(String[] args) throws IOException {
		
		@SuppressWarnings("resource")
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:autowired.xml");

		/*
		 * http://google.com
		 * classpath:lookup.xml
		 * file:///d:/Java/SpringSamples/MySpring/simple.xml
		 */
		Resource file = context.getResource("classpath:lookup.xml");
		InputStream is = file.getInputStream();
		StringBuilder build = new StringBuilder();
		int i = 0;
		while((i = is.read()) != -1){
			build.append((char) i);
		}
		
		System.out.println(build);
	}

}
