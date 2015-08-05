package com.git.capie.TestingFramework.data;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserStackCapabilities {
	public static List <DesiredCapabilities> getRequiredCapabilities(){
		List <DesiredCapabilities> desiredCapabilities = new ArrayList<DesiredCapabilities>();
		
		DesiredCapabilities fireFox1024x768 = new DesiredCapabilities();
		fireFox1024x768.setCapability("browser", "Firefox");
		fireFox1024x768.setCapability("browser_version", "35.0");
		fireFox1024x768.setCapability("os", "Windows");
		fireFox1024x768.setCapability("os_version", "8");
		fireFox1024x768.setCapability("resolution", "1024x768");
		desiredCapabilities.add(fireFox1024x768); 
		
//		DesiredCapabilities fireFox1366x768 = new DesiredCapabilities();
//		fireFox1366x768.setCapability("browser", "Firefox");
//		fireFox1366x768.setCapability("browser_version", "35.0");
//		fireFox1366x768.setCapability("os", "Windows");
//		fireFox1366x768.setCapability("os_version", "8");
//		fireFox1366x768.setCapability("resolution", "1024x768");
//		desiredCapabilities.add(fireFox1366x768); 
//		
//		DesiredCapabilities fireFox1920x1080 = new DesiredCapabilities();
//		fireFox1920x1080.setCapability("browser", "Firefox");
//		fireFox1920x1080.setCapability("browser_version", "35.0");
//		fireFox1920x1080.setCapability("os", "Windows");
//		fireFox1920x1080.setCapability("os_version", "8");
//		fireFox1920x1080.setCapability("resolution", "1920x1080");
//		desiredCapabilities.add(fireFox1920x1080); 
		
		DesiredCapabilities opera1024x768 = new DesiredCapabilities();
		opera1024x768.setCapability("browser", "Opera");
		opera1024x768.setCapability("browser_version", "12.16");
		opera1024x768.setCapability("os", "Windows");
		opera1024x768.setCapability("os_version", "8");
		opera1024x768.setCapability("resolution", "1024x768");
		desiredCapabilities.add(opera1024x768); 
		
//		DesiredCapabilities opera1366x768 = new DesiredCapabilities();
//		opera1366x768.setCapability("browser", "Opera");
//		opera1366x768.setCapability("browser_version", "12.16");
//		opera1366x768.setCapability("os", "Windows");
//		opera1366x768.setCapability("os_version", "8");
//		opera1366x768.setCapability("resolution", "1366x768");
//		desiredCapabilities.add(opera1366x768); 
//		
//		DesiredCapabilities opera1920x1080 = new DesiredCapabilities();
//		opera1920x1080.setCapability("browser", "Opera");
//		opera1920x1080.setCapability("browser_version", "12.16");
//		opera1920x1080.setCapability("os", "Windows");
//		opera1920x1080.setCapability("os_version", "8");
//		opera1920x1080.setCapability("resolution", "1920x1080");
//		desiredCapabilities.add(opera1920x1080); 
		
		DesiredCapabilities safari1024x768 = new DesiredCapabilities();
		safari1024x768.setCapability("browser", "Safari");
		safari1024x768.setCapability("browser_version", "8.0");
		safari1024x768.setCapability("os", "OS X");
		safari1024x768.setCapability("os_version", "Yosemite");
		safari1024x768.setCapability("resolution", "1024x768");
		desiredCapabilities.add(safari1024x768); 
		
//		DesiredCapabilities safari1280x960 = new DesiredCapabilities();
//		safari1280x960.setCapability("browser", "Safari");
//		safari1280x960.setCapability("browser_version", "8.0");
//		safari1280x960.setCapability("os", "OS X");
//		safari1280x960.setCapability("os_version", "Yosemite");
//		safari1280x960.setCapability("resolution", "1280x960");
//		desiredCapabilities.add(safari1280x960); 
//		
//		DesiredCapabilities safari1366x768 = new DesiredCapabilities();
//		safari1366x768.setCapability("browser", "Safari");
//		safari1366x768.setCapability("browser_version", "8.0");
//		safari1366x768.setCapability("os", "OS X");
//		safari1366x768.setCapability("os_version", "Yosemite");
//		safari1366x768.setCapability("resolution", "1366x768");
//		desiredCapabilities.add(safari1366x768); 
		
		DesiredCapabilities safari1920x1080 = new DesiredCapabilities();
		safari1920x1080.setCapability("browser", "Safari");
		safari1920x1080.setCapability("browser_version", "8.0");
		safari1920x1080.setCapability("os", "OS X");
		safari1920x1080.setCapability("os_version", "Yosemite");
		safari1920x1080.setCapability("resolution", "1920x1080");
		desiredCapabilities.add(safari1920x1080); 
		
//		DesiredCapabilities ie9r1024x768 = new DesiredCapabilities();
//		ie9r1024x768.setCapability("browser", "IE");
//		ie9r1024x768.setCapability("browser_version", "9.0");
//		ie9r1024x768.setCapability("os", "Windows");
//		ie9r1024x768.setCapability("os_version", "7");
//		ie9r1024x768.setCapability("resolution", "1024x768");
//		desiredCapabilities.add(ie9r1024x768); 
//		
//		DesiredCapabilities ie9r1366x768 = new DesiredCapabilities();
//		ie9r1366x768.setCapability("browser", "IE");
//		ie9r1366x768.setCapability("browser_version", "9.0");
//		ie9r1366x768.setCapability("os", "Windows");
//		ie9r1366x768.setCapability("os_version", "7");
//		ie9r1366x768.setCapability("resolution", "1366x768");
//		desiredCapabilities.add(ie9r1366x768); 
		
		DesiredCapabilities ie9r1920x1080 = new DesiredCapabilities();
		ie9r1920x1080.setCapability("browser", "IE");
		ie9r1920x1080.setCapability("browser_version", "9.0");
		ie9r1920x1080.setCapability("os", "Windows");
		ie9r1920x1080.setCapability("os_version", "7");
		ie9r1920x1080.setCapability("resolution", "1920x1080");
		desiredCapabilities.add(ie9r1920x1080); 
		
//		DesiredCapabilities ie11r1024x768 = new DesiredCapabilities();
//		ie11r1024x768.setCapability("browser", "IE");
//		ie11r1024x768.setCapability("browser_version", "11.0");
//		ie11r1024x768.setCapability("os", "Windows");
//		ie11r1024x768.setCapability("os_version", "8.1");
//		ie11r1024x768.setCapability("resolution", "1024x768");
//		desiredCapabilities.add(ie11r1024x768);
//		
//		DesiredCapabilities ie11r1366x768 = new DesiredCapabilities();
//		ie11r1024x768.setCapability("browser", "IE");
//		ie11r1024x768.setCapability("browser_version", "11.0");
//		ie11r1024x768.setCapability("os", "Windows");
//		ie11r1024x768.setCapability("os_version", "8.1");
//		ie9r1366x768.setCapability("resolution", "1366x768");
//		desiredCapabilities.add(ie11r1366x768); 
		
		DesiredCapabilities ie11r1920x1080 = new DesiredCapabilities();
		ie11r1920x1080.setCapability("browser", "IE");
		ie11r1920x1080.setCapability("browser_version", "11.0");
		ie11r1920x1080.setCapability("os", "Windows");
		ie11r1920x1080.setCapability("os_version", "8.1");
		ie11r1920x1080.setCapability("resolution", "1920x1080");
		desiredCapabilities.add(ie11r1920x1080); 
		
//		DesiredCapabilities chrome1024x768 = new DesiredCapabilities();
//		chrome1024x768.setCapability("browser", "Chrome");
//		chrome1024x768.setCapability("browser_version", "39.0");
//		chrome1024x768.setCapability("os", "Windows");
//		chrome1024x768.setCapability("os_version", "8.1");
//		chrome1024x768.setCapability("resolution", "1024x768");
//		desiredCapabilities.add(chrome1024x768);
//		
//		DesiredCapabilities chrome1366x768 = new DesiredCapabilities();
//		chrome1366x768.setCapability("browser", "Chrome");
//		chrome1366x768.setCapability("browser_version", "39.0");
//		chrome1366x768.setCapability("os", "Windows");
//		chrome1366x768.setCapability("os_version", "8.1");
//		chrome1366x768.setCapability("resolution", "1366x768");
//		desiredCapabilities.add(chrome1366x768);
		
		DesiredCapabilities chrome1920x1080 = new DesiredCapabilities();
		chrome1920x1080.setCapability("browser", "Chrome");
		chrome1920x1080.setCapability("browser_version", "39.0");
		chrome1920x1080.setCapability("os", "Windows");
		chrome1920x1080.setCapability("os_version", "8.1");
		chrome1920x1080.setCapability("resolution", "1920x1080");
		desiredCapabilities.add(chrome1920x1080);
		
		DesiredCapabilities nexus7 = new DesiredCapabilities();
		nexus7.setCapability("browserName", "android");
		nexus7.setCapability("platform", "ANDROID");
		nexus7.setCapability("device", "Google Nexus 7");
		desiredCapabilities.add(nexus7);
		
//		DesiredCapabilities galaxyS5 = new DesiredCapabilities();
//		galaxyS5.setCapability("browserName", "android");
//		galaxyS5.setCapability("platform", "ANDROID");
//		galaxyS5.setCapability("device", "Samsung Galaxy S5");
//		desiredCapabilities.add(galaxyS5);
//		
//		DesiredCapabilities galaxyS4 = new DesiredCapabilities();
//		galaxyS4.setCapability("browserName", "android");
//		galaxyS4.setCapability("platform", "ANDROID");
//		galaxyS4.setCapability("device", "Samsung Galaxy S4");
//		desiredCapabilities.add(galaxyS4);
//		
//		DesiredCapabilities galaxyS3 = new DesiredCapabilities();
//		galaxyS3.setCapability("browserName", "android");
//		galaxyS3.setCapability("platform", "ANDROID");
//		galaxyS3.setCapability("device", "Samsung Galaxy S3");
//		desiredCapabilities.add(galaxyS3);
		
		DesiredCapabilities iPhone5s = new DesiredCapabilities();
		iPhone5s.setCapability("browserName", "iPhone");
		iPhone5s.setCapability("platform", "MAC");
		iPhone5s.setCapability("device", "iPhone 5S");
		desiredCapabilities.add(iPhone5s);
		
//		DesiredCapabilities iPadAir = new DesiredCapabilities();
//		iPadAir.setCapability("browserName", "iPad");
//		iPadAir.setCapability("platform", "MAC");
//		iPadAir.setCapability("device", "iPad Air");
//		desiredCapabilities.add(iPhone5s);
		
		return desiredCapabilities;
	}
}
