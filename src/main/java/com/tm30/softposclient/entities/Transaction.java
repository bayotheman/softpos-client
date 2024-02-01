package com.tm30.softposclient.entities;

import com.tm30.softposclient.utils.ULIDUtil;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Transaction {
	@Id
	private String id = ULIDUtil.nextValue();
	private String reference;
	private String acquirerId;
	private String merchantId;
//	private String terminalId;
	@ManyToOne
	private Terminal terminal;

	private String type;
	private String stan;
	private String responseCode;
	private String authorizationIdResponse;
	private String transmissionDateTime;
	private String timeCompleted;
	private String acquiringInstitutionCode;
	private String processingInstitutionCode;
	private String retrievalReferenceNumber;
	private String cardSequenceNumber;
	private String maskedPan;
	private String posEntryMode;
	private String merchantType;

	//	@Enumerated(EnumType.STRING)
	private String status;

	private String amount;
	private String currency;
	private String metadata;

	@Embedded
	private VasTransaction vas;

//	@Enumerated(EnumType.STRING)
//	private TransactionType transactionType;



}
