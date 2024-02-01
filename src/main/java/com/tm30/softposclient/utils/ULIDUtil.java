package com.tm30.softposclient.utils;

import de.huxhorn.sulky.ulid.ULID;

public final class ULIDUtil {
	private static final ULID ulid = new ULID();

	private ULIDUtil(){}

	public static String nextValue(){
		return ulid.nextULID();
	}
}
