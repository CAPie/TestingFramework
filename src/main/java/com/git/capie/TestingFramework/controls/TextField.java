package com.git.capie.TestingFramework.controls;

import com.git.capie.TestingFramework.enums.ElementVisibility;
import com.git.capie.TestingFramework.tools.LocationOfWebElement;
import com.git.capie.TestingFramework.tools.VisibilityOfWebElement;
import com.git.capie.TestingFramework.tools.WrapperOfWebElement;

public class TextField implements ITextField {
	WrapperOfWebElement wrapperOfWebElement;
	LocationOfWebElement locationOfWebElement;

	private TextField(WrapperOfWebElement wrapperOfWebElement,
			LocationOfWebElement locationOfWebElement) {
		this.wrapperOfWebElement = wrapperOfWebElement;
		this.locationOfWebElement = locationOfWebElement;
	}

	public static ITextField getById(ElementVisibility visibility, String id) {
		return get(visibility, LocationOfWebElement.getLocationById(id));
	}

	public static ITextField getByName(ElementVisibility visibility, String name) {
		return get(visibility, LocationOfWebElement.getLocationByName(name));
	}

	public static ITextField getByPartialLinkText(ElementVisibility visibility, String linkText) {
		return get(visibility, LocationOfWebElement.getLocationByPartialLinkText(linkText));
	}

	public static ITextField getByXpath(ElementVisibility visibility, String xpathExpression) {
		return get(visibility, LocationOfWebElement.getLocationByXPath(xpathExpression));
	}

	public static ITextField getByCssSelector(ElementVisibility visibility, String selector) {
		return get(visibility, LocationOfWebElement.getLocationByCssSelector(selector));
	}

	private static ITextField get(ElementVisibility visibility, LocationOfWebElement locationOfWebElement) {
		if (visibility == ElementVisibility.VISIBLE) {
			return new TextField(
					WrapperOfWebElement
							.getVisibleWebElement(locationOfWebElement),
					locationOfWebElement);
		} if (visibility == ElementVisibility.PRESENT) {
			return new TextField(
					WrapperOfWebElement
							.getPresentWebElement(locationOfWebElement),
					locationOfWebElement);
		} else {
            ITextField textField = new TextField(
					WrapperOfWebElement
							.getPosibleUexistedWebElement(locationOfWebElement),
					locationOfWebElement);
            if (textField == null){
                textField = VoidControlStub.get().toITextField();
            }
            return textField;
		}
	}
	
	public String getAttribute(String attribute){
		return wrapperOfWebElement.getAttribute(attribute);
	}

	public String getText() {
		return wrapperOfWebElement.getText();
	}
	
	public String getContent(){
		return wrapperOfWebElement.getContent();
	}

    public void hover() {
        wrapperOfWebElement.hover();
    }

    public boolean isInvisible(){
		return VisibilityOfWebElement.get().isInvisibleWebElement(locationOfWebElement);
	}

	public boolean isDisplayed() {
		return wrapperOfWebElement.isDisplayed();
	}

	public boolean isEnabled() {
		return wrapperOfWebElement.isEnabled();
	}

	public void sendKeys(String text) {
		wrapperOfWebElement.sendKeys(text);
	}

	public void submit() {
		wrapperOfWebElement.submit();
	}

}
