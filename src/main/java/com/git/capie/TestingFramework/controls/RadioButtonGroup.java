package com.git.capie.TestingFramework.controls;

import java.util.ArrayList;
import java.util.List;

public class RadioButtonGroup implements IRadioButtonGroup,
		IRadioButtonGroupAddFirst, IRadioButtonGroupNext {
	public static enum ActionBy {
		PARTIAL_TEXT, SEQUENCE_NUMBER
	}

	private String RADIO_BUTTON_GROUP_DOES_NOT_CONTAIN = "Radio button group does not contain text: %s";
	private String INVALID_SEQUENCE_NUMBER = "Invalid sequence number, expected value: [1 : %s]";
	private String INVALID_ACTION = "%s - Invalid Action";
	private String NO_CHECKED_RADIO_BUTTONS = "No checked radio buttons in this group";
	private List<IRadioButtonWithLabel> radioButtonList;

	private RadioButtonGroup() {
		radioButtonList = new ArrayList<IRadioButtonWithLabel>();
	}

	public static IRadioButtonGroupAddFirst get() {
		return new RadioButtonGroup();
	}

	public IRadioButtonGroupNext addFirstRadioButton(
			RadioButtonWithLabel radioButtonWithLabel) {
		radioButtonList.add(radioButtonWithLabel);
		return this;
	}

	public IRadioButtonGroupNext addNextRadioButton(
			RadioButtonWithLabel radioButtonWithLabel) {
		radioButtonList.add(radioButtonWithLabel);
		return this;
	}

	public IRadioButtonGroup build() {
		return this;
	}

	public IRadioButtonWithLabel getCheckedRadioButton() {
		IRadioButtonWithLabel result = null;
		if (isSelectedRadioButton()) {
			for (IRadioButtonWithLabel radioButton : radioButtonList) {
				if (radioButton.isChecked()) {
					result = radioButton;
					break;
				}
			}
		} else {
			throw new RuntimeException(NO_CHECKED_RADIO_BUTTONS);
		}
		return result;
	}

	public void checkBy(ActionBy actionBy, String value) {
		switch (actionBy) {
		case PARTIAL_TEXT:
			getRadioButtonWithLabelByPartialText(value).check();
			break;
		case SEQUENCE_NUMBER:
			int sequenceNumber = Integer.parseInt(value.trim());
			getRadioButtonWithLabelBySequenceNumber(sequenceNumber).check();
			break;
		default:
			throw new RuntimeException(String.format(INVALID_ACTION, actionBy));
		}
	}

	public boolean areAllRadioButtonsDisabled() {
		boolean result = false;
		for (IRadioButtonWithLabel radioButton : radioButtonList){
			result = result & radioButton.isDisplayed();
		}
		return result;
	}

	public boolean areAllRadioButtonsEnabled() {
		boolean result = false;
		for (IRadioButtonWithLabel radioButton : radioButtonList){
			result = result & radioButton.isEnabled();
		}
		return result;
	}

	public boolean isSelectedRadioButton() {
		boolean result = false;
		for (IRadioButtonWithLabel radioButton : radioButtonList) {
			if (radioButton.isChecked()) {
				result = true;
				break;
			}
		}
		return result;
	}

	public RadioButtonWithLabel getRadioButtonWithLabelBy(ActionBy actionBy,
			String value) {
		RadioButtonWithLabel result = null;
		switch (actionBy) {
		case PARTIAL_TEXT:
			result = getRadioButtonWithLabelByPartialText(value);
			break;
		case SEQUENCE_NUMBER:
			int sequenceNumber = Integer.parseInt(value.trim());
			result = getRadioButtonWithLabelBySequenceNumber(sequenceNumber);
			break;
		default:
			throw new RuntimeException(String.format(INVALID_ACTION, actionBy));
		}
		return result;
	}

	private RadioButtonWithLabel getRadioButtonWithLabelByPartialText(
			String text) {
		RadioButtonWithLabel result = null;
		for (IRadioButtonWithLabel radioButton : radioButtonList) {
			if (radioButton.getText().contains(text)) {
				result = (RadioButtonWithLabel) radioButton;
				break;
			}
		}
		if (result == null) {
			throw new RuntimeException(String.format(
					RADIO_BUTTON_GROUP_DOES_NOT_CONTAIN, text));
		}
		return result;
	}

	private RadioButtonWithLabel getRadioButtonWithLabelBySequenceNumber(
			int sequenceNumber) {
		RadioButtonWithLabel result = null;
		if ((radioButtonList.size() < sequenceNumber) & (sequenceNumber > 0)) {
			result = (RadioButtonWithLabel) radioButtonList
					.get(sequenceNumber - 1);
		} else {
			throw new RuntimeException(String.format(INVALID_SEQUENCE_NUMBER,
					sequenceNumber));
		}
		return result;
	}
}
