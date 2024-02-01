package com.tm30.softposclient.model.payload;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Password {

	@Data
	public static class Forgot{
		private String password;
		private String retypePassword;
	}

	@Data
	public static class Change{
		private String oldPassword;
		private String newPassword;
	}

}