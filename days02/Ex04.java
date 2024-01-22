package days02;
/**
 * @author user
 * @date 2024. 1. 2. 오전 11:22:45
 * 자바 자료형
 *  String(%s) ,double(%f), char(%c), int (%d)
 */

// 자료형 == Data type 데이터 형식 (값 + 형식)
// 숫자형 1. 정수형 byte short2 int4 long8 char2
//2. 실수형 double(8), float(4)
// 3. 논리형 (boolean 1byte) -true ,false
   
public class Ex04 {
	public static void main(String[] args) {
		/*
		 * [자료형] == Date type(데이터 형식)
		 * 1. Data(값) + Type(종류) 
		 * 2. 자료형 ? 값이 저장될 공간의 크기와 저장 형식을 정의한 것
		 * 3. 자바의 자료형
		 *   1)기본형(Primitive Type) - 8가지 기본형
		 *    1} 숫자형
		 *     		ㄱ.정수계열 - byte(1), short(2), [int](4), long(8) char(2)
		 *          1byte=8bit 1bit ->[0][1] 2가지 1byte =8bit ->2^8 개 (256가지) 
		 *          byte 정수 표현 범위 : -128~127
		 *          short 정수 표현 범위 : -32768~32767
		 *          int 정수 표현 범위 : -2147483648 ~ 2147483647
		 *          long 정수 표현 범위 : -9223372036854775808~9223372036854775807
		 *     		ㄴ.실수계열 - [double(8)] ,float(4) 
		 *    2} 논리형(boolean 크기:1byte) - 참(true),거짓(false)
		 *    		
		 *   2)참조형(Reference Type) - 배열(Array),클래스 ,인터페이스
		 */
		
		
		// 성별을 나타내는 변수 선언 : 남자(true), 여자(false)
		boolean gender = true;
		System.out.printf("성별 : %b\n",gender);
		
		// 사람의 나이를 저장할 변수 age 선언하세요.
		 byte age ; //[][][][] 0 ~125
		 // 한 학생의 국어 점수를 저장할 변수 kor 선언하세요.
		 byte kor =100; ;
		 // 다른 언어 : byte 256가지 표현 - 128~127 정수
		 // 부호 X 0~255 정수
		 
		 
		 
		 
	} 

}
