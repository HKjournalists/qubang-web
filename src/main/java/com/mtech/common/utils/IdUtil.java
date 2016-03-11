package com.mtech.common.utils;

import java.util.UUID;

public class IdUtil {

	public static String getUUId(){
		return UUID.randomUUID().toString();
	}
}
