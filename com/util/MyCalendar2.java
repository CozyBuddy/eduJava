package com.util;

public class MyCalendar2 {
	public static boolean isleanyear(int year) {
		if (year%4==0 && year!=100 || year%400==0) {
			return true;
			
		} else {
			return false;

		}
		
	}

}
