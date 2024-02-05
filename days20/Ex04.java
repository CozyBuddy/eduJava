package days20;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author user
 * @date 2024. 1. 26. 오전 11:31:27
 * @subject
 * @contents
 */
public class Ex04 {
	public static void main(String[] args) {
		//1.수료일이 무슨 요일?
		//Date endDay = new Date(2024-1900, 6-1, 14, 18,0,0); 
		Calendar c = Calendar.getInstance();
		//c.get(field)
		// 새로운 날짜 설정 : set(Field,value)
		c.set(Calendar.YEAR, 2024);
		c.set(Calendar.MONTH, 6-1);
		c.set(Calendar.DATE, 14);
		c.set(Calendar.HOUR, 18);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Date d = c.getTime();

		/*// [시험] 형식화 클래스
		// "2015.5.1 오전 9:11:12" 이런 형식으로 
		String pattern="yyyy.MM.dd E a hh:mm:ss.SSS"; // 월은 대문자로 MM 와야함. // AM PM 은 a로 표시
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		// Calendar -> Date 변환
		// Date->Calendar 변환
		Date d = c.getTime();
		String strDF = sdf.format(d);
		System.out.println(strDF);
		*/
		String pattern="yyyy.MM.dd E a hh:mm:ss.SSS";
		System.out.println(getFormatDate(d, pattern));

	}
	public static String getFormatDate(Object o ,String pattern ) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if (o instanceof Date) {
			Date d = (Date)o;
			return sdf.format(d);
		} else if(o instanceof Calendar){
			Calendar c = (Calendar)o;
			Date d = c.getTime();
			return sdf.format(d);
		}
		
		return null;
	}

	/*public static String getFormatDate(Date d ,String pattern ) {

	}
	public static String getFormatDate(Calendar c ,String pattern ) {

	}*/
}
