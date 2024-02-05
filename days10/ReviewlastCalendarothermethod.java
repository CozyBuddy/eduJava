package days10;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ReviewlastCalendarothermethod {
	public static void main(String[] args) {
		//getlastDay(a,b);
		getDayofweek(2020,5);
		getlastDay(2020,5);
		getTotalDays(2020,5,1);
		
	}
	// 총날짜수를 반환하는 함수
	private static int getTotalDays(int year, int month, int day) {
		LocalDate startDate = LocalDate.parse("0001-01-01");
		LocalDate endDate = LocalDate.of(year,month,day);
		
		return (int)(startDate.until(endDate,ChronoUnit.DAYS))+1;
		
	}
	private static int getDayofweek(int a, int b) {
		LocalDate d = LocalDate.of(a, b, 1); // 날짜 객체
		System.out.println(d.toString());
		LocalDate ld=d.withDayOfMonth(d.lengthOfMonth());
		System.out.println(ld.toString());
		int lastDay =ld.getDayOfMonth();
		return lastDay;
		
		
	}

	private static int getlastDay(int a, int b) {
		LocalDate d = LocalDate.of(a, b, 1); // 날짜 객체
		DayOfWeek w = d.getDayOfWeek(); // 열거형 타입?
		System.out.println(w.getValue());
		System.out.println(w);
		return w.getValue();
		
	}

}
