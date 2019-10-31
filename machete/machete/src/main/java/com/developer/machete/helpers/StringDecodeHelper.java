package com.developer.machete.helpers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/*
 * The purpose of this class is to debug the inability of axios to make the proper POST request
 * Making a GET with the data is not appropriate and is not a safe way of doing things.
 * Instead, we are still making a POST request and converting the data to a JSON string from URL format
 * For more details about the issue, see: https://github.com/axios/axios/issues/86
 */

public class StringDecodeHelper {
	public String decode(String data) {
		try {
			data = URLDecoder.decode(data, StandardCharsets.UTF_8.toString());
			if (data.endsWith("=")) {
				data = data.substring(0, data.length() - 1);
			}
		} catch (UnsupportedEncodingException e) {
			// log4j should be implemented here
		}
		return data;
	}
}
