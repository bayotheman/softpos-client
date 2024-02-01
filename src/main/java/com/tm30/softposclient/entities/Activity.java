package com.tm30.softposclient.entities;


import com.tm30.softposclient.entities.users.AuditableEntity;
import com.tm30.softposclient.utils.ULIDUtil;
import com.tm30.softposclient.entities.users.BaseUser;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Activity extends AuditableEntity<BaseUser> {

	@Id
	private String id = ULIDUtil.nextValue();
	private String detail;

}
