package com.clay.utilitys;

import java.util.ArrayList;

public class StringUtility {

	public static String arrayToString(Object[] array_reference) {
		return arrayToString(array_reference, " ");
	}
	
	public static String arrayToString(Object[] array_reference, String seperator) {
		String result_string = "";
		
		if(array_reference == null) {
			return "";
		}
		
		for(int index = 0; index < array_reference.length; index++) {
			result_string += array_reference[index].toString();
			if(index < (array_reference.length - 1)) {
				result_string += seperator;
			}			
		}
		
		return result_string;
	}
    
	public static String listToString(ArrayList<String> list_reference) {
		return listToString(list_reference, " ");
	}
	
	public static String listToString(ArrayList<String> list_reference, String seperator) {
		String result_string = "";
		
		if(list_reference == null) {
			return "";
		}
		
		for(int index = 0; index < list_reference.size(); index++) {
			result_string += list_reference.get(index).toString();
			if(index < (list_reference.size() - 1)) {
				result_string += seperator;
			}			
		}
		
		return result_string;
	}

}
