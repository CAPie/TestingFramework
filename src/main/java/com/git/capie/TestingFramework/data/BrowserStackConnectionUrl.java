package com.git.capie.TestingFramework.data;


public class BrowserStackConnectionUrl {
	private static final String URL = "http://%s:%s@hub.browserstack.com/wd/hub";

	public static String getURL() {
		String username = "capcapie1";
		String key = "fvqbY6wvJy9zpckcXVTD";
		return String.format(URL, username, key);
	}
}
