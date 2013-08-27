package com.alex.spring.methodreplacer;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class TargetMessageReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args)
			throws Throwable {
		if(isFormatMessageMethod(method)){
			String msg = (String) args[0];
			return "<h2>"+msg+"</h2>"; 
		}else{
			throw new IllegalArgumentException("Unable to reimplement method " + method.getName());
		}
	}
	
	public boolean isFormatMessageMethod(Method meth){
		// number of parameters
		if(meth.getParameterTypes().length != 1){
			return false;
		}
		
		// name of method
		if(!meth.getName().equals("formatMessage")){
			return false;
		}
		
		// return type
		if(meth.getReturnType() != String.class){
			return false;
		}
		
		// type of parameter
		if(meth.getParameterTypes()[0] != String.class){
			return false;
		}
		return true;
	}

}
