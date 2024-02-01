package com.tm30.softposclient.model.payload;

/**
 * Response body specification.
 * @param <T> response body type.
 */
public interface Response<T> {
	boolean isSuccessful();
	void setSuccessful(boolean value);
	String getMessage();
	void setMessage(String message);
	T getData();
	void setData(T data);
}
