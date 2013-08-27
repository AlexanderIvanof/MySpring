package com.alex.spring.event;

import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<MessageEvent> {
	
	@Override
	public void onApplicationEvent(MessageEvent event) {
		System.out.println("Received " + event.getMessage());
	}

}
