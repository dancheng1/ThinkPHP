package com.ky.workover.common.log.basic;

import java.util.Random;

public class RandomUtils {

	public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static final String numberChar = "0123456789";

	public static String generateString(int length) {

		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(allChar.charAt(random.nextInt(allChar.length())));
		}
		return sb.toString();

	}

	public static String generateMixString(int length) {

		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(allChar.charAt(random.nextInt(letterChar.length())));
		}
		return sb.toString();

	}
	

	public static String generateLowerString(int length) {
		return generateMixString(length).toLowerCase();
	}

	
	public static String generateUpperString(int length) {
		return generateMixString(length).toUpperCase();
	}
	
	
	

	public static void main(String[] args) {

		System.out.println(generateString(26));

//		System.out.println(generateMixString(18));
//
//		System.out.println(generateLowerString(20));
//
//		System.out.println(generateUpperString(10));

	}

}
