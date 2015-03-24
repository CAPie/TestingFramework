package com.git.capie.TestingFramework.controls;

import com.git.capie.TestingFramework.controls.CheckBoxWithLabel.Element;

public interface ICheckBoxWithLabel extends ICheckBox {

	String getAttribute(Element element, String attribute);
	
	String getText();
}