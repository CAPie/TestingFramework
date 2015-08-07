package com.git.capie.TestingFramework.controls;

import com.git.capie.TestingFramework.enums.ElementVisibility;
import com.git.capie.TestingFramework.tools.LocationOfWebElement;
import com.git.capie.TestingFramework.tools.VisibilityOfWebElement;
import com.git.capie.TestingFramework.tools.WrapperOfWebElement;

public class Button implements IButton {
	private WrapperOfWebElement wrapperOfWebElement;
	private LocationOfWebElement locationOfWebElement;

	private Button(WrapperOfWebElement wrapperOfWebElement, LocationOfWebElement locationOfWebElement) {
		this.wrapperOfWebElement = wrapperOfWebElement;
		this.locationOfWebElement = locationOfWebElement;
	}

	public static IButton getById(ElementVisibility visibility, String id) {
		return get(visibility, LocationOfWebElement.getLocationById(id));
	}

	public static IButton getByName(ElementVisibility visibility, String name) {
		return get(visibility, LocationOfWebElement.getLocationByName(name));
	}

	public static IButton getByXpath(ElementVisibility visibility, String xpathExpression) {
		return get(visibility, LocationOfWebElement.getLocationByXPath(xpathExpression));
	}

	public static IButton getByCssSelector(ElementVisibility visibility, String selector) {
		return get(visibility, LocationOfWebElement.getLocationByCssSelector(selector));
	}

	private static IButton get(ElementVisibility visibility, LocationOfWebElement locationOfWebElement) {
		if (visibility == ElementVisibility.VISIBLE) {
			return new Button(WrapperOfWebElement.getVisibleWebElement(locationOfWebElement), locationOfWebElement);
		}
		if (visibility == ElementVisibility.PRESENT) {
			return new Button(WrapperOfWebElement.getPresentWebElement(locationOfWebElement), locationOfWebElement);
		} else {
			IButton button = new Button(WrapperOfWebElement.getPosibleUexistedWebElement(locationOfWebElement),
					locationOfWebElement);
			if (button == null) {

				button = VoidControlStub.get().toIButton();
			}
			return button;
		}
	}

	public String getAttribute(String attribute) {
		return wrapperOfWebElement.getAttribute(attribute);
	}

	public String getContent() {
		return wrapperOfWebElement.getContent();
	}

	public String getText() {
		return wrapperOfWebElement.getText();
	}

	public boolean isInvisible() {
		return VisibilityOfWebElement.get().isInvisibleWebElement(locationOfWebElement);
	}

	public void click() {
		wrapperOfWebElement.click();
	}

	public void doubleClick() {
		wrapperOfWebElement.doubleClick();
	}

	public void hover() {
		wrapperOfWebElement.hover();
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

	public LocationOfWebElement getLocation() {
		return locationOfWebElement;
	}
}
