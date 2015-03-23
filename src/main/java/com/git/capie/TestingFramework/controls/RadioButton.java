package com.git.capie.TestingFramework.controls;

import com.git.capie.TestingFramework.tools.LocationOfWebElement;
import com.git.capie.TestingFramework.tools.WrapperOfWebElement;

public class RadioButton implements IRadioButton {
	private WrapperOfWebElement wrapperOfWebElement;
	private LocationOfWebElement locationOfWebElement;

	private RadioButton(WrapperOfWebElement wrapperOfWebElement,
			LocationOfWebElement locationOfWebElement) {
	}

	public static IRadioButton getById(String id) {
		return get(LocationOfWebElement.getLocationById(id));
	}

	public static IRadioButton getByName(String name) {
		return get(LocationOfWebElement.getLocationByName(name));
	}

	public static IRadioButton getByCssSelector(String selector) {
		return get(LocationOfWebElement.getLocationByCssSelector(selector));
	}

	public static IRadioButton getByXPath(String xpathExpression) {
		return get(LocationOfWebElement.getLocationByXPath(xpathExpression));
	}

	private static IRadioButton get(LocationOfWebElement locationOfWebElement) {
		return new RadioButton(
				WrapperOfWebElement.getVisibleWebElement(locationOfWebElement),
				locationOfWebElement);
	}

	public String getAttribute(String attribute) {
		return wrapperOfWebElement.getAttribute(attribute);
	}

	public String getName() {
		return wrapperOfWebElement.getName();
	}

	public boolean isChecked() {
		return wrapperOfWebElement.isSelectet();
	}

	public void check() {
		wrapperOfWebElement.click();
	}

	public boolean isDisplayed() {
		return wrapperOfWebElement.isDisplayed();
	}

	public boolean isEnabled() {
		return wrapperOfWebElement.isEnabled();
	}

	public WrapperOfWebElement getWrapperOfWebElement() {
		return wrapperOfWebElement;
	}

	public LocationOfWebElement geLocation() {
		return locationOfWebElement;
	}
}
