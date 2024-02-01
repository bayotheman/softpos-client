package com.tm30.softposclient.entities.configvalues;

import lombok.Getter;

import java.util.function.Supplier;


@Getter
public enum RoutingParam {
	BIN(CardBin::new, 2),
	AMOUNT(ConfigAmount::new, 4),
	DATE_TIME(ConfigDateTime::new, 13, 12),
	SCHEME(Scheme::new);

	private final Supplier<ConfigValue> newInstance;
	private final int[] fieldNos;

	RoutingParam(Supplier<ConfigValue> newInstance, int... fieldNos) {
		this.newInstance = newInstance;
		this.fieldNos = fieldNos;
	}

}
