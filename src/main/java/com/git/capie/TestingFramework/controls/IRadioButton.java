package com.git.capie.TestingFramework.controls;

public interface IRadioButton {
	String getAttribute(String attribute);

	String getName();
	
	boolean isChecked();
	
	void check();
	
	boolean isDisplayed();

	boolean isEnabled();
}
