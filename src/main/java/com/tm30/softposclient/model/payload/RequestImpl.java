package com.tm30.softposclient.model.payload;

import lombok.Data;

/**
 * An implementation of the Request interface specification.
 * @author Adebayo .A. Okutubo
 */
@Data
public class RequestImpl<T> implements Request<T>{
	private String requestId;
	private String timestamp;
	private String type;
	private T body;

}
