package days20;

import java.util.Calendar;
import java.util.Date;

public class Ex04_02 {
	public static void main(String[] args) {
		// 1.Calendar -> Date 변환
		Calendar c = Calendar.getInstance();
		
		Date d = c.getTime();
		// 2.Date->Calendar 변환
		Date d1 = new Date();
		c.setTime(d1);
	}
	
	
}
