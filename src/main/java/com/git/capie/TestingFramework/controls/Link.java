package com.git.capie.TestingFramework.controls;

import com.git.capie.TestingFramework.tools.LocationOfWebElement;
import com.git.capie.TestingFramework.tools.WrapperOfWebElement;

public class Link implements ILink {	
	private WrapperOfWebElement wrapperOfWebElement;
	private LocationOfWebElement locationOfWebElement;

	private Link(WrapperOfWebElement wrapperOfWebElement,
			LocationOfWebElement locationOfWebElement) {
		this.wrapperOfWebElement = wrapperOfWebElement;
		this.locationOfWebElement = locationOfWebElement;
	}

	public static ILink getById(String id) {
		return get(LocationOfWebElement.getLocationById(id));
	}

	public static ILink getByName(String name) {
		return get(LocationOfWebElement.getLocationByName(name));
	}

	public static ILink getByPartialLinkText(String linkText) {
		return get(LocationOfWebElement.getLocationByPartialLinkText(linkText));
	}

	public static ILink getByXpath(String xpathExpression) {
		return get(LocationOfWebElement.getLocationByXPath(xpathExpression));
	}

	public static ILink getByCssSelector(String selector) {
		return get(LocationOfWebElement.getLocationByCssSelector(selector));
	}

	private static ILink get(LocationOfWebElement locationOfWebElement) {
		return new Link(
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

	public String getUrl() {
		return wrapperOfWebElement.getUrl();
	}

	public void click() {
	}

	public boolean isDisplayed() {
		return wrapperOfWebElement.isDisplayed();
	}

	public boolean isEnabled() {
		return wrapperOfWebElement.isEnabled();
	}
}
