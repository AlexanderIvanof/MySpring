package com.alex.spring.methodreplacer;

public class TargetBean {

	public String formatMessage(String str){
		return "<h1>" + str +"</h1>";
	}
	
	public String formatMessage(Object str){
		return "<h1>" + str.toString() +"</h1>";
	}
}
