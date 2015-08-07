package com.git.capie.TestingFramework.controls;

import com.git.capie.TestingFramework.enums.ElementVisibility;
import com.git.capie.TestingFramework.tools.LocationOfWebElement;
import com.git.capie.TestingFramework.tools.VisibilityOfWebElement;
import com.git.capie.TestingFramework.tools.WrapperOfWebElement;

public class Label implements ILabel, ILabelClickable {
	private WrapperOfWebElement wrapperOfWebElement;
	private LocationOfWebElement locationOfWebElement;

	private final String VOID_TEXT = "";

	private Label(WrapperOfWebElement wrapperOfWebElement,
			LocationOfWebElement locationOfWebElement) {
		this.wrapperOfWebElement = wrapperOfWebElement;
		this.locationOfWebElement = locationOfWebElement;
	}

	public static ILabel getById(ElementVisibility visibility, String id) {
		return get(visibility, LocationOfWebElement.getLocationById(id));
	}

	public static ILabel getByName(ElementVisibility visibility, String name) {
		return get(visibility, LocationOfWebElement.getLocationByName(name));
	}

	public static ILabel getByXpath(ElementVisibility visibility,
			String xpathExpression) {
		return get(visibility,
				LocationOfWebElement.getLocationByXPath(xpathExpression));
	}

	public static ILabel getByCssSelector(ElementVisibility visibility,
			String selector) {
		return get(visibility,
				LocationOfWebElement.getLocationByCssSelector(selector));
	}

	public static ILabel getByPartialLinkText(ElementVisibility visibility,
			String linkText) {
		return get(visibility,
				LocationOfWebElement.getLocationByPartialLinkText(linkText));
	}

    public ILabelClickable makeClickable() {
        return this;
    }

	private static ILabel get(ElementVisibility visibility,
			LocationOfWebElement locationOfWebElement) {
		if (visibility == ElementVisibility.VISIBLE) {
			return new Label(
					WrapperOfWebElement
							.getVisibleWebElement(locationOfWebElement),
					locationOfWebElement);
		}
		if (visibility == ElementVisibility.PRESENT) {
			return new Label(
					WrapperOfWebElement
							.getPresentWebElement(locationOfWebElement),
					locationOfWebElement);
		} else {
			ILabel label = new Label(
					WrapperOfWebElement
							.getPosibleUexistedWebElement(locationOfWebElement),
					locationOfWebElement);
            if (label == null){
                label = VoidControlStub.get().toILabel();
            }
            return label;
		}
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

	public boolean isInvisible() {
		return VisibilityOfWebElement.get().isInvisibleWebElement(
				locationOfWebElement);
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
