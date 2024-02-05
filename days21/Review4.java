package days21;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class Review4 {
	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.now();
		LocalDateTime ldt1 = LocalDateTime.of(2023,8,10,9,0,0);
		LocalDateTime ldt2 = LocalDateTime.of(2024,1,30,18,0,0);
		//LocalDateTime ldt2= LocalDateTime.of(2024,8,15,18,0,0);
		
		
		System.out.println(ldt.compareTo(ldt2));
		System.out.println(ldt.compareTo(ldt1));
		if (ldt.compareTo(ldt1) >=0 && ldt.compareTo(ldt2)<=0) {
			System.out.println("설문이 가능합니다.");
		} else {
			System.out.println("설문이 불가능합니다.");
		}
		
		
		
		
		
	}

}
