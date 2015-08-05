package com.git.capie.TestingFramework.controls;

public interface IDropDownList {
	void selectByIndex(int index);

	void selectByText(String text);

	void selectByPartialText(String partialText);
	
	IControl getSelectedElement();
}
