package days20;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Review8 {
	public static void main(String[] args) {
		Date c = new Date(2023-1900,11,29);
		c.setDate(c.getDate()+100);
		String pattern = "yyyy년도 MM월 dd일 ";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.format(c);
		System.out.println(sdf.format(c));
		
		
		
	}

}
