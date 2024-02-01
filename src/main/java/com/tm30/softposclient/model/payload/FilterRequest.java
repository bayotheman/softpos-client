package com.tm30.softposclient.model.payload;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * A Filter
 * @author Adebayo .A. Okutubo
 */
@Data
public class FilterRequest {
	private String merchantId;
	private String reference;
	private String institutionCode;
	private String terminalId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private int page = 0;
	private int size = 10;
}
