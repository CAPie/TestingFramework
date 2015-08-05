package com.git.capie.TestingFramework.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VisibilityOfWebElement {
	private final String ERROR_WEB_ELEMENT_NOT_FOUND = "! ERROR\tWeb element is missing. Location: %s";
	private final String ERROR_WEBELEMENT_NOT_INVISIBLE = "! ERROR\tWebElement is still visible: %s";
	private final String PAGE_URL = ". Current URL: ";
	private final String LEFT_BRACKET = "[";
	private final String RIGHT_BRACKET = "]";
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
	 * Expectation for checking that an element is present on the DOM of a page
	 * and visible.
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
	 * Expectation for checking that a select is present on the DOM of a page
	 * and visible.
	 */
	Select getVisibleSelect(LocationOfWebElement locationOfWebElement) {
		WebElement webelement = getVisibleWebElement(locationOfWebElement);
		return new Select(webelement);
	}

	/**
	 * Expectation for checking that a select is present on the DOM of a page
	 * and visibility isn't require.
	 */
	Select getPresentSelect(LocationOfWebElement locationOfWebElement) {
		WebElement webelement = getPresentWebElement(locationOfWebElement);
		return new Select(webelement);
	}

	/**
	 * Expectation for checking that an element is present on the DOM of a page
	 * and visibility isn't require.
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

	/**
	 * Expectation for checking that a select is present on the DOM of a page
	 * and visibility isn't require.
	 */
	Select getPosibleUexistedSelect(LocationOfWebElement locationOfWebElement) {
		WebElement webelement = getPosibleUexistedWebElement(locationOfWebElement);
		return new Select(webelement);
	}

	/**
	 * Expectation for checking that an element is present on the DOM of a page
	 * and visibility isn't require.
	 */
	WebElement getPosibleUexistedWebElement(
			LocationOfWebElement locationOfWebElement) {
		try {
			WebElement webelement = new WebDriverWait(WebDriverUtils.get()
					.getWebDriver(), WebDriverUtils.get()
					.getImplicitlyWaitTimeout()).until(ExpectedConditions
					.presenceOfElementLocated(locationOfWebElement
							.getLocatorBy()));
			return webelement;
		} catch (NoSuchElementException noSuchElementException) {
			// TODO: Logs
			System.out.println(noSuchElementException.getMessage());
			return null;
		}
	}

	/**
	 * An expectation for checking that an element is either invisible or not
	 * present on the DOM.
	 */

	public boolean isInvisibleWebElement(
			LocationOfWebElement locationOfWebElement) {
		boolean isInvisible = false;
		try {
			setImplicitWait(1);
			for (long i = 0; i < WebDriverUtils.get()
					.getImplicitlyWaitTimeout(); i++)
				try {
					isInvisible = new WebDriverWait(WebDriverUtils.get()
							.getWebDriver(), WebDriverUtils.get()
							.getImplicitlyWaitTimeout())
							.until(ExpectedConditions
									.invisibilityOfElementLocated(locationOfWebElement
											.getLocatorBy()));
				} finally {
					if (isInvisible) {
						break;
					}
				}
		} finally {
			restoreDefaultImplicitWait();
			if (!isInvisible) {
				String webElementNotInvisibleErrorInfo = String.format(
						ERROR_WEBELEMENT_NOT_INVISIBLE, LEFT_BRACKET
								+ locationOfWebElement.getValueOfLocator()
								+ RIGHT_BRACKET + PAGE_URL
								+ WebDriverUtils.get().getCurrentUrl());
				throw new RuntimeException(webElementNotInvisibleErrorInfo);
			}
		}
		return isInvisible;
	}

	/**
	 * For getting List of WebElements from the DOM
	 */

	public List<WrapperOfWebElement> getListOfWebElements(
			LocationOfWebElement locationOfWebElement) {
		List<WrapperOfWebElement> wrappersOfWebElement = new ArrayList<WrapperOfWebElement>();
		List<WebElement> webElements = WebDriverUtils.get().getWebDriver()
				.findElements(locationOfWebElement.getLocatorBy());
		for (WebElement webElement : webElements) {
			wrappersOfWebElement.add(WrapperOfWebElement.get(webElement));
		}
		return wrappersOfWebElement;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private void setImplicitWait(long timeInSeconds) {
		WebDriverUtils.get().getWebDriver().manage().timeouts()
				.implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
	}

	private void restoreDefaultImplicitWait() {
		setImplicitWait(WebDriverUtils.get().getImplicitlyWaitTimeout());
	}

}
