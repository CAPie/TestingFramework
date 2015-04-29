package com.git.capie.TestingFramework;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.git.capie.TestingFramework.data.BrowserStackCapabilities;
import com.git.capie.TestingFramework.data.ListUtils;
import com.git.capie.TestingFramework.data.UrlRepository;
import com.git.capie.TestingFramework.tools.WebDriverUtils;
import com.git.capie.TestingFramework.tools.WebDriverUtils.Browsers;

public class AppTest {
	
	@DataProvider
	// (parallel = true)
	public Object[][] browserStackCaps() {
		return ListUtils.listToArray(BrowserStackCapabilities
				.getRequiredCapabilities());
	}

	@Test(dataProvider = "browserStackCaps")
	public void testApp(DesiredCapabilities desiredCapabilities) {
		System.out.println("testStart");
		SimpleDateFormat dateForm = new SimpleDateFormat(
				"yyyy-MM-dd-HH-mm-ss-S");
		Date ÒurrentTime = new Date();
		WebDriverUtils.set().setBrowser(Browsers.BROWSER_STACK);
		System.out.println("browserStack done");
		WebDriverUtils.set().setRemote—apability(desiredCapabilities);
		System.out.println("Caps done");
		WebDriverUtils.get().goToURL(UrlRepository.getItwOurWorkUrl());
		System.out.println("Url done");
		WebDriverUtils.get().getScreenshot(
				String.format("D:\\itwconsulting-our-work+%s.bmp",
						dateForm.format(ÒurrentTime)));
		System.out.println("Screenshot done");
		WebDriverUtils.get().quit();
		System.out.println("browserStack quit");
	}
}
