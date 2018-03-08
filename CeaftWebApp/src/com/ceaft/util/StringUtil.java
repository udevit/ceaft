package com.ceaft.util;

/**
 * 
 * @author Gary
 *
 */
public final class StringUtil {
	
	/**
	 * Default private constructor
	 */
	private StringUtil() {

	}

	/**
	 * 
	 * @param data
	 * @return
	 */
	public static boolean isEmpty(String data) {
		return data == null || data.isEmpty();
	}

}
