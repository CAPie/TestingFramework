package com.git.capie.TestingFramework.controls;

import com.git.capie.TestingFramework.enums.ElementVisibility;
import com.git.capie.TestingFramework.tools.LocationOfWebElement;
import com.git.capie.TestingFramework.tools.VisibilityOfWebElement;
import com.git.capie.TestingFramework.tools.WrapperOfWebElement;

public class Link implements ILink {
	private WrapperOfWebElement wrapperOfWebElement;
	private LocationOfWebElement locationOfWebElement;

	private Link(WrapperOfWebElement wrapperOfWebElement,
			LocationOfWebElement locationOfWebElement) {
		this.wrapperOfWebElement = wrapperOfWebElement;
		this.locationOfWebElement = locationOfWebElement;
	}

	public static ILink getById(ElementVisibility visibility, String id) {
		return get(visibility, LocationOfWebElement.getLocationById(id));
	}

	public static ILink getByName(ElementVisibility visibility, String name) {
		return get(visibility, LocationOfWebElement.getLocationByName(name));
	}

	public static ILink getByPartialLinkText(ElementVisibility visibility,
			String linkText) {
		return get(visibility,
				LocationOfWebElement.getLocationByPartialLinkText(linkText));
	}

	public static ILink getByXpath(ElementVisibility visibility,
			String xpathExpression) {
		return get(visibility,
				LocationOfWebElement.getLocationByXPath(xpathExpression));
	}

	public static ILink getByCssSelector(ElementVisibility visibility,
			String selector) {
		return get(visibility,
				LocationOfWebElement.getLocationByCssSelector(selector));
	}

	private static ILink get(ElementVisibility visibility,
			LocationOfWebElement locationOfWebElement) {
		if (visibility == ElementVisibility.VISIBLE) {
			return new Link(
					WrapperOfWebElement
							.getVisibleWebElement(locationOfWebElement),
					locationOfWebElement);
		} if (visibility == ElementVisibility.PRESENT){
			return new Link(
					WrapperOfWebElement
							.getPresentWebElement(locationOfWebElement),
					locationOfWebElement);
		} else {
			ILink link = new Link(
					WrapperOfWebElement
							.getPosibleUexistedWebElement(locationOfWebElement),
					locationOfWebElement);
            if (link == null){
                link = new ILink(){

                    @Override
                    public String getAttribute(String attribute) {
                        return "Element Unexist";
                    }

                    @Override
                    public String getContent() {
                        return "Element Unexist";
                    }

                    @Override
                    public String getText() {
                        return "Element Unexist";
                    }

                    @Override
                    public String getUrl() {
                        return "Element Unexist";
                    }

                    @Override
                    public boolean isInvisible() {
                        return false;
                    }

                    @Override
                    public void click() {
                    }

                    @Override
                    public void doubleClick() {
                    }

                    @Override
                    public void hover() {
                    }

                    @Override
                    public boolean isDisplayed() {
                        return false;
                    }

                    @Override
                    public boolean isEnabled() {
                        return false;
                    }
                };
            }
            return link;
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

	public String getUrl() {
		return wrapperOfWebElement.getUrl();
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
