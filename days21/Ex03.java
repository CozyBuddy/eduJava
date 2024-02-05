package days21;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

/**
 * @author user
 * @date 2024. 1. 29. 오전 10:33:42
 * @subject
 * @contents
 */
public class Ex03 {
	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		
		//년
		int year = ld.get(ChronoField.YEAR); // temporaltime 인터페이스를 구현한 클래스가 ChoronoField
		System.out.println(year);
		year = ld.getYear();
		System.out.println(year);
		//월
		int month = ld.get(ChronoField.MONTH_OF_YEAR);
		System.out.println(month);
		month = ld.getMonthValue();
		System.out.println(month);
	    Month mt = ld.getMonth();
	    System.out.println(mt);
		//일
	    int day = ld.get(ChronoField.DAY_OF_MONTH);
	    System.out.println(day);
	    day = ld.getDayOfMonth();
	    System.out.println(day);
	    
	    LocalTime lt = LocalTime.now();
		//시간
	    int hour = lt.get(ChronoField.HOUR_OF_DAY);
	    System.out.println(hour);
	    
	    hour = lt.getHour();
	    System.out.println(hour);
		//분
	    int minute = lt.get(ChronoField.MINUTE_OF_HOUR);
	    System.out.println(minute);
	    
	    minute = lt.getMinute();
	    System.out.println(minute);
		//초
	    int second = lt.get(ChronoField.SECOND_OF_MINUTE);
	    System.out.println(second);
	    
	    second = lt.getSecond();
	    System.out.println(second);
	    
		//밀리초
	    int millisecond = lt.get(ChronoField.MILLI_OF_SECOND);
	    System.out.println(millisecond);
	    
	    millisecond = lt.getNano()/1000000;
	    System.out.println(millisecond);
		//요일
	    int dayofweek = ld.get(ChronoField.DAY_OF_WEEK);
	    System.out.println(dayofweek); // 월(1) ~ 일(7) 
	    								// Date 일(0) ~ 토(6)
	    								// 일(1) ~ 토(7)
	    
	    DayOfWeek dayofweek1 = ld.getDayOfWeek();
	    System.out.println(dayofweek1);
	    System.out.println(dayofweek1.getValue());
	}

}
