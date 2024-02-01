package com.tm30.softposclient.entities;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class VasTransaction {
	private String phoneNumber;
//	private String type;
	private String planId;
	private String servicePurchaseAmount;

}
