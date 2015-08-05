package com.git.capie.TestingFramework.controls;

import com.git.capie.TestingFramework.enums.ElementVisibility;
import com.git.capie.TestingFramework.tools.LocationOfWebElement;
import com.git.capie.TestingFramework.tools.VisibilityOfWebElement;
import com.git.capie.TestingFramework.tools.WrapperOfWebElement;

public class Label implements ILabel {
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
                label = new ILabel() {
                    @Override
                    public String getAttribute(String attribute) {
                        return "Element Unexist";
                    }

                    @Override
                    public String getText() {
                        return "Element Unexist";
                    }

                    @Override
                    public String getContent() {
                        return "Element Unexist";
                    }

                    @Override
                    public ILabelClickable makeLabelClickable() {
                        return new ILabelClickable() {
                            @Override
                            public String getAttribute(String attribute) {
                                return "Element Unexist";
                            }

                            @Override
                            public String getText() {
                                return null;
                            }

                            @Override
                            public String getContent() {
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

                    @Override
                    public void hover() {

                    }

                    @Override
                    public boolean isInvisible() {
                        return false;
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

	public ILabelClickable makeLabelClickable() {
		return LabelClickable.makeLabelClicable(this);
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
