package com.git.capie.TestingFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.git.capie.TestingFramework.tools.WebDriverUtils;
import com.git.capie.TestingFramework.tools.WebDriverUtils.Browsers;

public class AppTest {
	String GOOGLE_URL= "http://www.google.com";
	String GOOGLE_TITLE= "google";

	@Test
	public void testDefault() {
		WebDriverUtils.get().goToUrl(GOOGLE_URL);
		String actual = WebDriverUtils.get().getTitle().toLowerCase();
		WebDriverUtils.get().quit();
		Assert.assertEquals(actual, GOOGLE_TITLE);
	}

	@Test
	public void testChrome() {
		WebDriverUtils.get(Browsers.CHROME).goToUrl(GOOGLE_URL);
		String actual = WebDriverUtils.get().getTitle().toLowerCase();
		WebDriverUtils.get().quit();
		Assert.assertEquals(actual, GOOGLE_TITLE);
	}

	@Test
	public void testFF() {
		WebDriverUtils.get(Browsers.FIREFOX).goToUrl(GOOGLE_URL);
		String actual = WebDriverUtils.get().getTitle().toLowerCase();
		WebDriverUtils.get().quit();
		Assert.assertEquals(actual, GOOGLE_TITLE);
	}

	@Test
	public void testFFDef() {
		WebDriverUtils.get(Browsers.FIREFOX_BY_DEFAULT_PROFILE).goToUrl(
                GOOGLE_URL);
		String actual = WebDriverUtils.get().getTitle().toLowerCase();
		WebDriverUtils.get().quit();
		Assert.assertEquals(actual, GOOGLE_TITLE);
	}

	@Test
	public void testIE() {
		WebDriverUtils.get(Browsers.IE).goToUrl(GOOGLE_URL);
		String actual = WebDriverUtils.get().getTitle().toLowerCase();
		WebDriverUtils.get().quit();
		Assert.assertEquals(actual, GOOGLE_TITLE);
	}
}
