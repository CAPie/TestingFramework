package com.git.capie.TestingFramework.controls;

public interface ILabel {
	String getAttribute(String attribute);

	String getText();

	String getContent();
	
	ILabelClickable makeClickable();

    void hover();
	
	boolean isInvisible();

	boolean isDisplayed();

	boolean isEnabled();
}
