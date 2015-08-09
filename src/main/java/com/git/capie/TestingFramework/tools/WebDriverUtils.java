package com.git.capie.TestingFramework.tools;

import com.git.capie.TestingFramework.data.BrowserStackConnectionUrl;
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
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * This class consist of Browsers enumeration, methods for Starting a Selenium
 * WebDriver's driver, managing BrowserStack connection and desired
 * capabilities, wrappers for managing of Selenium WebElements
 * 
 * @author CAPie
 * 
 */

public class WebDriverUtils {

	/**
	 * Enumeration of Browser Types
	 */
	public static enum Browsers {
		CHROME(20, "Chrome") {
			WebDriver start() {
				// ChromeOptions options = new ChromeOptions();
				// options.addArguments("--ignore-certificate-errors");
				// options.addArguments("--start-maximized");
				// return new ChromeDriver(options);
				return new ChromeDriver();
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
				FirefoxProfile profile = profileIni.getProfile(firefoxDefaultProfile);
				// profile.setAcceptUntrustedCertificates(true);
				// profile.setPreference(APP_UPDATE_ENABLED, false);
				return new FirefoxDriver(profile);
			}
		},

		IE(120, "Internet Explorer") {
			WebDriver start() {
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				return new InternetExplorerDriver(capabilities);
			}
		},

		BROWSER_STACK(30, "BrowserStack") {
			WebDriver start() {
				DesiredCapabilities capabilities = browserStackCaps;
				try {
					return new RemoteWebDriver(new URL(BrowserStackConnectionUrl.getURL()), capabilities);
				} catch (MalformedURLException e) {
					System.out.println(ERROR_BROWSER_STACK_CONNECTION_URL);
					// logger.error(ERROR_BROWSER_STACK_CONNECTION_URL +
					// e.getStackTrace().toString());

					// TODO Develop My Exception
					throw new RuntimeException(ERROR_BROWSER_STACK_CONNECTION_URL);
				}
			}
		};

		// private static String APP_UPDATE_ENABLED = "app.update.enabled";
		private static String ERROR_BROWSER_STACK_CONNECTION_URL = "Error: BrowserStack connection url";
		private static String firefoxDefaultProfile = "defaultProfile";
		private long implicitlyWaitTimeout;
		private String name;

		/**
		 * Constructor for Browsers Enumeration instance
		 * 
		 * @param implicitlyWaitTimeout
		 * @param name
		 */
		private Browsers(long implicitlyWaitTimeout, String name) {
			this.implicitlyWaitTimeout = implicitlyWaitTimeout;
			this.name = name;
		}

		/**
		 * get Browser's instance implicitly wait timeout.
		 * 
		 * @return implicitlyWaitTimeout
		 */
		public long getImplicitlyWaitTimeout() {
			return implicitlyWaitTimeout;
		}

		/**
		 * get Browser's instance name.
		 * 
		 * @return name
		 */
		public String getName() {
			return name;
		}

		/**
		 * abstract method for creation Browser's instance with some additional
		 * params of driver's options.
		 * 
		 * @return WebDriver's instance
		 */
		abstract WebDriver start();

		@Override
		public String toString() {
			return name;
		}
	}

	private final String ERROR_TAKE_SCREENSHOT = "Take Screenshot. I/O Error";
	// private static Logger logger = LoggerFactory
	// .getLogger(WebDriverUtils.class);
	private volatile static WebDriverUtils instanse = null;
	private static Browsers runBrowser = null;
	private static DesiredCapabilities browserStackCaps;
	private WebDriver driver;
	private final long IMPLICITLY_WAIT_TIMEOUT = 20;

	private WebDriverUtils() {
	}

	/**
	 * A static factory for creation WebDriverUtils class without additional
	 * parameters.
	 * 
	 * @return instance of WebDriverUtils class
	 */
	public static WebDriverUtils get() {
		if (instanse == null) {
			synchronized (WebDriverUtils.class) {
				if (instanse == null) {
					instanse = new WebDriverUtils();
				}
			}
		}
		return instanse;
	}

	/**
	 * A static factory for creation WebDriverUtils class based on setted
	 * browser.
	 * 
	 * @param browser
	 *            from Browsers enum.
	 * @return instance of WebDriverUtils class
	 */
	public static WebDriverUtils get(Browsers browser) {
		if (instanse == null) {
			synchronized (WebDriverUtils.class) {
				if (instanse == null) {
					instanse = new WebDriverUtils();
					runBrowser = browser;
				}
			}
		}
		return instanse;
	}

	/**
	 * A static factory for creation WebDriverUtils class based on BrowserStack
	 * connection managed by Desired Capabilities.
	 * 
	 * @param browserStack
	 *            desired capabilities
	 * @return instance of WebDriverUtils class
	 */
	public static WebDriverUtils get(DesiredCapabilities capabilities) {
		if (instanse == null) {
			synchronized (WebDriverUtils.class) {
				if (instanse == null) {
					instanse = new WebDriverUtils();
					browserStackCaps = capabilities;
					runBrowser = Browsers.BROWSER_STACK;
				}
			}
		}
		return instanse;
	}

	/**
	 * Getter of Selenium's WebDriver to get access for work with browsers
	 * 
	 * @return WebDriver's driver
	 */
	WebDriver getWebDriver() {
		if (driver == null) {
			synchronized (WebDriverUtils.class) {
				if (driver == null) {
					if (runBrowser == null) {
						runBrowser = Browsers.FIREFOX;
					}
					driver = runBrowser.start();
					driver.manage().timeouts().implicitlyWait(getImplicitlyWaitTimeout(), TimeUnit.SECONDS);
					driver.manage().window().maximize();
				}
			}
		}
		return driver;
	}

	/**
	 * Set url to browser's address line. Wrapper of selenium's:
	 * <code>driver.get(url);</code>
	 * 
	 * @param url
	 *            address
	 */
	public void goToUrl(String url) {
		getWebDriver().get(url);
	}

	/**
	 * Refers to previous page in Browser's History. Wrapper of selenium's:
	 * <code>driver.navigate().back();</code>
	 */
	public void goToPreviousPage() {
		getWebDriver().navigate().back();
	}

	/**
	 * Refers to Next page in Browser's History. Wrapper of selenium's:
	 * <code>driver.navigate().forward();</code>
	 */
	public void goToForvardPage() {
		getWebDriver().navigate().forward();
	}

	/**
	 * Retresh page. Wrapper of selenium's:
	 * <code>driver.navigate().refresh();</code>
	 */
	public void refreshPage() {
		getWebDriver().navigate().refresh();
	}

	/**
	 * Get url from browser's address line. Wrapper of selenium's:
	 * <code>driver.getCurrentUrl();</code>
	 * 
	 * @return url address
	 */
	public String getCurrentUrl() {
		return getWebDriver().getCurrentUrl();
	}

	/**
	 * Get page title. Wrapper of selenium's: <code>driver.getTitle();</code>
	 * 
	 * @return title
	 */
	public String getTitle() {
		return getWebDriver().getTitle();
	}

	/**
	 * Get source code of page. Wrapper of selenium's:
	 * <code>driver.getPageSource();</code>
	 * 
	 * @return source code of page
	 */
	public String getPageSource() {
		return getWebDriver().getPageSource();
	}

	/**
	 * Save screenshot of web page.
	 * 
	 * @param filePath
	 *            - file location path
	 * @param fileName
	 *            - name of screenshot
	 */
	public void getScreenshot(String filePath, String fileName) {
		try {
			File srcFile = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(filePath + "\\" + fileName));
		} catch (Exception e) {
			// e.printStackTrace();
			// logger.error(ERROR_TAKE_SCREENSHOT +
			// e.getStackTrace().toString());
			// TODO Develop My Exception
			throw new RuntimeException(ERROR_TAKE_SCREENSHOT);
		}
	}

	/**
	 * Close driver, and remove WebDriverUtils instance and used browser type.
	 */
	public void quit() {
		getWebDriver().quit();
		instanse = null;
		runBrowser = null;
	}

	/**
	 * Getter of value of implicitly wait timeout
	 * 
	 * @return value of implicitly wait timeout in MILLISECONDS
	 */
	long getImplicitlyWaitTimeout() {
		return IMPLICITLY_WAIT_TIMEOUT;
	}

	/**
	 * Getter of value of BrowserSteck desired capabilities settings
	 * 
	 * @return BrowserSteck desired capabilities
	 */
	DesiredCapabilities getCapabilities() {
		return browserStackCaps;
	}
}