package days19;

import java.util.StringTokenizer;

public class Ex04 {
	public static void main(String[] args) {
		//StringTokenizer 클래스
		//String.split(); 정규표현식으로 잘라내는것
		String s = "구본혁, 권맑음, 김영진, 김진성";
		StringTokenizer st = new StringTokenizer(s, ", ");// 정규표현식 사용 X
		/*System.out.println(st.countTokens()); // 잘린 토큰 갯수
		System.out.println(st.hasMoreTokens()); // 있으면 true 없으면 false
		System.out.println(st.nextToken());*/
		
		while (st.hasMoreTokens()) {
			String name = st.nextToken();
			System.out.println(name.stripLeading());
		}
		
		
	}

}
