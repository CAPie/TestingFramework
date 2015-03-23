package com.git.capie.TestingFramework.controls;

public class LabelClickable implements ILabelClickable{
	private final Label label;
	
	private LabelClickable(Label label) {
		this.label = label;
	}
	
	public static ILabelClickable makeLabelClicable(Label label){
		return new LabelClickable(label);
	}

	public String getAttribute(String attribute) {
		return label.getWrapperOfWebElement().getAttribute(attribute);
	}

	public String getText() {
		return label.getWrapperOfWebElement().getText();
	}

	public String getContent() {
		return label.getWrapperOfWebElement().getContent();
	}

	public void click() {
		label.getWrapperOfWebElement().click();
	}

	public boolean isDisplayed() {
		return label.getWrapperOfWebElement().isDisplayed();
	}

	public boolean isEnabled() {
		return label.getWrapperOfWebElement().isEnabled();
	}
}
