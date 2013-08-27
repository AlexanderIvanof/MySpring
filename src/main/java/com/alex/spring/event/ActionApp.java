package com.alex.spring.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ActionApp implements ApplicationContextAware {

	private ApplicationContext appCtx;
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		GenericXmlApplicationContext ctxt = new GenericXmlApplicationContext();
		ctxt.load("classpath:action/listen.xml");
		ctxt.refresh();
		
		ActionApp ap = (ActionApp) ctxt.getBean("publisher");
		
		ap.publish("Hello World!");
		ap.publish("Quick brown fox jumped over the lazy dogs");
	}
	
	@Override
	public void setApplicationContext(ApplicationContext appCtx)
			throws BeansException {
		this.appCtx = appCtx;
	}
	
	public void publish(String message){
		appCtx.publishEvent(new MessageEvent(this, message));
	}

}
