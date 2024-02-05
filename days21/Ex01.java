package days21;

public class Ex01 {
	public static void main(String[] args) {
		// jdk1.8 새로 추가된 날짜와 시간 클래스
		// 1.java.time : 날짜 , 시간을 다루는 핵심 클래스
		// 	ㄴjava.time.chrono : 표준(ISO)이 아닌 달력 시스템을 위한 클래스
		//	ㄴjava.time.format : 형식화(파싱) 클래스 제공
		// 	ㄴjava.timpe.temporal(시간의) : 날자,시간의 필드(field)와 단위(unit) 클래스 제공
		//  ㄴjava.time.zone : 시간대 (time - zone) 클래스 제공
		// 2.java.time : 날짜 , 시간을 다루는 핵심 클래스
		// 	1)날짜 : LocalDate 클래스
		// 	2)시간 : LocalTime 클래스 
		// 	3)날짜 +시간 : LocalDateTime 클래스
		// 	4)날짜 +시간 + 시간대 : ZonedDateTime 클래스
		// 	-> Temporal, TemporalAdjuster 인터페이스를 구현한 클래스들
		
		// 3.Period 클래스 : 날짜와 날짜 사이의 간격
		// 4.Duration 클래스 : 시간과 시간 사이의 간격
		//	-> TemporalAmount 인터페이스 구현
		
		// 5.java.time.~ 핵심클래스들은 new 객체 생성X
		// 		: now() or of() 로 객체를 생성
		/* 6.날짜 + 시간의 단위를 정의해 놓은 인터페이스 : Temporal[Unit]
		 * 	 위의 인터페이스를 구현한클래스 : ChronoUnit 클래스
		 * 7.날짜 + 시간의 필드를 정의해 놓은 인터페이스 : Temporal[Field]
		 * 	 위의 인터페이스를 구현한클래스 : ChronoField 클래스
		 * 8.특정 필드(년,월,일시간,분초,요일 등등) 가져올때 사용하는 메서드
		 * 	 getXXX() -> getYear(),getMonth() ...
		 * 	 get'field'() -> field에 필드값을주면 가져올 수 있음.
		 * 9.특정 필드 수정
		 * 		with(), plus() ,minus() ,roll(),add()
		 * 
		 * */
		
	}

}
