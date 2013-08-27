package com.alex.spring.aop3;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] arg1, Object arg2)
			throws Throwable {
		System.out.println("Before what method, we are usually use to advice? Before "
						+ method.getName());
	}

	public static void main(String[] args) {
		MessageWriter mvr = new MessageWriter();
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new SimpleBeforeAdvice());
		pf.setTarget(mvr);
		
		MessageWriter proxy = (MessageWriter) pf.getProxy();
		proxy.writeWorld();
	}

}
