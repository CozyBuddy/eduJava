package days10;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Review2 {
	public static void main(String[] args) {
		int a,b ;
		Scanner sc = new Scanner(System.in);
		System.out.print("년도를 입력하세요.>");
		a = sc.nextInt();
		System.out.print("월을 입력하세요.>");
		b = sc.nextInt();
		
		disCalendar(a,b);
	
		
	}

	private static int getDayofweek(int a, int b) {
		LocalDate d = LocalDate.of(a, b, 1); // 날짜 객체
		System.out.println(d.toString());
		
		return 0;
		
	}

	private static int getlastDay(int a, int b) {
		return 0;
		
	}

	private static void disCalendar(int year, int month) {
		System.out.println("\t\t"+year +"년 "+month+"월");
		System.out.println("*".repeat(60));
		System.out.print("일\t월\t화\t수\t목\t금\t토\t\n");
		System.out.println("*".repeat(60));
		for (int i = 0; i < dayofweek(year, month); i++) {
			System.out.print("\t");
			
		}
		for (int i = 1; i <= lastdays(year, month); i++) {
			System.out.print(i+"\t");
			if ((dayofweek(year, month)+i)%7==0) System.out.println();
			
		}
		
	}

	private static int dayofweek(int a , int b) {
		int c=0;
		for (int i = 1; i <= a-1; i++) {
			if (isLeapyear(a)) {
				c+=366;
			} else {
				c+=365;

			}
			
				
			}
		for (int j = 1; j < b; j++) {
			c+=lastdays(a, j);
			
			
		}
		return (c+1)%7;
		
	}

	

	private static int lastdays(int year, int month) {
		int a=0 ;
		switch (month) {
		case 1:case 3:case 5:case 7:case 8:case 10:case 12:
			a+=31;
			break;
		case 4:case 6:case 9:case 11:
			a+=30;
			break;
		case 2:
			if (isLeapyear(year)) {
				a+=29;
				
			} else {
				a+=28;

			}
		
		}
		return a;
			
			
			
			
			
		}

	private static boolean isLeapyear(int year) {
		int a=0 ;
		if (year%4==0 && year%100!=0 || year%400==0) {
			return true;
			
		} else {
			return false;
		}
		
	}
		
		
	

}
