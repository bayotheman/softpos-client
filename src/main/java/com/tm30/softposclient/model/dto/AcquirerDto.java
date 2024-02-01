package com.tm30.softposclient.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AcquirerDto {
	@NotEmpty(message = "name cannot be empty")
	private String name;
//	@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "invalid email format")
	private String email;
//	@Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#?~!$%^&+=])(?=\\S+$).{8,}$",
//			message ="Password must contain minimum of 8 characters in length including " +
//					"uppercase and lowercase letters, numbers and special characters. ")
	private String password;
	@NotEmpty
	private String address;
//	@NotEmpty
	private String vendorCode;
//	@NotEmpty
	private String code;
	private String description;
	@NotEmpty
	private String cbnId;


}
