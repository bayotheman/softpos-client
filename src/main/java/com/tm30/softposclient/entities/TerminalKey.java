package com.tm30.softposclient.entities;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class TerminalKey {

	private String pinKey;
	private String masterKey;
	private String sessionKey;

}
