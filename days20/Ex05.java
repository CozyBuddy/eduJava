package days20;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author user
 * @date 2024. 1. 26. 오후 12:20:16
 * @subject days19.Ex11_03.java Date 클래스 사용해서 달력 출력 => Calendar로 변환 적용
 * @contents
 */
public class Ex05 {
	public static void main(String[] args) {
		int year = 2024;
		int month = 1;

		//int lastDay = getLastDay(year, month);
		int dayOfWeek = getDayOfWeek(year, month,1);
		Calendar c = new GregorianCalendar(year,month-1,1);
		Calendar d = Calendar.getInstance(); // equals를 쓰려면 현재 시간의 밀리세컨드 까지 값을 보정해야함.
		d.set(Calendar.HOUR_OF_DAY,0);
		d.set(Calendar.MINUTE, 0);
		d.set(Calendar.SECOND, 0);
		d.set(Calendar.MILLISECOND, 0);

		c.add(Calendar.DATE,-dayOfWeek);

		//		Date start= new Date(year-1900,month-1,1);
		//		start.setDate(start.getDate() - dayOfWeek);
		//System.out.println(start.toLocaleString());
		for (int i = 0; i < 42; i++) {
			//System.out.println(start.toLocaleString());
			if (c.get(Calendar.MONTH)==month-1) {
				if (d.equals(c)) {
					System.out.printf("[*%02d*]\t",c.get(Calendar.DATE));
				} else {
					System.out.printf("[%02d]\t",c.get(Calendar.DATE));
				}

			}  else {
				System.out.printf("%02d\t",c.get(Calendar.DATE));
			}
			c.add(Calendar.DATE,1);

			if (i%7==6) {
				System.out.println();
			}



		}
	}
	private static int getLastDay(int year, int month) {
		//		Date d = new Date(year -1900, month , 1 );
		//		int date = d.getDate() - 1;
		//		d.setDate(date); 
		//		return d.getDate();
		Calendar c = new GregorianCalendar(year, month-1, 1);
		//System.out.println(c.getActualMaximum(Calendar.DATE));
		return c.getActualMaximum(Calendar.DATE);



	}

	private static int getDayOfWeek(int year, int month, int date) {
		Calendar c = new GregorianCalendar(year, month-1, date);
		return c.get(Calendar.DAY_OF_WEEK)-1;
	}
}

	/*
	 *  public static void main(String[] args) {

      Calendar today = Calendar.getInstance();
      //String t = Ex04.getFormatDate(today, "yyyy-MM-dd HH:mm:ss.SSS");      
      //t = t.substring(0, 10); // yyyy-MM-dd

      Calendar start = new GregorianCalendar(2024, 1-1, 26);
      //String s = Ex04.getFormatDate(start, "yyyy-MM-dd HH:mm:ss.SSS");
      //s = s.substring(0, 10);

      //System.out.println( t.equals(s));

      today.set(Calendar.HOUR_OF_DAY, 0);
      today.set(Calendar.MINUTE, 0);
      today.set(Calendar.SECOND, 0);
      today.set(Calendar.MILLISECOND, 0);

      System.out.println( Ex04.getFormatDate(today, "yyyy-MM-dd HH:mm:ss.SSS") );
      System.out.println( Ex04.getFormatDate(start, "yyyy-MM-dd HH:mm:ss.SSS") );

      System.out.println( today.compareTo(start)   );
      System.out.println( today.equals(start)   );



      /*
      for (int i = 1; i <=12; i++) {
         Calendar c = new GregorianCalendar(2024, i-1, 1); 
         System.out.println( c.getActualMaximum(Calendar.DATE));
      }
	 */

	/*
      Calendar c = new GregorianCalendar(2024, 1-1, 1); 
      System.out.println( Ex04.getFormatDate(c, "yyyy MM dd") );
      System.out.println( c.getActualMaximum(Calendar.DATE) );
	 */
	/*
      c.add(Calendar.MONTH, 1);
      c.add(Calendar.DATE, -1);
      System.out.println( Ex04.getFormatDate(c, "yyyy MM dd") );
	 */
	/*
      c.add(Calendar.DATE, 1);
      System.out.println( Ex04.getFormatDate(c, "yyyy MM dd") );
      c.add(Calendar.DATE, -1);
      System.out.println( Ex04.getFormatDate(c, "yyyy MM dd") );
      c.add(Calendar.MONTH, 1);
      System.out.println( Ex04.getFormatDate(c, "yyyy MM dd") );
	 */

