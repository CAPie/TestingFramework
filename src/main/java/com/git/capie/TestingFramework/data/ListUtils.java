package com.git.capie.TestingFramework.data;

import java.util.List;

public class ListUtils {
	private ListUtils(){}
	
	public static Object[][] listToArray(List<?> list){
		Object[][] array = new Object[list.size()][1];
		for (int i=0; i<list.size(); i++){
			array[i][0] = list.get(i);
		}
		return array;
	}
}
