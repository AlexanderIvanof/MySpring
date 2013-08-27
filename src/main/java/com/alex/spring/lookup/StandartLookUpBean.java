package com.alex.spring.lookup;

public class StandartLookUpBean implements DemoBean {

	private MyHelper myHelper;
	
	@Override
	public MyHelper getMyHelper() {
		return myHelper;
	}

	@Override
	public void someOperation() {
		myHelper.doSomething();
	}

	/**
	 * @param myBean the myBean to set
	 */
	public void setMyHelper(MyHelper myHelper) {
		this.myHelper = myHelper;
	}

}
