package com.git.capie.TestingFramework.controls;

public interface ILabelClickable {
    String getAttribute(String attribute);

    String getText();

    String getContent();

    boolean isInvisible();

    void click();

    void doubleClick();

    void hover();

    boolean isDisplayed();

    boolean isEnabled();
}
