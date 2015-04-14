package com.git.capie.TestingFramework.tools;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WrapperOfSelect {
	private final String ELEMENT_NOT_FOUND = "Elemant with partial text: \"%s\", is not found.";
	private Select selectWebElement;

	private WrapperOfSelect(Select selectWebElement) {
		this.selectWebElement = selectWebElement;
	}

	public static WrapperOfSelect get(Select selectWebElement) {
		return new WrapperOfSelect(selectWebElement);
	}

	public static WrapperOfSelect getVisibleSelectWebElement(
			LocationOfWebElement locationOfWebElement) {
		return new WrapperOfSelect(VisibilityOfWebElement.get()
				.getVisibleSelect(locationOfWebElement));
	}
	
	Select getSelectWebElement(){
		return selectWebElement;
	}
	
	public List<WrapperOfWebElement> getSelectWebElements(){
		List<WrapperOfWebElement> selectWebElements = new ArrayList<WrapperOfWebElement>();
		for (WebElement webElement : getSelectWebElement().getOptions()) {
			selectWebElements.add(WrapperOfWebElement.get(webElement));
		}
		return selectWebElements;
	}
	
	public void selectByIndex(int index){
		getSelectWebElement().selectByIndex(index);
	}

	public void selectByValue(String value) {
		getSelectWebElement().selectByValue(value);
	}

	public void selectByText(String text) {
		getSelectWebElement().selectByVisibleText(text);
	}

	public void selectByPartialText(String partialText) {
		for (WrapperOfWebElement controlWrapper : getSelectWebElements()) {
			if (controlWrapper.getText().indexOf(partialText) >= 0) {
				controlWrapper.click();
				break;
			}
		}
		// TODO Develop My Exception
		throw new RuntimeException(
				String.format(ELEMENT_NOT_FOUND, partialText));
	}
}
