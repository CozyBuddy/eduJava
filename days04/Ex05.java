package days04;

/**
 * @author user
 * @date 2024. 1. 4. 오후 2:00:54
 * @subject [제어문]
 * @contents 1.정의 : 프로그램의 실행 순서를 제어하는 문
 * 			2. 종류
 * 				1) 조건문 : if 문,if~else, if ~ elseif ~else ...
 * 				2) 분기문 : switch 문 , 
 * 				3) 반복문 : for 문 , foreach 문
 * 				4) 조건반복문 : while문 , do ~ while 문
 * 				5) 기타 : break, continue 문 
 * 
		 * 1.
		 * 2.
		 * 3.
		 * [4.] ->건너띄기
		 * 
		 * 7 -> 반복
		 * 
		 
 */
public class Ex05 {
	public static void main(String[] args) {
		// 1) 조건문 (if 문 예제). 
		//	if문 선언 형식 
		// condition(조건식) : 참 /거짓으로 판별할 수 있는 식 , 참일때만 블럭 실행
		boolean b = false;
		if (!b) {
			System.out.println(1);
			
		} else if (b) {
			System.out.println(2);
		}
		System.out.println("종료");
	}

}
