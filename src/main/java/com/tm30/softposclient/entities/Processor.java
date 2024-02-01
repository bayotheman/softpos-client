package com.tm30.softposclient.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tm30.softposclient.utils.ULIDUtil;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Entity
@Setter
@Getter
public class Processor
//		extends AuditableEntity<Admin>
{
	@Id
	private String id = ULIDUtil.nextValue();
	private String name;
	@JsonIgnore
	@Column(unique = true)
	private String factoryId;
	private String description;
	private boolean isEnabled;


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Processor processor)) return false;
		if (!super.equals(o)) return false;
		return Objects.equals(factoryId, processor.factoryId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), factoryId);
	}

	@Override
	public String toString() {
		return "Processor{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", factoryId='" + factoryId + '\'' +
				", description='" + description + '\'' +
				", isEnabled=" + isEnabled +
				'}';
	}
}
