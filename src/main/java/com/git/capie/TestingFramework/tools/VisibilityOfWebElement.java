package com.git.capie.TestingFramework.tools;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VisibilityOfWebElement {
	String ERROR_WEB_ELEMENT_NOT_FOUND = "! ERROR\tWeb element is missing. Location: %s";
	private static volatile VisibilityOfWebElement instance = null;

	private VisibilityOfWebElement() {
	}

	public static VisibilityOfWebElement get() {
		if (instance == null) {
			synchronized (VisibilityOfWebElement.class) {
				if (instance == null) {
					instance = new VisibilityOfWebElement();
				}
			}
		}
		return instance;
	}

	/**
	 * Expectation for checking that an element is present on the DOM of a
	 * page and visible.
	 */
	WebElement getVisibleWebElement(LocationOfWebElement locationOfWebElement) {
		WebElement webelement = new WebDriverWait(WebDriverUtils.get()
				.getWebDriver(), WebDriverUtils.get()
				.getImplicitlyWaitTimeout())
				.until(ExpectedConditions
						.visibilityOfElementLocated(locationOfWebElement
								.getLocatorBy()));
		if (webelement == null) {
			// TODO logs, my own exeption
			throw new RuntimeException(String.format(
					ERROR_WEB_ELEMENT_NOT_FOUND,
					locationOfWebElement.getValueOfLocator()));
		}
		return webelement;
	}

	
	/**
	 * Expectation for checking that an element is present on the DOM of a
	 * page and visibility isn't require.
	 */
	WebElement getPresentWebElement(LocationOfWebElement locationOfWebElement) {
		WebElement webelement = new WebDriverWait(WebDriverUtils.get()
				.getWebDriver(), WebDriverUtils.get()
				.getImplicitlyWaitTimeout()).until(ExpectedConditions
				.presenceOfElementLocated(locationOfWebElement.getLocatorBy()));
		if (webelement == null) {
			// TODO logs, my own exeption
			throw new RuntimeException(String.format(
					ERROR_WEB_ELEMENT_NOT_FOUND,
					locationOfWebElement.getValueOfLocator()));
		}
		return webelement;
	}
}
