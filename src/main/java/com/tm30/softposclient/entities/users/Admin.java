package com.tm30.softposclient.entities.users;

import com.tm30.softposclient.entities.Role;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Admin extends BaseUser{
	public Admin(){
		setRole(Role.ADMIN);
	}
}
