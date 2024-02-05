package days20;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author user
 * @date 2024. 1. 26. 오전 10:49:59
 * @subject
 * @contents
 */
public class Ex03 {
	public static void main(String[] args) {
		//Calendar 클래스 
		//Calendar 추상클래스 - 날짜 , 시간
		// Calendar c = new Calendar() ; X
		Calendar c = Calendar.getInstance();
		//     ㄴnew GregorianCalendar(); // Calendar 자식클래스 
		
		// 2024년도의 며칠째인지
		System.out.println(c.get(Calendar.DAY_OF_YEAR));
		// 해당 주의 며칠째인지
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		// 연중의 몇 주인지
		System.out.println(c.get(Calendar.WEEK_OF_YEAR));
		// 해당 달의 몇 번째 주인지
		System.out.println(c.get(Calendar.WEEK_OF_MONTH));
		
		
		
		
		//년
		System.out.println(c.get(1)); //2024
		System.out.println(c.get(Calendar.YEAR)); //2024
		//월
		System.out.println(c.get(2)+1); //0
		System.out.println(c.get(Calendar.MONTH)+1); //0
		//일
		System.out.println(c.get(5)); // 일
		System.out.println(c.get(Calendar.DATE)); //일
		System.out.println(c.get(Calendar.DAY_OF_MONTH)); //해당 월의 날짜
		//시간
		System.out.println(c.get(10)); // 시간
		System.out.println(c.get(Calendar.HOUR)); //시간 12(0-11)
		System.out.println(c.get(Calendar.HOUR_OF_DAY)); // 24시간제
		//분
		System.out.println(c.get(12)); // 분
		System.out.println(c.get(Calendar.MINUTE)); //분
		//초
		System.out.println(c.get(13)); // 일
		System.out.println(c.get(Calendar.SECOND)); //일
		//밀리초
		System.out.println(c.get(14)); // 밀리초
		System.out.println(c.get(Calendar.MILLISECOND)); //밀리초
		//요일
		System.out.println(c.get(7)); // 요일
		System.out.println(c.get(Calendar.DAY_OF_WEEK)); //요일 Date랑 다르게 일요일(1)~토요일(7)
		
		// 자정부터 정오 직전까지의 시간을 나타내는 AM_PM 필드의 값
		System.out.println(c.get(Calendar.AM));
		// 시간이 정오 이전인지 이후인지를 나타내는 get,set필드값
		System.out.println(c.get(Calendar.PM));
		System.out.println(c.get(Calendar.AM_PM));
	}
	/*public String solution(String str1, String str2) {
	 int count = 0;
	 String answer = "";
	 	for (int i = 1; i < str1.length(); i++) {
	 		answer +=str1.substring(0,i);
	 		str1=str1.substring(i,str1.length());
	 		
		 		answer +=str2.substring(0,j);
		 		str2=str2.substring(j,str2.length());
			
		}
	 	
	       return answer;
	   }*/

}
