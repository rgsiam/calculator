package com.home.tools.calculator.utils;

/**
 * Utility class to help with basic checks
 * @since 1.0
 */
public final class HelperUtil {
	private HelperUtil(){
		/** Utility class */
	}

	/**
	 * Throws {@link IllegalArgumentException} with the supplied message
	 * @param message Message to used in the Exception
	 */
	public static void raiseException(String message) {
		throw new IllegalArgumentException(message);
	}

	/**
	 * Checks if supplied string in Numeric
	 * @param number String Input to check
	 * @return  Returns <pre>true</pre> if Input is Numeric else <pre>false</pre>
	 */
	public static boolean isNumeric(String number) {
		try {
			Double.parseDouble(number);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
