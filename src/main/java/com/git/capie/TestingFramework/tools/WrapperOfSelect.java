package com.git.capie.TestingFramework.tools;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WrapperOfSelect {
	private static String ELEMENT_NOT_FOUND = "Select Element With Partial text: %s, not found";
	Select selectWebElement;

	private WrapperOfSelect(Select selectWebElement) {
		this.selectWebElement = selectWebElement;
	}

	public static WrapperOfSelect get(Select selectWebElement) {
		return new WrapperOfSelect(selectWebElement);
	}

	public static WrapperOfSelect getVisibleSelect(
			LocationOfWebElement locationOfWebElement) {
		return new WrapperOfSelect(VisibilityOfWebElement.get()
				.getVisibleSelect(locationOfWebElement));
	}

	public static WrapperOfSelect getPresentSelect(
			LocationOfWebElement locationOfWebElement) {
		return new WrapperOfSelect(VisibilityOfWebElement.get()
				.getPresentSelect(locationOfWebElement));
	}
	
	public static WrapperOfSelect getPosibleUexistedSelect(
			LocationOfWebElement locationOfWebElement) {
		return new WrapperOfSelect(VisibilityOfWebElement.get()
				.getPosibleUexistedSelect(locationOfWebElement));
	}
	
	
	Select getSelect() {
		return selectWebElement;
	}
	
	public WrapperOfWebElement getSelectedElement(){
		return WrapperOfWebElement.get(selectWebElement.getFirstSelectedOption());
	}

	public List<WrapperOfWebElement> getSelectWebElements() {
		List<WrapperOfWebElement> selectWebElements = new ArrayList<WrapperOfWebElement>();
		for (WebElement webElement : selectWebElement.getAllSelectedOptions()) {
			selectWebElements.add(WrapperOfWebElement.get(webElement));
		}
		return selectWebElements;
	}

	public void selectByIndex(int index) {
		selectWebElement.selectByIndex(index);
	}

	public void selectByText(String text) {
		selectWebElement.selectByValue(text);
	}

	public void selectByPartialText(String partialText) {
		boolean isTextNotFound = true;
		for (WrapperOfWebElement webElement : getSelectWebElements()) {
			if (webElement.getText().contains(partialText)) {
				isTextNotFound = false;
				webElement.click();
			}
		}
		if (isTextNotFound) {
			if (isTextNotFound) {
				// TODO Develop Logs & My Exception
				throw new RuntimeException(String.format(ELEMENT_NOT_FOUND,
						partialText));
			}
		}
	}
}
