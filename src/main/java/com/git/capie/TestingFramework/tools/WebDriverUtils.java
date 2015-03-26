package com.git.capie.TestingFramework.tools;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverUtils {
	
	/**
	 * Enumeration of Browser Types
	 */
	public static enum Browsers{
		CHROME(20, "Chrome") {
            WebDriver start() {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--start-maximized");
                return new ChromeDriver(options);
            }
        },
        FIREFOX(20, "Firefox") {
            WebDriver start() {
                return new FirefoxDriver();
            }
        },
        FIREFOX_BY_DEFAULT_PROFILE(20, "Firefox by default profile") {
            WebDriver start() {
                ProfilesIni profileIni = new ProfilesIni();
                FirefoxProfile profile = profileIni
                        .getProfile(firefoxDefaultProfile);
                profile.setAcceptUntrustedCertificates(true);
                profile.setPreference(APP_UPDATE_ENABLED, false);
                return new FirefoxDriver(profile);
            }
        },
        IE(120, "Internet Explorer") {
            WebDriver start() {
                DesiredCapabilities capabilities = DesiredCapabilities
                        .internetExplorer();
                capabilities
                        .setCapability(
                                InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                                true);
                return new InternetExplorerDriver(capabilities);
            }
        };

        private static String APP_UPDATE_ENABLED;
        private static String firefoxDefaultProfile;
        private long implicitlyWaitTimeout;
        private String name;
        
        static {
        	APP_UPDATE_ENABLED = "app.update.enabled";
            firefoxDefaultProfile = "defaultProfile";
        }
        
        private Browsers(long implicitlyWaitTimeout, String name){
        	this.implicitlyWaitTimeout=implicitlyWaitTimeout;
            this.name=name;
        }
        
        public long getImplicitlyWaitTimeout() {
			return implicitlyWaitTimeout;
		}

		public String getName() {
			return name;
		}

		abstract WebDriver start();

		@Override
		public String toString() {
			return name;
		}
	}
	
	private final String ERROR_TAKE_SCREENSHOT = "Take Screenshot. I/O Error";
	private static Logger logger = LoggerFactory
			.getLogger(WebDriverUtils.class);
	private volatile static WebDriverUtils instanse = null;
	private WebDriver driver;
	private final long IMPLICITLY_WAIT_TIMEOUT = 20;
	
	private WebDriverUtils(){}
	
	public static WebDriverUtils get(){
		if (instanse == null){
			synchronized (WebDriverUtils.class) {
				if (instanse == null){
					instanse = new WebDriverUtils();
				}
			}
		}
		return instanse;
	}
	
	WebDriver getWebDriver(){
		if (driver == null){
			synchronized (WebDriverUtils.class) {
				if (driver == null){
					// TODO Other WebDrivers, Read from pom.xml
					// driver = Browsers.FIREFOX_ADD_FIREBUG.start();
					// driver = Browsers.CHROME.start();
					// driver = Browsers.IE.start();
					driver = Browsers.FIREFOX.start();
                    driver.manage()
                            .timeouts()
                            .implicitlyWait(getImplicitlyWaitTimeout(),
                                    TimeUnit.SECONDS);
                    driver.manage().window().maximize();
				}
			}
		}
		return driver;
	}
	
	public long getImplicitlyWaitTimeout(){
		return IMPLICITLY_WAIT_TIMEOUT;
	}
	
	public void goToURL(String url){
		getWebDriver().get(url);
	}
	
	public void goToPreviousPage(){
		getWebDriver().navigate().back();
	}
	
	public void goToForvardPage(){
		getWebDriver().navigate().forward();
	}
	
	public void refreshPage(){
		getWebDriver().navigate().refresh();
	}
	
	public String getPageURL(){
		return getWebDriver().getCurrentUrl();
	}
	
	public String getPageSource(){
		return getWebDriver().getPageSource();
	}
	
	public void getScreenshot(String fileName){
		try {
			File srcFile = ((TakesScreenshot) getWebDriver())
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(fileName));
		} catch (Exception e) {
			// e.printStackTrace();
			logger.error(ERROR_TAKE_SCREENSHOT + e.getStackTrace().toString());
			// TODO Develop My Exception
			throw new RuntimeException(ERROR_TAKE_SCREENSHOT);
		}
	}
	
	public void quit(){
		getWebDriver().quit();
	}
}