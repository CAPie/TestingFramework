package com.git.capie.TestingFramework.controls;

import com.git.capie.TestingFramework.tools.WrapperOfWebElement;

public class Control implements IControl, IButton, ILabel, ILabelClickable, ILink {
    private WrapperOfWebElement wrapperOfWebElement;

    private Control(WrapperOfWebElement wrapperOfWebElement) {
        this.wrapperOfWebElement = wrapperOfWebElement;
    }

    public static IControl get(WrapperOfWebElement wrapperOfWebElement) {
        return new Control(wrapperOfWebElement);
    }

    public IButton toIButton() {
        return this;
    }

    public ILabel toILabel() {
        return this;
    }

    public ILabelClickable toILabelClickable() {
        return this;
    }

    public ILink toILink() {
        return this;
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

    public String getAttribute(String attribute) {
        return wrapperOfWebElement.getAttribute(attribute);
    }

    public String getText() {
        return wrapperOfWebElement.getText();
    }

    public String getContent() {
        return wrapperOfWebElement.getContent();
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

    public String getUrl() {
        return wrapperOfWebElement.getUrl();
    }

    @Deprecated
    public ILabelClickable makeClickable() {
        return this;
    }

    public boolean isInvisible() {
        return false;
    }
}
