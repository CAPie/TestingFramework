package com.git.capie.TestingFramework.tools;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtils {
    private static volatile ActionUtils instance = null;
    Actions actions;

    private ActionUtils() {
        actions = new Actions(WebDriverUtils.get().getWebDriver());
    }

    public static ActionUtils get() {
        if (instance == null) {
            synchronized (ActionUtils.class) {
                if (instance == null) {
                    instance = new ActionUtils();
                }
            }
        }
        return instance;
    }

    public void doubleClick(WebElement onElement) {
        actions.doubleClick(onElement);
    }

    public void dragAndDrop(WebElement source, WrapperOfWebElement target) {
        actions.dragAndDrop(source, target.getWebelement());
    }

    public void keyDownToBrowser(Keys theKey) {
        actions.keyDown(theKey);
        actions.keyUp(theKey);
    }

    public void keyDownToElement(WebElement element, Keys theKey) {
        actions.keyDown(element, theKey);
        actions.keyUp(element, theKey);
    }

    public void moveToElement(WebElement toElement) {
        actions.moveToElement(toElement);
    }
}
