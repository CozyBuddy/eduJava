package days07;

/**
 * @author user
 * @date 2024. 1. 9. 오후 4:06:01
 * @subject 메서드(함수) 설명
 * @contents //제어문 끝
 */
public class Ex09 {
	public static void main(String[] args) {
		/*
		 * 1. 정의 : 프로그래밍에서 반복되는 명령어들을 찾아서
		 *    별도로 묶어서 필요할 때 마다 재사용하도록 만든 것.
		 * 2. 프로그램의 구조화 -> 유지,보수,관리 편리 , 가독성이 좋음
		 * 3. 함수 기본이 되는 프로그래밍 방식 - 구조적 프로그래밍
		 * 	  객체 지향적 프로그래밍 (OOP)
        */
		// 선긋기(100줄 가정)
		drawLine(3,3);
		System.out.println("부서명 : 사원명");
		// 선긋기(100줄 가정)
		drawLine(3,3);
		System.out.println("영업부 : 명건");
		System.out.println("생산부 : 본혁");
		System.out.println("총무부 : 맑음");
		System.out.println("자재부 : 영진");
		// 선긋기(100줄 가정)
		drawLine(20, "-*-");
	}
   /*// 함수(메서드) 선언
	// 접근지정자 기타제어자 리턴자료형 함수명 ([매개변수]) { 함수 원형 == 함수의 프로토타입(prototype)
	 //함수의 몸체 (body)
	  * 
	  * [return 리턴값];
	  * return
	} // 함수 선언 3가지 : 기능,매개변수,리턴값(리턴자료형)
	*/
	// [함수 선언 부분]
	public static void drawLine() {
		// 선긋기(100줄 가정)
				System.out.println("-----------------------------------");
	}
	// 매개변수의 자료형 혹은 갯수가 다르면 똑같은 함수명으로 선언 할 수 있다.
	// 함수가 중복선언되었다 = Overloading(오버로딩)
	// 중복함수 선언시 리턴타입은 영향을 안 미침.
	public static void drawLine(int n, int m) {
		// 선긋기(100줄 가정)
		for (int i = 1; i <= m; i++) {
			System.out.println("-".repeat(n));
		}
	}
	public static void drawLine(int n,String style) {
		// 선긋기(100줄 가정)
		System.out.println(style.repeat(n));
	}
	// com.util.Draw2D.java
	 

}
