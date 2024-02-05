package days21;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author user
 * @date 2024. 1. 29. 오전 10:23:15
 * @subject
 * @contents
 */
public class Ex02 {
	public static void main(String[] args) {
		// [j.t 핵심클래스]
		// now메서드
		LocalDate ld = LocalDate.now();//시간정보는 없음.
		System.out.println(ld.toString());// 2024-01-29
		
		LocalTime lt = LocalTime.now();
		System.out.println(lt.toString());//10:27:01.625384800
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt); //2024-01-29T10:27:36.536227700
		
		//of메서드
		LocalDate ld1 = LocalDate.of(2023, 12, 29); //원하는 날짜를 설정하는게 of
		System.out.println(ld1);//2023-12-29
		LocalTime lt1 = LocalTime.of(14, 20,11);//14:20:11
		System.out.println(lt1);
		
		ldt = LocalDateTime.of(ld1, lt1);
		System.out.println(ldt);
		
	}

}
