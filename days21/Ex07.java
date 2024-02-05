package days21;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @author user
 * @date 2024. 1. 29. 오전 11:46:44
 * @subject
 * @contents
 */
public class Ex07 {
	public static void main(String[] args) {
		String source = "2009년 12월 30일";
		//String source = "2009-12-30";
		//String source = "2009.12.30"; 오류
		//String source = "2009/12/30";오류
		//날짜형식의 String -> LocalDate 타입 변환 작업
		// 1) SimpleDateFormat -> parse()
		// 2) LocalDate직접사용 // String 형태가 - - 로 와야함
		//LocalDate d = LocalDate.parse(source);
		/*String pattern = "yyyy년 MM월 dd일";
		DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern); // 날짜와 시간을 형식화하는 클래스
		LocalDate d = LocalDate.parse(source,df);
		System.out.println(d);*/
		
		//이번달의 마지막 날짜 며칠까지 ?
		// Date,Calendar ... 
		// LocalDate -> 마지막 날 알아보기
		
		/*	[1]
		 * LocalDate df = LocalDate.now();
			System.out.println(df);
			df = df.withDayOfMonth(1);
			System.out.println(df);
			df = df.plusMonths(1);
			System.out.println(df);
			df = df.minusDays(1);
			System.out.println(df);
			System.out.println(df.getDayOfMonth());*/
		
		//[2]
		/*	LocalDate d = LocalDate.now();
			System.out.println(d.lengthOfMonth()); // 마지막 날짜.
			d=d.plusMonths(1);
			System.out.println(d.lengthOfMonth());
			*/
		
		//[3]
		/*LocalDate d = LocalDate.now();
		d= d.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(d);*/
		//Temporal+Adjuster (시간의 조정자,관리자)
		/*
		 * [TemporalAdjusters]
		 * 날짜,시간을 수정할 때 with(),plus(),minus()
		 * 다음 달 첫 째주 화요일날
		 * 다음 달 마지막 주 토요일날 
		 * 자주 사용되는 날짜 계산들을 대신해주는 메서드를 
		 * 미리 정의해 놓은 클래스; TemporalAdjusters
		 */
		
	}

}
