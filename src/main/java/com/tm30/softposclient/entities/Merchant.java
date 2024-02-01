package com.tm30.softposclient.entities;

import com.tm30.softposclient.utils.ULIDUtil;
import com.tm30.softposclient.entities.users.Acquirer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
public class Merchant
//		extends AuditableEntity<BaseUser>
{
	@Id
	private String id = ULIDUtil.nextValue();
	private String name;
	private String bvn;
	private String code;
	private String phone;
	@Column(unique = true)
	private String email;
	private String countryCode;
	private String address;
	private String type;
	private boolean active;


	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	private Acquirer acquirer;
	@OneToMany
	private Map<String,Terminal> terminals = new HashMap<>();

	public void addTerminal(String id, Terminal terminal){
		terminals.put(id, terminal);
	}

}
