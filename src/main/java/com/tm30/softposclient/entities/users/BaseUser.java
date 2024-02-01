package com.tm30.softposclient.entities.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tm30.softposclient.entities.Role;
import com.tm30.softposclient.utils.ULIDUtil;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class BaseUser
//		extends AuditableEntity<BaseUser>
{
	@Id
	private String id = ULIDUtil.nextValue();

	private String name;
	@Column(unique = true)
	private String email;
	@JsonIgnore
	private String password;
//	@JsonIgnore
//	private String defaultPassword;
	private String address;
	private boolean active;


	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> previousPasswords = new HashSet<>();

	@Enumerated(EnumType.STRING)
	private Role role;


}
