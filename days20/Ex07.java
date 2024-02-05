package days20;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author user
 * @date 2024. 1. 26. 오후 3:23:02
 * @subject  DecimalFormat 형식화클래스
 * 				숫자 -> 문자열 format() 변환
 * 				문자열 -> 숫자 parse() 변환
 * 
 *  			SimpleDateFormat 형식화클래스
 * 				날짜-> 문자열 format() 변환 
 * 				문자열 -> 날짜 parse() 변환 
 * @contents
 */
public class Ex07 {
	public static void main(String[] args) {
		//[2]
		//String strDate = "24년 01월 26일";
		String strDate = "24년 01월 26일 (금요일)";
		
		//String pattern = "yy년 M월 d일";
		String pattern = "yy년 M월 d일 (E)";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		//1) Date d
		try {
			Date d = sdf.parse(strDate);
			System.out.println(d.toLocaleString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		//[1]
		/*Calendar c = Calendar.getInstance();
		// "24년 1월 26일 (금요일)"
		String pattern = "yy년 M월 d일 (E요일)";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String result = sdf.format(c.getTime());
		System.out.println(result);*/
	}

}
