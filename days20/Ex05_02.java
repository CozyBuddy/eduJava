package days20;

import java.time.Month;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex05_02 {
	public static void main(String[] args) {
		Calendar c = new GregorianCalendar(2024,1-1,1);
		Ex04.getFormatDate(c, "yyyy MM dd");
		System.out.println(Ex04.getFormatDate(c, "yyyy MM dd"));
		c.add(Calendar.DATE, 0);
		System.out.println(Ex04.getFormatDate(c, "yyyy MM dd"));
		c.add(Calendar.MONTH, 1);
		System.out.println(Ex04.getFormatDate(c, "yyyy MM dd"));
		c.getActualMaximum(Calendar.MONTH); // 이 필드가 가질 수 있는 최대값을 반환
		
	}

}
