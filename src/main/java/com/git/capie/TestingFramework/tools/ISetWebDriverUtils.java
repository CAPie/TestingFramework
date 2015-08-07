package com.git.capie.TestingFramework.tools;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.git.capie.TestingFramework.tools.WebDriverUtils.Browsers;

public interface ISetWebDriverUtils {
	void setRemoteCapability(DesiredCapabilities setCapabilities);

	void setBrowser(Browsers browser);
}
