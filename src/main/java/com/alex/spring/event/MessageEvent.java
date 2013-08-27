package com.alex.spring.event;

import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent {

	private String message;
	
	public MessageEvent(Object source, String message) {
		super(source);
		this.message = message;
	}

	private static final long serialVersionUID = 1L;
	
	public String getMessage() {
		return message;
	}

}
