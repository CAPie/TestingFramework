package com.git.capie.TestingFramework.controls;

import com.git.capie.TestingFramework.enums.ElementVisibility;
import com.git.capie.TestingFramework.tools.LocationOfWebElement;
import com.git.capie.TestingFramework.tools.WrapperOfWebElement;

public class RadioButton implements IRadioButton {
    private WrapperOfWebElement wrapperOfWebElement;
    private LocationOfWebElement locationOfWebElement;

    private RadioButton(WrapperOfWebElement wrapperOfWebElement,
                        LocationOfWebElement locationOfWebElement) {
    }

    public static IRadioButton getById(ElementVisibility visibility, String id) {
        return get(visibility, LocationOfWebElement.getLocationById(id));
    }

    public static IRadioButton getByName(ElementVisibility visibility, String name) {
        return get(visibility, LocationOfWebElement.getLocationByName(name));
    }

    public static IRadioButton getByCssSelector(ElementVisibility visibility, String selector) {
        return get(visibility, LocationOfWebElement.getLocationByCssSelector(selector));
    }

    public static IRadioButton getByXPath(ElementVisibility visibility, String xpathExpression) {
        return get(visibility, LocationOfWebElement.getLocationByXPath(xpathExpression));
    }

    private static IRadioButton get(ElementVisibility visibility, LocationOfWebElement locationOfWebElement) {
        if (visibility == ElementVisibility.VISIBLE) {
            return new RadioButton(
                    WrapperOfWebElement
                            .getVisibleWebElement(locationOfWebElement),
                    locationOfWebElement);
        }
        if (visibility == ElementVisibility.PRESENT) {
            return new RadioButton(
                    WrapperOfWebElement
                            .getPresentWebElement(locationOfWebElement),
                    locationOfWebElement);
        } else {
            IRadioButton radioButton = new RadioButton(
                    WrapperOfWebElement
                            .getPosibleUexistedWebElement(locationOfWebElement),
                    locationOfWebElement);
            if (radioButton == null) {
                radioButton = VoidControlStub.get().toIRadioButton();
            }
            return radioButton;
        }
    }

    public String getAttribute(String attribute) {
        return wrapperOfWebElement.getAttribute(attribute);
    }

    public String getName() {
        return wrapperOfWebElement.getName();
    }

    public boolean isChecked() {
        return wrapperOfWebElement.isSelectet();
    }

    public void check() {
        wrapperOfWebElement.click();
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

    public LocationOfWebElement geLocation() {
        return locationOfWebElement;
    }
}
