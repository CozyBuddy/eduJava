package days20;

import java.util.Date;

/**
 * @author user
 * @date 2024. 1. 26. 오전 10:30:37
 * @subject
 * @contents
 */
public class Ex02 {
	public static void main(String[] args) {
		/*Date t = new Date();
		System.out.println(t.toLocaleString());*/
		Date startedDay = new Date(2024-1900, 1-1, 20);
		Date endedDay  = new Date(2024-1900, 1-1, 27);
		Date today = new Date();
		      if (today.after(startedDay)&&today.before(endedDay) ||today.equals(startedDay) || today.equals(endedDay) ) {
		         System.out.println("오늘은 설문이 가능한 날입니다.");
		      } else {
		         System.out.println("오늘은 설문이 불가능한 날입니다.");
		      }
		      //오늘날짜 >= 시작일 && 오늘날짜 <= 종료일 설문가능
		      
		      System.out.println(today.compareTo(startedDay)); // 같으면 0 지났으면 1 전이면 -1
		      System.out.println(today.compareTo(endedDay)); // 
		      
		      //today.getTime()  밀리세컨드를 표현
		
		
	}

}
