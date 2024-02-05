package days21;

import java.rmi.registry.LocateRegistry;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @author user
 * @date 2024. 1. 29. 오전 11:09:37
 * @subject
 * @contents
 */
public class Ex04 {
	public static void main(String[] args) {
		//String 불변
		/*String a = "xyz";
		String b = a.replace('y', '와');
		System.out.println(a);
		System.out.println(b);*/
		
		//j.t 핵심클래스도 불변
		LocalDate ld = LocalDate.now();
		System.out.println(ld); //2024-01-29
		
		//날짜,시간 수정 - with(),plus(),minus(),add(), roll() 
		ld =ld.withYear(2020);
		ld = ld.with(ChronoField.YEAR,2000);
		ld = ld.withMonth(5);
		System.out.println(ld);
		ld = ld.with(ChronoField.MONTH_OF_YEAR,10);
		System.out.println(ld);
		
		ld = ld.withDayOfMonth(15);
		System.out.println(ld);
		ld = ld.with(ChronoField.DAY_OF_MONTH,20);
		System.out.println(ld);
		
		/*LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt);
		dt = dt.plusMonths(1);
		System.out.println(dt);
		
		dt=dt.minusMonths(3);
		System.out.println(dt);
		//plus (필드,값) ...
		*/
		
		LocalTime lt = LocalTime.now();
		System.out.println(lt);
		//lt = lt.truncatedTo(ChronoUnit.HOURS); //끝부분을 잘라내는 함수 (절삭)
		//System.out.println(lt); // 시간빼고는 다 절삭
		lt = lt.truncatedTo(ChronoUnit.MINUTES); //끝부분을 잘라내는 함수 (절삭)
		System.out.println(lt); // 분 밑으로 다 절삭
		
		LocalDateTime ldt = LocalDateTime.now();
		ldt = ldt.truncatedTo(ChronoUnit.DAYS); // 일까지 표시하고 나머지는 절삭
		System.out.println(ldt);
	}

}
