package com.git.capie.TestingFramework.tools;

import com.git.capie.TestingFramework.tools.WebDriverUtils.Browsers;

public interface ISetWebDriverUtils {
	void setRemoteÑapability(String capabilityName, String value);

	void setBrowser(Browsers browser);
}
