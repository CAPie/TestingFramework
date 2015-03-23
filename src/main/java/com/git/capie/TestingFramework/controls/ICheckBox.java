package com.git.capie.TestingFramework.controls;

interface ICheckBox {
	String getAttribute(String attribute);

	String getName();
	
	boolean isChecked();
	
	void check();
	
	void uncheck();
	
	void submit();

	boolean isDisplayed();

	boolean isEnabled();
}
