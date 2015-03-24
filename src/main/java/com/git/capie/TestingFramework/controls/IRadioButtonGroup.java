package com.git.capie.TestingFramework.controls;

import com.git.capie.TestingFramework.controls.RadioButtonGroup.ActionBy;


public interface IRadioButtonGroup {
	
	IRadioButtonWithLabel getCheckedRadioButton();
	
	void checkBy(ActionBy actionBy, String value);
	
	boolean areAllRadioButtonsDisabled();
	
	boolean areAllRadioButtonsEnabled();
	
	boolean isSelectedRadioButton();
}
