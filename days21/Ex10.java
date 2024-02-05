package days21;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex10 {
	public static void main(String[] args) {
		//DateTimeFormatter 형식화 클래스
		//날짜문자열 ->파싱 ->핵심클래스 변환 ->format ->날짜문자열
		
		//[2]
		String source = "2023년 08월 10일 (목)"; //날짜 형식의 문자열
		String pattern = "yyyy년 MM월 dd일 (E)";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
		LocalDate d = LocalDate.parse(source, dtf);
		System.out.println(d);
		
		
		
		
		//[1]
		/*	LocalDateTime dt = LocalDateTime.now();
			System.out.println(dt);
			
			String pattern = "yyyy/MM/dd E hh:mm:ss:SSS";
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
			String output  = dtf.format(dt);
			System.out.println(output);*/
	}

}
