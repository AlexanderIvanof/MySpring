package com.alex.spring.aop3;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

class SimpleAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println(">>>>Invocing " + invocation.getMethod().getName());
		Object obj = invocation.proceed();
		System.out.println(">>>>Done");
		return obj;
	}
	
}

public class AspectApp {

	public static void main(String[] args) {

		AspectjExp obj = new AspectjExp();
		
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(* foo*(..))");
		Advisor adv = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());
		
		// create proxy 
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(adv);
		pf.setTarget(obj);
		
		// call method
		AspectjExp proxy = (AspectjExp)pf.getProxy();
		
		proxy.foo1();
		proxy.foo2();
		proxy.bar();
	}

}
