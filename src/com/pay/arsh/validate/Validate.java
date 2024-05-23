package com.pay.arsh.validate;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pay.arsh.bean.User;

public class Validate {
	private static Matcher matcher;
	private static Pattern pattern;
	// Email Pattern
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	 
	public static boolean checkLength(int length, String text, boolean equalLength) {
		if (equalLength) {
			if (text.length() == length && text != null) {
				return true;
			} else {
				return false;
			}
		} else {
			if (text.length() > length && text != null) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * Check Valid Email Method
	 */
	public static boolean validateEmail(String email) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}

	/**
	 * Verify pin Method
	 */
	public static boolean verifyPin(int pin, User user) {
		if (pin == user.getAccountPin()) {
			return true;
		} else {
			return false;
		}
	}

	
	public static boolean isNotNull(String txt) {
		return txt != null && txt.trim().length() > 0 ? true : false;
	}

	// validating password with retype password
	public static boolean validatePassword(String pass) {
		return pass != null && pass.length() > 3 ? true : false;
	}
	

	public static boolean haveSpace(String userName) {

		boolean checkSpace = false;
		int f = 0;
		for (int i = 0; i < userName.length(); i++) {
			if (userName.contains(" ")) {
				f = 1;
				checkSpace = true;
			}
		}
		if (f == 1) {
			return checkSpace;

		} else {
			return checkSpace;
		}

	}
	/**
	 * verify mobile
	 */

	public static boolean validateMaxMobile(String mobile) {
		return mobile != null && mobile.length() > 10 ? true : false;
	}

	public static boolean validateMinMobile(String mobile) {
		return mobile != null && mobile.length() < 10 ? true : false;
	}
	
	
	

}