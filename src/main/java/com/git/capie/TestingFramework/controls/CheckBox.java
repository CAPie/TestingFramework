package com.git.capie.TestingFramework.controls;

import com.git.capie.TestingFramework.enums.ElementVisibility;
import com.git.capie.TestingFramework.tools.LocationOfWebElement;
import com.git.capie.TestingFramework.tools.WrapperOfWebElement;

public class CheckBox implements ICheckBox {
	private WrapperOfWebElement wrapperOfWebElement;
	private LocationOfWebElement locationOfWebElement;

	private CheckBox(WrapperOfWebElement wrapperOfWebElement, LocationOfWebElement locationOfWebElement) {
		this.wrapperOfWebElement = wrapperOfWebElement;
		this.locationOfWebElement = locationOfWebElement;
	}

	public static ICheckBox getById(ElementVisibility visibility, String id) {
		return get(visibility, LocationOfWebElement.getLocationById(id));
	}

	public static ICheckBox getByName(ElementVisibility visibility, String name) {
		return get(visibility, LocationOfWebElement.getLocationByName(name));
	}

	public static ICheckBox getByXpath(ElementVisibility visibility, String xpathExpression) {
		return get(visibility, LocationOfWebElement.getLocationByXPath(xpathExpression));
	}

	public static ICheckBox getByCssSelector(ElementVisibility visibility, String selector) {
		return get(visibility, LocationOfWebElement.getLocationByCssSelector(selector));
	}

	private static ICheckBox get(ElementVisibility visibility, LocationOfWebElement locationOfWebElement) {
		if (visibility == ElementVisibility.VISIBLE) {
			return new CheckBox(WrapperOfWebElement.getVisibleWebElement(locationOfWebElement), locationOfWebElement);
		}
		if (visibility == ElementVisibility.PRESENT) {
			return new CheckBox(WrapperOfWebElement.getPresentWebElement(locationOfWebElement), locationOfWebElement);
		} else {
			ICheckBox checkBox = new CheckBox(WrapperOfWebElement.getPosibleUexistedWebElement(locationOfWebElement),
					locationOfWebElement);
			if (checkBox == null) {
				checkBox = VoidControlStub.get().toICheckBox();
			}
			return checkBox;
		}
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
		if (!isChecked()) {
			wrapperOfWebElement.click();
		}
	}

	public void uncheck() {
		if (isChecked()) {
			wrapperOfWebElement.click();
		}
	}

	public void submit() {
		wrapperOfWebElement.submit();
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

	public LocationOfWebElement getLocationOfWebElement() {
		return locationOfWebElement;
	}
}
