package days10;

import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

import com.util.MyCalender;

/**
 * @author user
 * @date 2024. 1. 12. 오전 11:09:42
 * @subject 달력 만들기
 * @contents
 */
public class Ex02 {
	public static void main(String[] args) { 
		int year, month; // 출력할 달력의 년도 와 월
		try (Scanner sc = new Scanner(System.in)){
			System.out.print(">년도 월 입력 ");
			year = sc.nextInt();
			month = sc.nextInt();

			// 달력그리기
			printCalendar(year,month);
		} catch (Exception e) {
			e.printStackTrace(); // 예외 정보 확인
		}

	}
	// 1년1월1일이 월요일 -> 총날짜수%7 =>0(일) , 1(월) .... 
	private static void printCalendar(int year, int month) {
		/*
		 * Date d = new Date(year -1900 , month -1 ,1);
		 * System.out.println(d.toLocaleString());
		 * System.out.println("일월화수목금토".charAt(d.getDay()));
		 */
		int dayofWeek = getDay(year,month,1);
		int lastDay = getLastDay(year, month);
		//달력출력
		System.out.printf("\t\t\t[%d년 %d월]\n",year,month);
		System.out.println("-".repeat(60));
		String week ="일월화수목금토";
		for (int i = 0; i < week.length(); i++) {
			System.out.printf("\t%c",week.charAt(i));
		}
		System.out.println();
		System.out.println("-".repeat(60));
		// 1의 위치를 잡기 위해서 앞에 \t 위치 for
		for (int i = 0; i < dayofWeek; i++) {
			System.out.print("\t");
		}
		//System.out.printf("\t%d",1);
		for (int i = 1; i < lastDay; i++) {
			System.out.printf("\t%d",i);
			 if ((i+dayofWeek)%7==0) System.out.println();
			
			/*
			 * for (int j = 0; j < 7; j++,i++) { System.out.printf("\t%d",i); } i--;
			 */
			
			
				
			
			
		}
		System.out.println();
		
		System.out.println("-".repeat(60));


	} 
    //2. year , month 마지막날짜 ?
	/*
	 * int lastDay =getLastDay(year,month); private static int getDay(int year, int
	 * month,int day) { // 1.1.1 ~year.month .1 총 날짜수 %7
	 * 
	 * int totalDays = getTotalDays(int year,int month,int day){ int totalDays= 0;
	 * 
	 * 
	 * 
	 * 
	 * return 0; }
	 */

	private static int getLastDay(int year,int month) { 
		int lastDay = 0; 
		Calendar c = Calendar.getInstance();
		c.set(year,month-1,1);
		lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		return lastDay;
	}
	/*
	 * private static int getLastDay(int year,int month) { int lastDay = 0; switch
	 * (month) { case 1:case 3:case 5:case 7:case 8:case 10:case 12: lastDay = 31;
	 * break; case 2 : lastDay = MyCalender.isLeapYear(year)?29:28; default: lastDay
	 * = 30; break; } return 0; }
	 */
	private static int getTotalDays(int year, int month, int day) {
		int totalDays=0;
		/*
		 * for(int i =1 ; i<year ; i++) { totalDays+= MyCalender.isLeapYear(i)?366:365;
		 * }
		 */
		totalDays = (year-1)*365 +(year-1)/4-(year-1)/100+(year-1)/400;
		for (int i = 1; i < month; i++) {
			totalDays+= getLastDay(year, i);
		}
		totalDays++;
		/*
		 * int lastDay =0; int months[] = {31,28,31,30,31,30,31,31,30,31,30,31}; if
		 * (MyCalender.isLeapYear(year)&& month ==2 ) lastDay = 29; return lastDay;
		 */
		return totalDays;
	} 
	private static int getDay(int year, int month, int day) {

		// 1.1.1~ year.month.1 총날짜수 % 7  
		// 0~6
		int totalDays = getTotalDays(year, month, day);
		int dayOfWeek = totalDays % 7;
		return dayOfWeek;
	}
}
/*
 * // year 2020,month 5, day 1 // 365*2019+2020.1 (31) + 2(29) +3(31) +... int c
 * = 0; int b = 0; int a[] = new int[year-1]; for (int i = 0; i < a.length; i++)
 * { if((i+1)%4==0 && (i+1)%400!=0 || (i+1)%100==0) { a[i] = 366; } else {
 * a[i]=365; } } for (int i = 0; i < a.length; i++) { b+=a[i]; //요일
 * 
 * } for (int i = 0; i < month-1; i++) { if (a[year]==366) { c+=day; if
 * (month%2==1 ) { c+=(month-1)/2*30+(month-1)/2*31; } else if
 * (month%2==0&&month!=2) { c+=(month-1)/2*31+(((month-1)/2-1)*31); } {
 * 
 * 
 * }
 * 
 * 
 * } else {
 * 
 * } } return c+b+; }
 * 
 * }
 */
