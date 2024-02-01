package com.tm30.softposclient.model.payload;

/**
 * An interface to identify a request information.
 * @param <T> request body type
 * @author Adebayo .A. Okutubo
 */
public interface Request<T> {
	String getTimestamp();
	String getRequestId();
	String getType();
	T getBody();
}
