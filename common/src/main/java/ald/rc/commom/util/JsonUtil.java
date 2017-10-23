package ald.rc.commom.util;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	private static ObjectMapper mapper = new ObjectMapper();

	public static <T> T parse(String value, Class<T> clazz) {
		if (StringUtils.isEmpty(value)) {
			return null;
		}
		try {
			return mapper.readValue(value, clazz);
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	
	public static String writeValueAsString(Object o){
		try {
			return mapper.writeValueAsString(o);
		} 
		catch (Exception e) {
			throw new IllegalStateException(e);
		} 
	}
}
