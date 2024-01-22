package days15;

import java.util.Calendar;
import java.util.Date;

import days14.Point;

/**
 * @author user
 * @date 2024. 1. 19. 오후 12:03:04
 * @subject
 * @contents
 */
public class Ex04 {
	public static void main(String[] args) {
		// 어제 했던 코딩을 생성자 사용해서 수정.
		// 클래스 배열 초기화
		/*Point points[] = {
				new Point(1, 1),new Point(10, 20),new Point(20, 20)
		};*/
		int year = 2024;
		int month = 1;
		int day = 19;
		//Calendar c= new Calendar();
		
		year = 2024;
		month = 1;
		day = 19;
		Calendar c = Calendar.getInstance();
		// Date,Calendar ,LocalDate
		Date d = new Date(year-1900,month-1,day);
		System.out.println(c.toString());
		System.out.println(c.get(year));
		System.out.println(d.getDay());// 5금 0일 ~ 6토
		
		
		
		
	}

}
