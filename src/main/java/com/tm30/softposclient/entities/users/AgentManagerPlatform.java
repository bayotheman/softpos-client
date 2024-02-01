package com.tm30.softposclient.entities.users;

import com.tm30.softposclient.utils.ULIDUtil;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Setter
@Getter
public class AgentManagerPlatform
//		extends AuditableEntity<BaseUser>
{

	@Id
	private final String id = ULIDUtil.nextValue();
	private String name;
	private String accessKey;
	private boolean active;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	private Acquirer acquirer;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> ipWhitelist = new ArrayList<>();

}
