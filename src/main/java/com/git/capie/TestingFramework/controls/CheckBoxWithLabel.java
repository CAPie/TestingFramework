package com.git.capie.TestingFramework.controls;

public class CheckBoxWithLabel implements ICheckBoxWithLabel{
	public static enum Element{
		CHECK_BOX, LABEL
	}
	private ICheckBox checkBox;
	private ILabelClickable labelClickable;
	
	private CheckBoxWithLabel(ICheckBox checkBox, ILabelClickable labelClickable){
		this.checkBox = checkBox;
		this.labelClickable = labelClickable;
	}
	
	public static ICheckBoxWithLabel get(CheckBox checkBox, ILabelClickable labelClickable){
		return new CheckBoxWithLabel(checkBox, labelClickable);
	}
	
	public String getAttribute(Element element, String attribute) {
		String attributeValue;
		switch (element){
		case CHECK_BOX:
			attributeValue = checkBox.getAttribute(attribute);
			break;
		case LABEL:
			attributeValue = labelClickable.getAttribute(attribute);
			break;
		default:
			attributeValue = checkBox.getAttribute(attribute);
			break;
		}
		return attributeValue;
	}
	
	public String getAttribute(String attribute){
		return getAttribute(Element.CHECK_BOX, attribute);
	}

	public String getName() {
		return checkBox.getName();
	}

	public boolean isChecked() {
		return checkBox.isChecked();
	}

	public void check() {
		checkBox.check();
	}

	public void uncheck() {
		checkBox.uncheck();
	}

	public void submit() {
		checkBox.submit();
	}

	public boolean isDisplayed() {
		return checkBox.isDisplayed();
	}

	public boolean isEnabled() {
		return checkBox.isEnabled();
	}

	public String getText() {
		return labelClickable.getText();
	}	
	
	public CheckBox getCheckBox(){
		return (CheckBox)checkBox;
	}
	
	public LabelClickable getLabelClickable(){
		return (LabelClickable)labelClickable;
	}
}
