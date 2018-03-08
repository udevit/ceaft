package com.ceaft.util;

public abstract class StringUtil {
	private StringUtil() {

	}

	public static boolean isEmpty(String data) {
		return data == null || data.isEmpty();
	}

}
