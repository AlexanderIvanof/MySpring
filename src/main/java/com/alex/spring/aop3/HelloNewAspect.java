package com.alex.spring.aop3;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

class MessageWriter{
	public void writeWorld(){
		System.out.print("World");
	}
}

class MessageDecorator implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.print("Hello, ");
		Object retVal = invocation.proceed();
		System.out.println("!");
		return retVal;
	}
	
}


public class HelloNewAspect {
	
	public static void main(String[] args) {
		MessageWriter mvr = new MessageWriter();
		
		// create proxy 
		ProxyFactory proxy = new ProxyFactory();
		
		proxy.addAdvice(new MessageDecorator());
		proxy.setTarget(mvr);
		
		MessageWriter mvrProxy = (MessageWriter) proxy.getProxy();
		
		// get a output
		mvr.writeWorld();
		System.out.println(" ");
		mvrProxy.writeWorld();
	}
}
