package com.alex.spring.lookup;

public abstract class AbstractLookup implements DemoBean {

	@Override
	public abstract MyHelper getMyHelper();

	@Override
	public void someOperation() {
		getMyHelper().doSomething();
	}

}
