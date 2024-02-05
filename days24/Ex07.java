package days24;

/**
 * @author user
 * @date 2024. 2. 1. 오후 4:05:38
 * @subject
 * @contents
 */
public class Ex07 {
	public static void main(String[] args) {
		/*
		 *  enumeration 열거자 / iterator 반복자
		 *  [열거형 (Enum)]
		 *  1.jdk 1.5추가
		 *  2. 서로 관련된 상수를 편리하게 사용하기 위한 것.
		 *   예) 남자,여자 -성별
		 *   
		 *   예) 1조 - 구본혁 (8명)
		 *   각자가 남자/여자 체크해서 코딩~
		 *   int gender = 1;
		 *   boolean gender = true;
		 *   char gender = 'm';
		 *   
		 *   각자 통일된 형식 , 표준화 - > 유지,보수 생산성 , 가독성 향상,
		 *  3. 열거형 선언 형식
		 *  	접근지정자 enum 열거형이름 { //클래스로 변환해서 대문자로 열거형이름을 시작해야함.
		 *  	상수명, // 대문자사용
		 *  	상수명, // 자료형이 열거형이름으로 선언되어짐 자동으로
		 *  }		
		 *  4. 열거형 사용하는 방법 : 열거형이름.상수명
		 *  5. 열거형 -> 클래스로 컴파일될때
		 *  				-> 부모클래스가 extends java.lang.Enum 클래스(자동 상속됨)
		 *  6.Enum 클래스의 메서드
		 *  	1) ordinal() : 열거형 상수가 정의된 순서대로 위치값을 반환
		 *  	2) name() : 열거형 상수명을 문자열로 반환
		 *  	3) valueOf() : name() 메서드와 일치하는 "열거형 상수" 반환
		 *  
		 */
		System.out.println(Gender.남자);
		System.out.println(Gender.남자.ordinal());
		System.out.println(Gender.남자.name()); // 문자열
		System.out.println(Gender.valueOf("남자")); // 상수형태 == Gender.남자??
		System.out.println(Gender.여자);
		System.out.println(Gender.여자.ordinal());
		
		Gender arr [] = Gender.values();
		for (Gender gender : arr) {
			System.out.println(gender+"/"+gender.ordinal()+ "/"+ gender.name());
		}
	}

}
