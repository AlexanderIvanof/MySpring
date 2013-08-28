package com.alex.spring.nsaop3;

public class MyDependency {

	public void foo(int val){
		System.out.println("foo() " + val);
	}
	
	public void bar(String str){
		System.out.println("bar("+str+")");
	}
	
	public void foo(int i, String  str){
		System.out.println(">>> foo("+i+") " + str);
	}
	
	public void foo(){
		System.out.println("foo() empty");
	}
}
