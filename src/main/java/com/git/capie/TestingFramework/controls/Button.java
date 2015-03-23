package com.git.capie.TestingFramework.controls;

import com.git.capie.TestingFramework.tools.LocationOfWebElement;
import com.git.capie.TestingFramework.tools.WrapperOfWebElement;

public class Button implements IButton {
	private WrapperOfWebElement wrapperOfWebElement;
	private LocationOfWebElement locationOfWebElement;

	private Button(WrapperOfWebElement wrapperOfWebElement,
			LocationOfWebElement locationOfWebElement) {
		this.wrapperOfWebElement = wrapperOfWebElement;
		this.locationOfWebElement = locationOfWebElement;
	}

	public static IButton getById(String id) {
		return get(LocationOfWebElement.getLocationById(id));
	}

	public static IButton getByName(String name) {
		return get(LocationOfWebElement.getLocationByName(name));
	}

	public static IButton getByXpath(String xpathExpression) {
		return get(LocationOfWebElement.getLocationByXPath(xpathExpression));
	}

	public static IButton getByCssSelector(String selector) {
		return get(LocationOfWebElement.getLocationByCssSelector(selector));
	}

	private static IButton get(LocationOfWebElement locationOfWebElement) {
		return new Button(
				WrapperOfWebElement.getVisibleWebElement(locationOfWebElement),
				locationOfWebElement);
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

	public void click() {
		wrapperOfWebElement.click();
		
	}

	public boolean isDisplayed() {
		return wrapperOfWebElement.isDisplayed();
	}

	public boolean isEnabled() {
		return wrapperOfWebElement.isEnabled();
	}
	
	public WrapperOfWebElement getWrapperOfWebElement(){
		return wrapperOfWebElement;
	}
	
	public LocationOfWebElement getLocation(){
		return locationOfWebElement;
	}
}
