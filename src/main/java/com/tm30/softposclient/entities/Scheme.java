package com.tm30.softposclient.entities;

import lombok.Getter;

@Getter
public enum Scheme {
	MASTER(51, 59), VISA(4,4),
	VERVE(506, 507), OTHERS(0,0);

	final int min;
	final int max;

	Scheme(int min, int max) {
		this.min = min;
		this.max = max;
	}

}
