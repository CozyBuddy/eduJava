package days19;

import java.util.Date;

/**
 * @author user
 * @date 2024. 1. 25. 오후 5:03:10
 * @subject
 * @contents
 */
public class Ex11_02 {
	public static void main(String[] args) {
		//[달력]
		int year = 2010;
		int month = 5;
		int date = 1;
		
		// 1)무슨 요일
		/*Date d = new Date();
		d.setYear(year-1900);
		d.setMonth(month-1);
		d.setDate(date);
		d.setHours(0);
		d.setMinutes(0);
		d.setSeconds(0);
		System.out.println(d.toLocaleString());*/
		Date d = new Date(year-1900,month-1,date,0,0,0);
		
		System.out.println(d.toLocaleString());
		System.out.println(d.getDay()); 
		// 2) 마지막 날짜
		// 날짜 : 2010.5.1
		// 월 ++
		d.setMonth(d.getMonth() +1);
		System.out.println(d.toLocaleString());
		//		 2010.6.1
		d.setDate (d.getDate()-1);
		System.out.println(d.toLocaleString());
		System.out.println(d.getDate());
		
	}

}
