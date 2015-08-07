package com.git.capie.TestingFramework.controls;

import java.util.List;

public interface IListOfElements {
	public List<IControl> getListOfElements();

	public List<IControl> getListOfElementsWithAttribute(String attribute);

	public List<IControl> getListOfDisplayedElements();

	public int getCountOfElements();
}
