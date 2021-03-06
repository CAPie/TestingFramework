package com.git.capie.TestingFramework.controls;

public interface ITextField {
	String getAttribute(String attribute);

	String getText();

	String getContent();

    void hover();
	
	boolean isInvisible();

	boolean isDisplayed();

	boolean isEnabled();

	void sendKeys(String text);

	void submit();
}
