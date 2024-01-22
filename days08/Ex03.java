package days08;

import java.util.Scanner;

import com.util.MyCalendar2;
import com.util.MyCalender;

public class Ex03 {
	public static void main(String[] args) {
		// 년도를 입력받아서 윤년/평년 출력 코딩.
		int year;
		//year = getYear();
		// 그레고리력 : 1년 365.2425
		// 율리우스력 : 1년 365.22
		//String result = MyCalender.isLeapYear(2024);
		
		if (MyCalendar2.isleanyear(2023)) {
			System.out.println("윤년(leap year)");
		} else {
			System.out.println("평년(common year)");

		}
		
	}

	/*public static int getYear() {
		int year;
		System.out.print("년도 입력 >");
		Scanner scanner =new Scanner(System.in);
		String regex = "\\d[0-9]";
		year = scanner.nextInt();
		return year; 
	}
	*/

}
