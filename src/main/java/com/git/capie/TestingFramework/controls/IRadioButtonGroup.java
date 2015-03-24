package com.git.capie.TestingFramework.controls;

import com.git.capie.TestingFramework.controls.RadioButtonGroup.ActionBy;


interface IRadioButtonGroup {
	
	IRadioButtonWithLabel getCheckedRadioButton();
	
	void checkBy(ActionBy actionBy, String value);
	
	boolean areAllRadioButtonsDisabled();
	
	boolean areAllRadioButtonsEnabled();
	
	boolean isSelectedRadioButton();
}
