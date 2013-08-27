package com.alex.spring.run;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.alex.spring.beans.Performer;

@SuppressWarnings("deprecation")
public class AppBeanFactory {

	public static void main(String[] args) throws Exception {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("simple.xml"));
		Performer perf = (Performer) factory.getBean("ben");
		perf.perform();
	}
}
