package com.git.capie.TestingFramework.controls;

public interface IButton {
	String getAttribute(String attribute);

	String getContent();
	
	String getText();

	void click();

    void doubleClick();
    
    void hover();

	boolean isDisplayed();

	boolean isEnabled();
}
