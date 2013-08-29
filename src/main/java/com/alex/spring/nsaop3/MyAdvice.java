package com.alex.spring.nsaop3;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class MyAdvice {

	private static Logger log = Logger.getLogger(MyAdvice.class);

	public void simpleBeforeAdvice(JoinPoint point) {
		System.out.println(">>>>" + point.getSignature().getDeclaringTypeName()
				+ " ==> " + point.getSignature().getName());
	}

	public void otherBeforeAdvice(JoinPoint point, String value) {
		if (!value.equals("NO")) {
			System.out.println(">>>>"
					+ point.getSignature().getDeclaringTypeName() + " ==> "
					+ point.getSignature().getName() + "\"" + value + "\"");
		} else {
			System.out.println("Not \"NO\"");
		}
	}

	public void simpleAfter(JoinPoint jp, String str) {
		log.info("Out method >> " + jp.getSignature().getDeclaringTypeName()
				+ "." + jp.getSignature().getName());
		System.out.println(">>>>>>>>>" + str + "<<<<<<<<");
		log.info("Arg is " + str);
	}
}
