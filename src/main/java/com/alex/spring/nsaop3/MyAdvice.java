package com.alex.spring.nsaop3;

import org.aspectj.lang.JoinPoint;

public class MyAdvice {

	public void simpleBeforeAdvice(JoinPoint point) {
		System.out.println(">>>>" + point.getSignature().getDeclaringTypeName()
				+ " ==> " + point.getSignature().getName());
	}

	public void otherBeforeAdvice(JoinPoint point, String value) {
		if (!value.equals("NO")) {
			System.out.println(">>>>"
					+ point.getSignature().getDeclaringTypeName() + " ==> "
					+ point.getSignature().getName());
		} else {
			System.out.println("Not \"NO\"");
		}
	}
}
