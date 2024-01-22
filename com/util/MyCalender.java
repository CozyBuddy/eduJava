package com.util;

public class MyCalender {
	public static boolean isLeapYear( int year) {
		boolean result = false;
		if (year%4==0 && year%100!=0 || year%400==0) {
			return true;
		}
				return result;

			}
		}
	

	/*public static String isLeapYear( int year) {
		String result = "평년";
		if (year%4==0 && year%100!=0 || year%400==0) {
			return "윤년";
		}
				return result;

			}
		}
	*/


		



