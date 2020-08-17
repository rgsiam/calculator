package com.home.tools.calculator.utils;

public final class Helper {
	private Helper(){
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
