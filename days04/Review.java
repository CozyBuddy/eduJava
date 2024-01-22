package days04;

import java.util.Scanner;
// 배열은 초기화 하지 않아도 그 자료형의 초기값으로 설정되어있음.
// int : 0
// double : 0.0
// char : '\0'
// boolean : false
// String : null 

public class Review {
	public static void main(String[] args) {
		/*Scanner sc = new Scanner(System.in);
		System.out.print("입력하세요 >");
		String a = sc.next();
		if (33<=a.charAt(0)&&a.charAt(0)<=37 ||a.charAt(0)==64 ) {
			System.out.println("특수문자 입니다.");
			
		} else if (48<=a.charAt(0)&& a.charAt(0)<=57) {
			System.out.println("숫자 입니다.");
			
		} else if (65<=a.charAt(0)&& a.charAt(0)<=90|| 97<=a.charAt(0)&& a.charAt(0)<=122) {
			System.out.println("알파벳 (대,소문자)입니다.");
		} else if ('ㄱ'<=a.charAt(0)&& a.charAt(0)<='힣') {
			System.out.println("한글 입니다.");
			
		} else {
			System.out.println("입력 오류");
		}*/
		
		int kors[] = new int[30];
		
		for (int i = 0; i < kors.length; i++) {
			System.out.printf("kors[%d]=%d\n",i,kors[i]);
	
		}
	}

}
   