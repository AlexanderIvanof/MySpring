package com.alex.spring.i18n;

import java.util.Locale;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageSourceDemo {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		GenericXmlApplicationContext ctxt = new GenericXmlApplicationContext();
		ctxt.load("classpath:i18n/messageSource.xml");
		ctxt.refresh();
		
		Locale english = Locale.ENGLISH;
		Locale russian = new Locale("ru", "RU");
		
		System.out.println(ctxt.getMessage("msg", null, english));
		System.out.println(ctxt.getMessage("msg", null, russian));
		
		System.out.println(ctxt.getMessage("with.array.object", new Object[]{"Alex", "Ivanov"} , english));

	}

}
