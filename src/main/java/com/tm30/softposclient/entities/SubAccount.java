package com.tm30.softposclient.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tm30.softposclient.entities.users.Acquirer;
import com.tm30.softposclient.entities.users.BaseUser;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SubAccount extends BaseUser {


//	private SubRole role;
	@ManyToOne
	@JsonBackReference
	private Acquirer acquirer;
	private boolean active;
}
