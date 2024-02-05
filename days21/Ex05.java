package days21;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoField;

/**
 * @author user
 * @date 2024. 1. 29. 오전 11:28:16
 * @subject
 * @contents
 */
public class Ex05 {
	public static void main(String[] args) {
		// 날짜, 시간의 비교  isAfter(),isBefore(),isEqual()
		// 홍길동의 생일 1999.1.20
		// 올해 홍킬동의 생일이 지났는지 안 지났는지 또는 오늘인지 체크 
		LocalDate ld1 = LocalDate.now();
		LocalDate ld = LocalDate.of(ld1.getYear(),1,29);
		int b = ld.getMonthValue();
		System.out.println(ld1.compareTo(ld)); // 생일이 지났으면 양수 전이면 음수 오늘이면 0
		//ld = ld.withYear(ld1.getYear());
		if (ld1.isAfter(ld)) {
			System.out.println("생일이 지났습니다.");
		} else if (ld1.isBefore(ld)) {
			System.out.println("생일이 아직 아닙니다.");
		} else if (ld1.isEqual(ld)) {
			System.out.println("오늘이 생일입니다.");
		} 
	}

}
