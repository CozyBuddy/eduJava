package days19;

import java.sql.Date;

public class Review7 {
	public static void main(String[] args) {
		Date d = new Date(2024,1,20);
		Date d1 = new Date(2024,01,25);
		Date d2 = new Date(2024,01,26);
		//int a =d2.compareTo(d);
		
		if (d2.after(d)&& d2.before(d1)) {
			System.out.println("설문 가능");
		} else {
			System.out.println("설문 불가능");
		}
		
	}

}
