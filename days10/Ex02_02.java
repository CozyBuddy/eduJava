package days10;

import java.util.Calendar;

/**
 * @author user
 * @date 2024. 1. 12. 오후 12:25:55
 * @subject
 * @contents
 */
public class Ex02_02 {
	public static void main(String[] args) {
		 {
		      // 마지막 날짜 ? 
		      Calendar c = Calendar.getInstance();
		      c.set(2020, 2-1, 1);
		      int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		      System.out.println(lastDay);

		   }
	}

}
