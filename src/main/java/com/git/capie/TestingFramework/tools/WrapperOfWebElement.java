package com.git.capie.TestingFramework.tools;

import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WrapperOfWebElement {
    private final String EMPTY = "";
    private final String GET_TEXT_PATTERN = "(^|>)([^<>]+)($|<)";
    private final String SPACE = " ";
    private final String HREF_ATTRIBUTE = "href";
    private final String NAME_ATTRIBUTE = "name";
    private final int MATCHER_GET_TEXT_GROUP = 2;
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

    public static WrapperOfWebElement getPosibleUexistedWebElement(
            LocationOfWebElement locationOfWebElement) {
        return new WrapperOfWebElement(VisibilityOfWebElement.get()
                .getPosibleUexistedWebElement(locationOfWebElement));
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

    public String getContent() {
        return this.webelement.getText();
    }

    public String getText() {
        String text = EMPTY;
        Matcher matcher = Pattern.compile(GET_TEXT_PATTERN).matcher(getContent());
        while (matcher.find()) {
            if (!matcher.group(MATCHER_GET_TEXT_GROUP).trim().isEmpty()) {
                text = text + SPACE + matcher.group(MATCHER_GET_TEXT_GROUP).trim();
            }
        }
        return text;
    }

    public String getAttribute(String attribute) {
        return this.webelement.getAttribute(attribute);
    }

    public String getUrl() {
        return this.webelement.getAttribute(HREF_ATTRIBUTE);
    }

    public String getName() {
        return this.webelement.getAttribute(NAME_ATTRIBUTE);
    }

    public void sendKeys(String text) {
        this.webelement.clear();
        this.webelement.sendKeys(text);
    }

    public void click() {
        this.webelement.click();
    }

    public void doubleClick() {
        ActionUtils.get().doubleClick(webelement);
    }

    public void hover() {
        ActionUtils.get().moveToElement(webelement);
    }

    public void submit() {
        this.webelement.submit();
    }

    WebElement getWebelement() {
        return webelement;
    }
}
