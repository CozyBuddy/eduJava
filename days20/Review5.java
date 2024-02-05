package days20;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Review5 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		//c.get(field)
		// 새로운 날짜 설정 : set(Field,value)
		c.set(Calendar.YEAR, 2024);
		c.set(Calendar.MONTH, 2-1);
		c.set(Calendar.DATE, 14);
		c.set(Calendar.HOUR, 18);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Date d = c.getTime();
		String pattern = "yyyy-M-d";
		System.out.println(getFormatDate(d,pattern));
		
		System.out.println(c.getActualMaximum(c.DATE));
	}

	private static String getFormatDate(Date d, String pattern) {
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		String a = sf.format(d);
		return a;
	}

	

}
