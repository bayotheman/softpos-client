package com.tm30.softposclient.model.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder()
public class ResponseImpl<T> implements Response<T>{
	private boolean successful;
	private String message;
	private T data;

	private ResponseImpl(){}

	public static <T> ResponseImpl<T> create(boolean status, T data){
		ResponseImpl<T> response = new ResponseImpl<>();
		response.setSuccessful(status);
		response.setData(data);
		return response;
	}

	public static <T> ResponseImpl<T> create(){
		return new ResponseImpl<>();
	}

	public static <T> ResponseImpl<T> create(boolean status, String message){
		ResponseImpl<T> response = new ResponseImpl<>();
		response.setSuccessful(status);
		response.setMessage(message);
		return response;
	}
	public static <T> ResponseImpl<T> create(boolean status, T data, String message){
		ResponseImpl<T> response = new ResponseImpl<>();
		response.setSuccessful(status);
		response.setData(data);
		response.setMessage(message);
		return response;
	}

}
