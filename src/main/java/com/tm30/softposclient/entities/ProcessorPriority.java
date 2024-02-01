package com.tm30.softposclient.entities;

import lombok.Getter;

@Getter
public enum ProcessorPriority {
	PRIMARY(1), SECONDARY(2), OTHERS(3);

	private final int value;
	ProcessorPriority(int value) {
		this.value = value;
	}
}
