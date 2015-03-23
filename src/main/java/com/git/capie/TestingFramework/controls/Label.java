package com.git.capie.TestingFramework.controls;

import com.git.capie.TestingFramework.tools.LocationOfWebElement;
import com.git.capie.TestingFramework.tools.WrapperOfWebElement;

public class Label implements ILabel {
	private WrapperOfWebElement wrapperOfWebElement;
	private LocationOfWebElement locationOfWebElement;

	private Label(WrapperOfWebElement wrapperOfWebElement,
			LocationOfWebElement locationOfWebElement) {
		this.wrapperOfWebElement = wrapperOfWebElement;
		this.locationOfWebElement = locationOfWebElement;
	}

	public static ILabel getById(String id) {
		return get(LocationOfWebElement.getLocationById(id));
	}

	public static ILabel getByName(String name) {
		return get(LocationOfWebElement.getLocationByName(name));
	}

	public static ILabel getByPartialLinkText(String linkText) {
		return get(LocationOfWebElement.getLocationByPartialLinkText(linkText));
	}

	public static ILabel getByXpath(String xpathExpression) {
		return get(LocationOfWebElement.getLocationByXPath(xpathExpression));
	}

	public static ILabel getByCssSelector(String selector) {
		return get(LocationOfWebElement.getLocationByCssSelector(selector));
	}

	private static ILabel get(LocationOfWebElement locationOfWebElement) {
		return new Label(
				WrapperOfWebElement.getVisibleWebElement(locationOfWebElement),
				locationOfWebElement);
	}
	
	public String getAttribute(String attribute) {
		return wrapperOfWebElement.getAttribute(attribute);
	}

	public String getText() {
		return wrapperOfWebElement.getText();
	}

	public String getContent() {
		return wrapperOfWebElement.getContent();
	}
	
	public void click(){
		wrapperOfWebElement.click();
	}
	
	public boolean isDisplayed(){
		return wrapperOfWebElement.isDisplayed();
	}
	
	public boolean isEnabled(){
		return wrapperOfWebElement.isEnabled();
	}
	
	public WrapperOfWebElement getWrapperOfWebElement(){
		return wrapperOfWebElement;
	}
	public LocationOfWebElement getLocation(){
		return locationOfWebElement;
	}
}
