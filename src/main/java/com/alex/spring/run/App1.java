package com.alex.spring.run;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

import com.alex.spring.lookup.DemoBean;
import com.alex.spring.lookup.MyHelper;

public class App1 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:lookup.xml");
		DemoBean obj1 = (DemoBean) context.getBean("standart");
		DemoBean obj2 = (DemoBean) context.getBean("abstract");

		/*
		 * TEsting
		 */
		MyHelper mhelp = obj1.getMyHelper();
		MyHelper mhelp1 = obj1.getMyHelper();
		System.out.println(mhelp == mhelp1);

		MyHelper mhelp2 = obj2.getMyHelper();
		MyHelper mhelp3 = obj2.getMyHelper();
		System.out.println(mhelp2 == mhelp3);

		StopWatch watch = new StopWatch();
		watch.start("lookupDemo");
		for (int i = 0; i < 100000; i++) {
			MyHelper asdf = obj2.getMyHelper();
			asdf.doSomething();
		}
		watch.stop();
		System.out.println("Total time is " + watch.getLastTaskTimeMillis()
				+ " ms");

	}

}
