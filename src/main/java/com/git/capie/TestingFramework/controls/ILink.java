package com.git.capie.TestingFramework.controls;

public interface ILink {
	String getAttribute(String attribute);

	String getContent();

	String getText();

	String getUrl();
	
	boolean isInvisible();

	void click();

    void doubleClick();

    void hover();

	boolean isDisplayed();

	boolean isEnabled();
}
