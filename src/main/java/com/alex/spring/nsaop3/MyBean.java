package com.alex.spring.nsaop3;

public class MyBean {

	private MyDependency dep;
	
	public void execute(String name){
		dep.foo(100);
		dep.bar(name);
		dep.foo();
		dep.foo(123, "Hello");
	}
	
	public void setDep(MyDependency dep){
		this.dep = dep;
	}
}
