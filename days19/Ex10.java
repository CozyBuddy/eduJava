package days19;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author user
 * @date 2024. 1. 25. 오후 3:46:24
 * @subject
 * @contents
 */
public class Ex10 {
	public static void main(String[] args) {
		//정규표현식(Regular Expression) == 정규식
		// - 문자열 속에 원하는 조건(패턴)과 일치하는 문자열을 찾기위해서 사용된다.
		// - 미리 정의된 기호
		// java.util.regex 패키지
		//  	ㄴ Pattern 클래스
		//		ㄴ Matcher 클래스
		String [] data = {"bat","baby","bonus","cA","ca","co", "c.", "c0", "car"
                , "combat", "count", "date", "disc", "fx"};
		// 1) c로 시작하는 모든 문자(data)를 출력.
		/*for (int i = 0; i < data.length; i++) {
			if (data[i].startsWith("c")) {
				System.out.println(data[i]);
				
			}
		}*///함수이용
		//2) 정규표현식
		//String regex = "c.*";
		/*
		for (int i = 0; i < data.length; i++) {
			if(data[i].matches(regex)) {
				System.out.println(data[i]);
			}
		}*/
		/*Pattern p = Pattern.compile(regex);
		for (int i = 0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if (m.matches()) {
				System.out.println(data[i]);
			}
		}*/
		String regex = "c.*";
		regex = "c[a-zA-Z]*";
		regex = "c\\."; // 실제.이 오는것을 확인
		regex = "c[a-zA-Z0-9]*";
		regex = "c\\w*";//위에 코딩이랑 똑같음. 지칭하는것이
		regex = "c[0-9]";
		regex = "c\\d";//위에 코딩이랑 똑같음. 지칭하는것이
		regex = "c.*t";
		regex = "c[^0-9]";// 두번째 문자는 숫자가 아닌 것이 와야함.
		regex = "c\\D";//위에 코딩이랑 똑같음. 지칭하는것이 [^0-9] == \\D
		regex = "(b|c).{2}"; // 총문자길이는 3개가 되야함. b나c로 시작 
		regex = "[bc].{2}";//위에 코딩이랑 똑같음. 지칭하는것이
		regex = "[bcd].{2,3}";
		regex = "[b-d].{2,3}";
		//bcd 문자 제외 한 알파벳 대소문자
		regex = "[A-Za-z&&[^b-d]].*"; //* 0개이상
		regex = "[A-Za-z&&[^b-d]].+"; //* 1개이상
		regex = "[A-Za-z&&[^e-f]].?"; //* 0또는1 
		Pattern p = Pattern.compile(regex);
		for (int i = 0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if (m.matches()) {
				System.out.println(data[i]);
			}
		}
		
		
	}

}
