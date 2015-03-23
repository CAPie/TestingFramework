package com.git.capie.TestingFramework.controls;

import com.git.capie.TestingFramework.controls.CheckBoxWithLabel.Element;

interface ICheckBoxWithLabel extends ICheckBox {

	String getAttribute(Element element, String attribute);
	
	String getText();
}