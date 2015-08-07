package com.git.capie.TestingFramework.controls;

import java.util.ArrayList;
import java.util.List;

import com.git.capie.TestingFramework.tools.LocationOfWebElement;
import com.git.capie.TestingFramework.tools.VisibilityOfWebElement;
import com.git.capie.TestingFramework.tools.WrapperOfWebElement;

public class ListOfElements implements IListOfElements {

	private LocationOfWebElement locationOfWebElement;
	private List<WrapperOfWebElement> listOfWebElements;

	private ListOfElements(LocationOfWebElement locationOfWebElement) {
		this.locationOfWebElement = locationOfWebElement;
		this.listOfWebElements = VisibilityOfWebElement.get()
				.getListOfWebElements(locationOfWebElement);

	}

	public static IListOfElements byName(String name) {
		return get(LocationOfWebElement.getLocationByName(name));
	}

	public static IListOfElements byXpath(String xpathExpression) {
		return get(LocationOfWebElement.getLocationByXPath(xpathExpression));
	}

	public static IListOfElements byCssSelector(String selector) {
		return get(LocationOfWebElement.getLocationByCssSelector(selector));
	}

	public static IListOfElements byTagName(String tagName) {
		return get(LocationOfWebElement.getLocationByTag(tagName));
	}

	private static IListOfElements get(
			LocationOfWebElement locationOfWebElement) {
		return new ListOfElements(locationOfWebElement);
	}

	public List<IControl> getListOfElements() {
		List<IControl> listOfElements = new ArrayList<IControl>();
		for (WrapperOfWebElement wrapperOfWebElement : listOfWebElements) {
			listOfElements.add(Control.get(wrapperOfWebElement));
		}
		return listOfElements;
	}
	
	public IControl getElement(int number) {
		return Control.get(listOfWebElements.get(number));
	}

	public List<IControl> getListOfElementsWithAttribute(String attribute) {
		String attributeValue;
		List<IControl> listOfElements = new ArrayList<IControl>();
		for (WrapperOfWebElement wrapperOfWebElement : listOfWebElements) {
			attributeValue = wrapperOfWebElement.getAttribute(attribute);
			if ((attributeValue!=null)|(!attributeValue.isEmpty())) {
				listOfElements.add(Control.get(wrapperOfWebElement));
			}
		}
		return listOfElements;
	}
	
	public List<IControl> getListOfElementsWithPartialText(String partialText) {
		String textValue;
		List<IControl> listOfElements = new ArrayList<IControl>();
		for (WrapperOfWebElement wrapperOfWebElement : listOfWebElements) {
			textValue = wrapperOfWebElement.getText();
			if (textValue.contains(partialText)) {
				listOfElements.add(Control.get(wrapperOfWebElement));
			}
		}
		return listOfElements;
	}

	public List<IControl> getListOfDisplayedElements() {
		List<IControl> listOfElements = new ArrayList<IControl>();
		for (WrapperOfWebElement wrapperOfWebElement : listOfWebElements) {
			if (wrapperOfWebElement.isDisplayed()) {
				listOfElements.add(Control.get(wrapperOfWebElement));
			}
		}
		return listOfElements;
	}

	public int getCountOfElements() {
		return listOfWebElements.size();
	}

	public LocationOfWebElement getLocation() {
		return locationOfWebElement;
	}
}
