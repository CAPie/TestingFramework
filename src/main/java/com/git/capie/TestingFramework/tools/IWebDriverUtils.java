package com.git.capie.TestingFramework.tools;

import org.openqa.selenium.WebDriver;

interface IWebDriverUtils {
	WebDriver getWebDriver();

	long getImplicitlyWaitTimeout();

	void goToURL(String url);

	void goToPreviousPage();

	void goToForvardPage();

	void refreshPage();

	String getPageURL();

	String getPageSource();

	void getScreenshot(String fileName);

	void quit();
}
