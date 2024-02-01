package com.tm30.softposclient.entities;

import com.tm30.softposclient.utils.ULIDUtil;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(indexes = @Index(name = "id_deviceId", columnList = "id, deviceId"))
public class Terminal
//		extends AuditableEntity<Merchant>
{
	@Id
	private String id = ULIDUtil.nextValue();
	private String serialNo;
	private String imei;
	private String modelNo;
	private String manufacturer;
	private String osVersion;
	private String appVersion;
	private String nfcId;
	private String deviceId;
	private TerminalType type;
	private boolean active;

	@Embedded
	private TerminalKeySet key = new TerminalKeySet();


	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	private Merchant merchant;

	public void setMasterKey(String key){
		this.key.setMasterKey(key);
	}


	public void setSessionKey(String key){
		this.key.setSessionKey(key);
	}

	public void setPinKey(String key){
		this.key.setPinKey(key);
	}

	public String getSessionKey(){
		return key.getSessionKey();
	}

	public String getPinKey(){
		return key.getPinKey();
	}

	public String getMasterKey(){
		return key.getMasterKey();
	}

	public void setKeySpecification(String pinKeySpec) {
		key.setKeySpecification(pinKeySpec);
	}

	public String getKeySpecification(){
		return key.getKeySpecification();
	}
}
