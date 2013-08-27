package com.alex.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Listening {
	
	@Pointcut("execution(* com.alex.spring.beans.Instrument.play(..))")
	public void listen() {
	}


	@Before("listen()")
	public void start() {
		System.out.println("Start listening");
	}

	@After("listen()")
	public void end() {
		System.out.println("End listening");
	}
}
