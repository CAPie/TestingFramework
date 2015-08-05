package com.git.capie.TestingFramework.controls;

import com.git.capie.TestingFramework.tools.VisibilityOfWebElement;

public class LabelClickable implements ILabelClickable{
	private final Label label;
	private final String VOID_TEXT = "";
	
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
	
	public boolean isInvisible(){
		return VisibilityOfWebElement.get().isInvisibleWebElement(label.getLocation());
	}

	public void click() {
		label.getWrapperOfWebElement().click();
	}

    public void doubleClick() {
        label.getWrapperOfWebElement().doubleClick();
    }

    public void hover(){
		label.getWrapperOfWebElement().hover();
	}

	public boolean isDisplayed() {
		return label.getWrapperOfWebElement().isDisplayed();
	}

	public boolean isEnabled() {
		return label.getWrapperOfWebElement().isEnabled();
	}

	
}
