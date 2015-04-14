package com.git.capie.TestingFramework.data;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserStackCapabilities {
	public static List <DesiredCapabilities> getRequiredCapabilities(){
		List <DesiredCapabilities> desiredCapabilities = new ArrayList<DesiredCapabilities>();
		DesiredCapabilities caps0 = new DesiredCapabilities();
		caps0.setCapability("browser", "Safari");
		caps0.setCapability("browser_version", "8.0");
		caps0.setCapability("os", "OS X");
		caps0.setCapability("os_version", "Yosemite");
		caps0.setCapability("resolution", "1280x960");
		desiredCapabilities.add(caps0); 
		
		DesiredCapabilities caps1 = new DesiredCapabilities();
		caps1.setCapability("browser", "Firefox");
		caps1.setCapability("browser_version", "35.0");
		caps1.setCapability("os", "Windows");
		caps1.setCapability("os_version", "8");
		caps1.setCapability("resolution", "1920x1080");
		desiredCapabilities.add(caps1); 
		
		DesiredCapabilities caps2 = new DesiredCapabilities();
		caps2.setCapability("browser", "IE");
		caps2.setCapability("browser_version", "10.0");
		caps2.setCapability("os", "Windows");
		caps2.setCapability("os_version", "8");
		caps2.setCapability("resolution", "1024x768");
		desiredCapabilities.add(caps2); 
		
		DesiredCapabilities caps3 = new DesiredCapabilities();
		caps3.setCapability("browserName", "android");
		caps3.setCapability("platform", "ANDROID");
		caps3.setCapability("device", "Samsung Galaxy S5");
		desiredCapabilities.add(caps3); 
		
		DesiredCapabilities caps4 = new DesiredCapabilities();
		caps3.setCapability("browserName", "iPad");
		caps3.setCapability("platform", "MAC");
		caps3.setCapability("device", "iPad Air");
		desiredCapabilities.add(caps4);
		
		return desiredCapabilities;
	}
}
