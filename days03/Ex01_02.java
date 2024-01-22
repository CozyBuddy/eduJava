package days03;

/**
 * @author user
 * @date 2024. 1. 3. 오전 10:38:32
 * @subject [형변환 설명]
 * @contents
 */
public class Ex01_02 {
	public static void main(String[] args) {
		/*
		 * [형변환]
		 * 1. 정의? 변수 또는 상수의 자료형(타입)을 다른 자료형(타입)으로 변환하는 것.
		 * 2. 예
		 * 		int -> byte
		 * 		byte -> int
		 * 		int -> float
		 * 		double -> int
		 * 		String -> int
		 * 		int -> String
		 * 		char - > String
		 * 		String -> char
		 * 3. 형 변환 방법
		 * 		1) 자동 형변환 -2가지 
		 * 		2) 강제 형변환 
		 * 			ㄱ. 경우 
		 * 			ㄴ. 방법 (변환하고자하는 자료형)변수명 cast 연산자
		 * 			cast 강제 형변환.
		 * 			 연산자 우선 순위 * > +
		 * 				() -> 최우선 연산자
		 * 			
		 * 
		 */
		byte b = 100; // 8bits로 이루어짐 byte가
		// 자동형변환 첫 번째 경우 ( 좌측에 있는 자료형의 크기가 더 크면 자동형변환됨)
		long l = b;
		System.out.println(l);
		
		double d =l; //
		System.out.println(d); // 예외 long 보다 float 실수형이 더 크다고 인식함. 실제 크기가 작더라도
		
		float f = l;
		System.out.println(f);
		
		
		// int i = 100L ; 자동 형변환 X
		float f2 = 3.14f; //Type mismatch: cannot convert from double to float 3.14로 할때
		int x = 100;
		long y = 100;
		long z = x + y; // 큰걸로 자동 형변환으로 long형으로 바뀜.
		
	}

}
