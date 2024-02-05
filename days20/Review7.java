package days20;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Review7 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		Calendar d = Calendar.getInstance();
		d.set(2024, 5, 14,18,0,0);
		Date a = c.;
		Date b = d.getTime();
		
		String pattern = "dd일 hh시간 mm분 ss초 SSS밀리초";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		System.out.println(sdf.format(a));
		
		
	}

}
