package days19;

import java.util.Date;
import java.util.Timer;

/**
 * @author user
 * @date 2024. 1. 25. 오후 4:31:03
 * @subject
 * @contents
 */
public class Ex11 {
	public static void main(String[] args) {
		/*
		 * 1.날짜,시간,형식화(formatting) 클래스
		 * 2.컬렉션 프레임워크 (컬렉션 클래스)
		 * 3.자바 IO(입출력)
		 * 4.열거형, 제네릭 ... 
		 * 5.스레드 +네트워크X
		 * 6.람다식 + 스트림 X
		 */
		//jdk 1.0 java.util.date
		//jdk 1.1 java.util.Calendar
		//				     ㄴ GregorianCalendar (자식 클래스) 
		// jdk 1.8  java.time 패키지 + 하위 패키지
		//					다양한 날짜/시간 클래스 추가.
		Date d = new Date();
		//Thu Jan 25 16:37:24 KST 2024
		System.out.println(d.toString());
		System.out.println(d.toGMTString());
		System.out.println(d.toLocaleString());
		
		// 년
		System.out.println(d.getYear()+1900);
		// 월
		System.out.println(d.getMonth()+1);
		// 일
		System.out.println(d.getDate());
		// 시간
		System.out.println(d.getHours());
		// 분
		System.out.println(d.getMinutes());
		//초
		System.out.println(d.getSeconds());
		//밀리초 ( 1000ms == 1s)
		//요일
		System.out.println(d.getDay()); // 0일 ~ 6토
		System.out.println("일월화수목금토".charAt(d.getDay())); // 0일 ~ 6토
		
		// d.getTime()
		System.out.println(d.getTime());
		long time = d.getTime();
		Date d2 = new Date();
		System.out.println(d2.toString());
		
	}

}
