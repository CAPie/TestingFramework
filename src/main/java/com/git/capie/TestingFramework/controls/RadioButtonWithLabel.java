package com.git.capie.TestingFramework.controls;

public class RadioButtonWithLabel implements IRadioButtonWithLabel{
	public static enum Element{
		RADIO_BUTTON, LABEL
	}
	
	private IRadioButton radioButton;
	private ILabelClickable labelClickable;
	
	private RadioButtonWithLabel(IRadioButton radioButton, ILabelClickable labelClickable) {
		this.radioButton = radioButton;
		this.labelClickable = labelClickable;
	}
	
	public static IRadioButtonWithLabel get(IRadioButton radioButton, ILabelClickable labelClickable){
		return new RadioButtonWithLabel(radioButton, labelClickable);
	}

	public String getAttribute(Element element, String attribute) {
		String attributeValue;
		switch (element){
		case RADIO_BUTTON:
			attributeValue = radioButton.getAttribute(attribute);
			break;
		case LABEL:
			attributeValue = labelClickable.getAttribute(attribute);
			break;
		default:
			attributeValue = radioButton.getAttribute(attribute);
		}
		return attributeValue;
	}

	public String getAttribute(String attribute) {
		return getAttribute(Element.RADIO_BUTTON, attribute);
	}

	public String getText() {
		return labelClickable.getText();
	}

	public String getName() {
		return radioButton.getName();
	}

	public boolean isChecked() {
		return radioButton.isChecked();
	}

	public void check() {
		radioButton.check();
	}

    public boolean isDisplayed() {
		return radioButton.isDisplayed();
	}

	public boolean isEnabled() {
		return radioButton.isEnabled();
	}
	
	public RadioButton getRadioButton(){
		return (RadioButton) radioButton;
	}
	
	public ILabelClickable getLabelClickable(){
		return labelClickable;
	}
}
