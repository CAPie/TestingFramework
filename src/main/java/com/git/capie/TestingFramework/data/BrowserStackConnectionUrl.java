package com.git.capie.TestingFramework.data;


public class BrowserStackConnectionUrl {
	private static final String URL = "http://%s:%s@hub.browserstack.com/wd/hub";

	public static String getURL() {
		  String username = "username";
		  String key = "key";
		return String.format(URL, username, key);
	}
}

