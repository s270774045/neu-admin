package com.noisyle.crowbar.core.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JSONUtils {
	/**
	 * 转换为json字符串
	 */
	public static String toJSON(Object obj) {
		ObjectMapper om = new ObjectMapper();
		String resultStr = "";
		try {
			resultStr = om.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return resultStr;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T fromJSON(String str, Class clazz) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return (T) mapper.readValue(str, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
