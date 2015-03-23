package com.git.capie.TestingFramework.controls;

interface IRadioButton {
	String getAttribute(String attribute);

	String getName();
	
	boolean isChecked();
	
	void check();
	
	boolean isDisplayed();

	boolean isEnabled();
}
