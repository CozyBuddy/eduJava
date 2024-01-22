package days10;

import java.util.Calendar;
import java.util.Scanner;

public class Reivew {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		System.out.print("연도를 입력하세요");
		int year = sc.nextInt();
		System.out.print("월을 입력하세요");
		int month = sc.nextInt();
		countdays(year,month);
		getlastDay(year,month);
		disCalendar(year,month);
	} //1년1월1일은 월요일 

	private static void disCalendar(int year , int month) {
		System.out.printf("\t\t\t%d년 %d월 달력",year,month);
		System.out.println();
		System.out.print("일\t월\t화\t수\t목\t금\t토");
		System.out.println();
		
		System.out.println("-".repeat(60));
		for (int i = 0; i < countdays(year, month)%7; i++) {
			System.out.print("\t");
		}
		for (int i = 1; i <= getlastDay(year, month); i++) {
			if((i-1+countdays(year, month))%7==0) {
				System.out.println();
			}
				System.out.printf("%d\t",i);
		}
		}
	

		/*
		 * private static void startday() { // TODO Auto-generated method stub
		 * 
		 * }
		 */
	private static int countdays(int a ,int b) {
		int c =0;
		for (int i = 0; i < a-1; i++) {
			if (isleapyear(a)) {
				c+=366;
			} else {
				c+=365;

			}
		}
			for (int j = 1; j <=b-1; j++) {
				c+=getlastDay(a, j);
			}
			
		
		return c+1;

	}

	private static int getlastDay(int year, int month ) {
		int a = 0;
		switch (month) {
		case 1: case 3: case 5:case 7:case 8:case 10:case 12:
			a+= 31;
			break;
		case 4:case 6:case 9:case 11:
			a+= 30;
			break;
		case 2 : if (isleapyear(year)) {
			a+= 29;
			break;
		} else {
			a+= 28;
			break;
		}
		}
		return a;
	}

	private static boolean isleapyear(int year) {
		if (year%4==0 && year%100==0&&year%400!=0) {
			return true;

		} else {
			return false ;

		}

	}

}
