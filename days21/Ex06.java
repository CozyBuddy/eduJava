package days21;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author user
 * @date 2024. 1. 29. 오전 11:41:52
 * @subject
 * @contents
 */
public class Ex06 {
	public static void main(String[] args) {
		LocalDate d = LocalDate.now();
		LocalTime t = LocalTime.now();
		LocalDateTime dt = LocalDateTime.now();
		
		LocalDate d2 = dt.toLocalDate();
		LocalTime t2 = dt.toLocalTime();
		
		LocalDateTime dt2 = d.atTime(t); //합치는 작업
		LocalDateTime dt3 = t.atDate(d); // 합치는 작업
	}

}
