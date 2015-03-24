package com.git.capie.TestingFramework.controls;

import com.git.capie.TestingFramework.controls.RadioButtonWithLabel.Element;

interface IRadioButtonWithLabel extends IRadioButton {
	String getAttribute(Element element, String attribute);
	
	String getText();
}
