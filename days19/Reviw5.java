package days19;

import java.time.DayOfWeek;
import java.util.Date;
import java.util.Scanner;

public class Reviw5 {
	public static void main(String[] args) {
		int year = 2023;
		int month =8;
		System.out.printf("%d.%02d\n",year,month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		Date d = new Date(year-1900,month-1,1);
		int a =DayOfWeek(year,month);
		d.setDate(d.getDate()-a);
		try {
			for (int i = 0; i < 35; i++) {
				System.out.print(d.getDate()+"\t");
				d.setDate(d.getDate()+1);
				if (i%7==6) {
					System.out.println();
				} 
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static int DayOfWeek(int year, int month) {
		Date d = new Date(year-1900,month-1,1);
		d.getDay();
		return d.getDay();
		
	}

}
