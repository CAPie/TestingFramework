package com.git.capie.TestingFramework.controls;

interface ITextField {
	String getAttribute(String attribute);
	String getText();
	boolean isDisplayed();
	boolean isEnabled();
	void typeText(String text);
	void submit();
}
