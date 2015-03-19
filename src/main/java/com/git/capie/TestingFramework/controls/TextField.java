package com.git.capie.TestingFramework.controls;

import com.git.capie.TestingFramework.tools.LocationOfWebElement;
import com.git.capie.TestingFramework.tools.WrapperOfWebElement;

public class TextField implements ITextField {
	WrapperOfWebElement wrapperOfWebElement;
	LocationOfWebElement locationOfWebElement;

	private TextField(WrapperOfWebElement wrapperOfWebElement,
			LocationOfWebElement locationOfWebElement) {
		this.wrapperOfWebElement = wrapperOfWebElement;
		this.locationOfWebElement = locationOfWebElement;
	}

	public static ITextField getById(String id) {
		return get(LocationOfWebElement.getLocationById(id));
	}

	public static ITextField getByName(String name) {
		return get(LocationOfWebElement.getLocationByName(name));
	}

	public static ITextField getByPartialLinkText(String linkText) {
		return get(LocationOfWebElement.getLocationByPartialLinkText(linkText));
	}

	public static ITextField getByXpath(String xpathExpression) {
		return get(LocationOfWebElement.getLocationByXPath(xpathExpression));
	}

	public static ITextField getByCssSelector(String selector) {
		return get(LocationOfWebElement.getLocationByCssSelector(selector));
	}

	private static ITextField get(LocationOfWebElement locationOfWebElement) {
		return new TextField(
				WrapperOfWebElement.getVisibleWebElement(locationOfWebElement),
				locationOfWebElement);
	}
	
	public String getAttribute(String attribute){
		return wrapperOfWebElement.getAttribute(attribute);
	}

	public String getText() {
		return wrapperOfWebElement.getText();
	}

	public boolean isDisplayed() {
		return wrapperOfWebElement.isDisplayed();
	}

	public boolean isEnabled() {
		return wrapperOfWebElement.isEnabled();
	}

	public void typeText(String text) {
		wrapperOfWebElement.sendKeys(text);
	}

	public void submit() {
		wrapperOfWebElement.submit();
	}

}
