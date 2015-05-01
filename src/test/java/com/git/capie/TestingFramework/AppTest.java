package com.git.capie.TestingFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.git.capie.TestingFramework.tools.WebDriverUtils;
import com.git.capie.TestingFramework.tools.WebDriverUtils.Browsers;

public class AppTest {
	String googleUrl = "http://www.google.com";

	//@Test
	public void testDefault() {
		WebDriverUtils.get().goToUrl(googleUrl);
		String actual = WebDriverUtils.get().getTitle().toLowerCase();
		WebDriverUtils.get().quit();
		Assert.assertEquals(actual, "google");
	}

	//@Test
	public void testChrome() {
		WebDriverUtils.get(Browsers.CHROME).goToUrl(googleUrl);
		String actual = WebDriverUtils.get().getTitle().toLowerCase();
		WebDriverUtils.get().quit();
		Assert.assertEquals(actual, "google");
	}

	//@Test
	public void testFF() {
		WebDriverUtils.get(Browsers.FIREFOX).goToUrl(googleUrl);
		String actual = WebDriverUtils.get().getTitle().toLowerCase();
		WebDriverUtils.get().quit();
		Assert.assertEquals(actual, "google");
	}

	@Test
	public void testFFDef() {
		WebDriverUtils.get(Browsers.FIREFOX_BY_DEFAULT_PROFILE).goToUrl(
				googleUrl);
		String actual = WebDriverUtils.get().getTitle().toLowerCase();
		WebDriverUtils.get().quit();
		//Assert.assertEquals(actual, "google");
	}

	//@Test
	public void testIE() {
		WebDriverUtils.get(Browsers.IE).goToUrl(googleUrl);
		String actual = WebDriverUtils.get().getTitle().toLowerCase();
		WebDriverUtils.get().quit();
		Assert.assertEquals(actual, "google");
	}
}
