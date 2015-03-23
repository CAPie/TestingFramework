package com.git.capie.TestingFramework.controls;

interface ILabel {
	String getAttribute(String attribute);
	String getText();
	String getContent();
	void click();
	boolean isDisplayed();
	boolean isEnabled();
}
