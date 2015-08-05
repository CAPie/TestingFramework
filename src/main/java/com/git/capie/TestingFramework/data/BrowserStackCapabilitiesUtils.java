package com.git.capie.TestingFramework.data;

import com.git.capie.TestingFramework.tools.WrapperOfBrowserStackCapabilities;

public class BrowserStackCapabilitiesUtils {
	private static String SLASH = "\\";

	private BrowserStackCapabilitiesUtils() {
	}

	public static int getResolitionHight(
			WrapperOfBrowserStackCapabilities browserStackCapabilities) {
		return Integer.parseInt(browserStackCapabilities.getResolution());
	}

	public static String getPath(
			WrapperOfBrowserStackCapabilities browserStackCapabilities) {
		String path;
		if (browserStackCapabilities.isDevice()) {
			path = SLASH + browserStackCapabilities.getPlatform() + SLASH
					+ browserStackCapabilities.getDeviceOrOs() + SLASH;
		} else {
			path = SLASH + browserStackCapabilities.getDeviceOrOs() + SLASH
					+ browserStackCapabilities.getBrowser() + SLASH
					+ browserStackCapabilities.getResolution() + SLASH;
		}
		return path;
	}

}
