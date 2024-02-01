package com.tm30.softposclient.model.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MerchantDto {
	private String name;
//	private String cbnMerchantId;
	private String code;
	private String countryCode;
	private String address;
	private String acquirerId;
}
