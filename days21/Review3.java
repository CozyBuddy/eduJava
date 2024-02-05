package days21;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Review3 {
	public static void main(String[] args) {
		String s = "2023.08.11 (금)";
		String pattern = "yyyy.MM.dd (E)";
		//LocalDate ld = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
		LocalDate ld =LocalDate.parse(s,dtf);
		System.out.println(ld);
		
	}
}
