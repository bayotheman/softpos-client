package com.tm30.softposclient.entities.configvalues;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor 
//@EqualsAndHashCode(callSuper=false)
public class ConfigAmount extends ConfigValue {
	
	private BigDecimal min;
	private BigDecimal max;


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ConfigAmount amount)) return false;
		if (!super.equals(o)) return false;
		return Objects.equals(min, amount.min) && Objects.equals(max, amount.max);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode());
	}
}
