package days21;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Ex09 {
	public static void main(String[] args) {
		//날짜 - 날짜  = Period
		// 시간 - 시간 = Duration
		// 문제) 수료일 - 오늘날짜 = 날짜간격
		LocalDate e = LocalDate.of(2024, 6, 14+1);
		LocalDate t = LocalDate.now();
		//System.out.println(e-t);
		Period p = Period.between(t, e); // e 날짜는 미포함해서 날짜 수 계산
		System.out.println(p.toString());
		System.out.println(p.getYears());
		System.out.println(p.getMonths());
		System.out.println(p.getDays());
		
		// 시간차 : Duration
		LocalTime e1 = LocalTime.of(18,0,0);
		System.out.println(e1);
		LocalTime t1 = LocalTime.now(); 
		Duration d =Duration.between(t1, e1);
		System.out.println(d.toString());
		System.out.println(d.getSeconds());
		
	}

}
