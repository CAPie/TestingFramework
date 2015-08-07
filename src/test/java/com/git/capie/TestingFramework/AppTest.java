package com.git.capie.TestingFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.git.capie.TestingFramework.tools.WebDriverUtils;
import com.git.capie.TestingFramework.tools.WebDriverUtils.Browsers;

public class AppTest {

	String GOOGLE_URL= "http://www.google.com";
	String GOOGLE_TITLE= "google";

	@Test
	public void testChrome() {
		System.out.println("Chrome test");
		WebDriverUtils.get(Browsers.CHROME).goToUrl(GOOGLE_URL);
		String actual = WebDriverUtils.get().getTitle().toLowerCase();
		WebDriverUtils.get().quit();
		Assert.assertEquals(actual, GOOGLE_TITLE);
	}

	@Test
	public void testFF() {
		System.out.println("FF test");
		WebDriverUtils.get(Browsers.FIREFOX).goToUrl(GOOGLE_URL);
		String actual = WebDriverUtils.get().getTitle().toLowerCase();
		WebDriverUtils.get().quit();
		Assert.assertEquals(actual, GOOGLE_TITLE);
	}

	@Test
	public void testFFDef() {
		System.out.println("DefaultFF test");
		WebDriverUtils.get(Browsers.FIREFOX_BY_DEFAULT_PROFILE).goToUrl(
                GOOGLE_URL);
		String actual = WebDriverUtils.get().getTitle().toLowerCase();
		WebDriverUtils.get().quit();
		Assert.assertEquals(actual, GOOGLE_TITLE);
	}

	@Test
	public void testIE() {
		System.out.println("IE test");
		WebDriverUtils.get(Browsers.IE).goToUrl(GOOGLE_URL);
		String actual = WebDriverUtils.get().getTitle().toLowerCase();
		WebDriverUtils.get().quit();
		Assert.assertEquals(actual, GOOGLE_TITLE);
	}
}
