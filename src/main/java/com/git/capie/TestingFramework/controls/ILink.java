package com.git.capie.TestingFramework.controls;

public interface ILink {
	String getAttribute(String attribute);
	String getContent();
	String getText();
	String getUrl();
	void click();
	boolean isDisplayed();
	boolean isEnabled();
}
