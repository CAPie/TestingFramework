package com.git.capie.TestingFramework.tools;

import org.openqa.selenium.By;

public final class LocationOfWebElement {

	private String valueOfLocator;
	private By by;
	
	private LocationOfWebElement(By by, String valueOfLocator) {
		this.by = by;
		this.valueOfLocator = valueOfLocator;
	}
	
	/**
	 * Static Factory for WebElement's Location 
	 */
	public static LocationOfWebElement getLocationById(String id){
		return new LocationOfWebElement(new By.ById(id), id);
	}
	
	public static LocationOfWebElement getLocationByName(String name){
		return new LocationOfWebElement(new By.ByName(name), name);
	}
	
	public static LocationOfWebElement getLocationByPartialLinkText(String linkText){
		return new LocationOfWebElement(new By.ByPartialLinkText(linkText), linkText);
	}
	
	public static LocationOfWebElement getLocationByCssSelector(String selector){
		return new LocationOfWebElement(new By.ByCssSelector(selector), selector);
	}
	
	public static LocationOfWebElement getLocationByXPath(String xpathExpression){
		return new LocationOfWebElement(new By.ByXPath(xpathExpression), xpathExpression);
	}
	
	public static LocationOfWebElement getLocationByTag(String tagName){
		return new LocationOfWebElement(new By.ByTagName(tagName), tagName);
	}
	
	public By getLocatorBy(){
		return by;
	}
	
	public String getValueOfLocator(){
		return valueOfLocator;
	}
}
