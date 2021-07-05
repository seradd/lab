package com.lab.hometask.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UtilOperation {

	public static boolean stringIsEmpty(String s) {
		return s == null || s.trim().length() == 0;
	}

	public static boolean longIsNull(Long l) {
		return l == null || l.equals(0L);
	}

}


