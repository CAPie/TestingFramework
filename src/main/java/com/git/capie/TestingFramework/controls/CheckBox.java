package com.git.capie.TestingFramework.controls;

import com.git.capie.TestingFramework.tools.LocationOfWebElement;
import com.git.capie.TestingFramework.tools.WrapperOfWebElement;

public class CheckBox implements ICheckBox{
	private WrapperOfWebElement wrapperOfWebElement;
	private LocationOfWebElement locationOfWebElement;
	
	private CheckBox(WrapperOfWebElement wrapperOfWebElement, LocationOfWebElement locationOfWebElement){
		this.wrapperOfWebElement=wrapperOfWebElement;
		this.locationOfWebElement=locationOfWebElement;
	}
	
	public static ICheckBox getById(String id) {
		return get(LocationOfWebElement.getLocationById(id));
	}

	public static ICheckBox getByName(String name) {
		return get(LocationOfWebElement.getLocationByName(name));
	}

	public static ICheckBox getByPartialLinkText(String linkText) {
		return get(LocationOfWebElement.getLocationByPartialLinkText(linkText));
	}

	public static ICheckBox getByXpath(String xpathExpression) {
		return get(LocationOfWebElement.getLocationByXPath(xpathExpression));
	}

	public static ICheckBox getByCssSelector(String selector) {
		return get(LocationOfWebElement.getLocationByCssSelector(selector));
	}

	private static ICheckBox get(LocationOfWebElement locationOfWebElement) {
		return new CheckBox(
				WrapperOfWebElement.getVisibleWebElement(locationOfWebElement),
				locationOfWebElement);
	}

	public String getAttribute(String attribute) {
		return wrapperOfWebElement.getAttribute(attribute);
	}

	public String getName() {
		return wrapperOfWebElement.getName();
	}

	public boolean isChecked(){
		return wrapperOfWebElement.isSelectet(); 
	}
	
	public void check() {
		if(!isChecked()){
			wrapperOfWebElement.click();
		}
	}

	public void uncheck() {
		if(isChecked()){
			wrapperOfWebElement.click();
		}
	}

	public void submit() {
		wrapperOfWebElement.submit();
	}

	public boolean isDisplayed() {
		return wrapperOfWebElement.isDisplayed();
	}

	public boolean isEnabled() {
		return wrapperOfWebElement.isEnabled();
	}
	
	public WrapperOfWebElement getWrapperOfWebElement(){
		return wrapperOfWebElement;
	}
	
	public LocationOfWebElement getLocationOfWebElement(){
		return locationOfWebElement;
	}
}
