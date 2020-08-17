package com.home.tools.calculator.utils;

/**
 * Utility class to help with basic checks
 * @since 1.0
 */
public final class HelperUtil {
	private HelperUtil(){
		//Do nothing
	}
	public static void raiseException(String message) {
		throw new IllegalArgumentException(message);
	}
	
	public static boolean isNumeric(String num) {
		try {
			Double.parseDouble(num);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
