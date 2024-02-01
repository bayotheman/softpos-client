package com.tm30.softposclient.entities;


import com.tm30.softposclient.entities.configvalues.ConfigValue;
import com.tm30.softposclient.entities.configvalues.RoutingParam;
import com.tm30.softposclient.entities.users.Acquirer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoutingConfiguration {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private boolean enabled;
	@Enumerated(EnumType.STRING)
	private RoutingParam paramType;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<ConfigValue> values = new HashSet<>();
	
	@ManyToOne(fetch= FetchType.EAGER)
	private Acquirer acquirer;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RoutingConfiguration that)) return false;
		return id.equals(that.id);
	}

//	public void addConfigValue(ConfigValue value){
//		values.add(value);
//	}
//
//	public void removeConfigValue(ConfigValue value){
//		values.remove(value);
//	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
