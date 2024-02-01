package com.tm30.softposclient.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <p>A utility class that provides functions for parsing Json string to a specific class object representation.</p>
 * @author Adebayo .A. Okutubo
 *
 */
public class JsonStringParserUtils {

	public static <R> R convertJsonStringToObjectType(String value, Class<R> valueType)
			throws JsonProcessingException {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper.readValue(value, valueType);

	}

	public static <R> R convertJsonStringToObjectType(String value, R valueType)
			throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper.readValue(value, (JavaType) valueType);
	}

}
