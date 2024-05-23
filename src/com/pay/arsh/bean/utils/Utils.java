package com.pay.arsh.bean.utils;




import java.sql.Timestamp;
import java.util.Random;

public class Utils {
	

	/**
	 * Generate 11 Digit Random Number
	 */
	public static String generateAcNum() {
		//UUID randomUUID = UUID.randomUUID();	
		Random rnd = new Random();
		int part1 = rnd.nextInt(654321);
		int part2 = rnd.nextInt(99999);
		return String.valueOf(part1 + "" + part2);
	}
	
	
	/**
	 * get Timestamp method
	 */
	public static String getTimestamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return String.valueOf(timestamp);
	}


}
