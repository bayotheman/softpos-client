package com.tm30.softposclient.entities;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Embeddable
@Setter
@Getter
public class InstitutionBin {
	private String name;
	private String code;
	private String processorFactoryId;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof InstitutionBin that)) return false;
		return Objects.equals(code, that.code);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}
}
