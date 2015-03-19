package com.git.capie.TestingFramework.tools;

import org.openqa.selenium.WebElement;

public class WrapperOfWebElement {
	private WebElement webelement;

	private WrapperOfWebElement(WebElement webelement) {
		this.webelement = webelement;
		webelement.isDisplayed();
	}

	public static WrapperOfWebElement get(WebElement webelement) {
		return new WrapperOfWebElement(webelement);
	}

	public static WrapperOfWebElement getVisibleWebElement(
			LocationOfWebElement locationOfWebElement) {
		return new WrapperOfWebElement(VisibilityOfWebElement.get()
				.getVisibleWebElement(locationOfWebElement));
	}

	public static WrapperOfWebElement getPresentWebElement(
			LocationOfWebElement locationOfWebElement) {
		return new WrapperOfWebElement(VisibilityOfWebElement.get()
				.getPresentWebElement(locationOfWebElement));
	}

	public boolean isDisplayed() {
		return this.webelement.isDisplayed();
	}

	public boolean isEnabled() {
		return this.webelement.isEnabled();
	}

	public boolean isSelectet() {
		return this.webelement.isSelected();
	}

	public String getText() {
		return this.webelement.getText();
	}
	
	public String getAttribute(String attribute) {
		return this.webelement.getAttribute(attribute);
	}

	public void sendKeys(String text) {
		this.webelement.clear();
		this.webelement.sendKeys(text);
	}

	public void click() {
		this.webelement.click();
	}

	public void submit() {
		this.webelement.submit();
	}
}
