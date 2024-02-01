package com.tm30.softposclient.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.Date;

@Embeddable
@Data
public class TerminalKeySet {

	private String masterKey;
	
	private String pinKey;
	
	private String sessionKey;
	
	private String encryptionType;
	
	private String keyType;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date lastChange;

	private String alternateKey;
	
	private String keySpecification;
	
	private   String terminalId;
	
}
