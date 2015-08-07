package com.git.capie.TestingFramework.controls;

import com.git.capie.TestingFramework.enums.ElementVisibility;
import com.git.capie.TestingFramework.tools.LocationOfWebElement;
import com.git.capie.TestingFramework.tools.WrapperOfSelect;

public class DropDownList implements IDropDownList {
	WrapperOfSelect select;

	private DropDownList(WrapperOfSelect select) {
		this.select = select;
	}

	public static IDropDownList getById(ElementVisibility visibility, String id) {
		return get(visibility, LocationOfWebElement.getLocationById(id));
	}

	public static IDropDownList getByName(ElementVisibility visibility,
			String name) {
		return get(visibility, LocationOfWebElement.getLocationByName(name));
	}

	public static IDropDownList getByXpath(ElementVisibility visibility,
			String xpathExpression) {
		return get(visibility,
				LocationOfWebElement.getLocationByXPath(xpathExpression));
	}

	public static IDropDownList getByCssSelector(ElementVisibility visibility,
			String selector) {
		return get(visibility,
				LocationOfWebElement.getLocationByCssSelector(selector));
	}

	private static IDropDownList get(ElementVisibility visibility,
			LocationOfWebElement locationOfWebElement) {
		if (visibility == ElementVisibility.VISIBLE) {
			return new DropDownList(
					WrapperOfSelect.getVisibleSelect(locationOfWebElement));
		}
		if (visibility == ElementVisibility.PRESENT) {
			return new DropDownList(
					WrapperOfSelect.getPresentSelect(locationOfWebElement));
		} else {
			IDropDownList dropDownList =  new DropDownList(
					WrapperOfSelect
							.getPosibleUexistedSelect(locationOfWebElement));
            if(dropDownList == null){
                dropDownList = VoidControlStub.get().toIDropDownList();
            }
            return dropDownList;
		}

	}

	public void selectByIndex(int index) {
		select.selectByIndex(index);
	}

	public void selectByText(String text) {
		select.selectByText(text);
	}

	public void selectByPartialText(String partialText) {
		select.selectByPartialText(partialText);
	}

	public IControl getSelectedElement() {
		return Control.get(select.getSelectedElement());
	}

	public WrapperOfSelect getSelect() {
		return select;
	}
}
