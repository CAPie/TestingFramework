package com.git.capie.TestingFramework.tools;

import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;

public class WrapperOfBrowserStackCapabilities {
	private DesiredCapabilities browserStackCapabilities;
	Map<String, ?> mappedCapabilities;

	private static String RESOLUTION = "resolution";
	private static String BROWSER_NAME = "browserName";
	private static String PLATFORM = "platform";
	private static String DEVICE = "device";
	private static String OS = "os";
	//private static String OS_VERSION = "os_version";
	private static String BROWSER = "browser";
	private static String BROWSER_VERSION = "browser_version";

	public WrapperOfBrowserStackCapabilities() {
		browserStackCapabilities = WebDriverUtils.get().getCapabilities();
		mappedCapabilities = browserStackCapabilities.asMap();
	}

	public String getResolution() {
		return mappedCapabilities.get(RESOLUTION).toString();
	}

	public String getBrowser() {
		if (isDevice()) {
			return mappedCapabilities.get(BROWSER_NAME).toString();
		} else {
			return mappedCapabilities.get(BROWSER).toString()
					+ mappedCapabilities.get(BROWSER_VERSION).toString();
		}
	}

	public String getPlatform() {
		return mappedCapabilities.get(PLATFORM).toString();
	}

	public String getDeviceOrOs() {
		if (isDevice()) {
			return mappedCapabilities.get(DEVICE).toString();
		} else {
			return mappedCapabilities.get(OS).toString();
		}
	}

	public boolean isDevice() {
		return mappedCapabilities.containsKey(BROWSER_NAME);
	}
}
