package com.alex.spring.nsaop3;

public class MyBean {

	private MyDependency dep;
	
	public void execute(){
		dep.foo(100);
		dep.bar();
	}
	
	public void setDep(MyDependency dep){
		this.dep = dep;
	}
}
