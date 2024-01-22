package days03;

/**
 * @author user
 * @date 2024. 1. 3. 오후 12:48:24
 * @subject [논리연산자]
 * @contents boolean 참/거짓
 */
public class Ex04_04 {
	public static void main(String[] args) {
		/*
		 * 1.일반 논리 연산자
		 *  1) && 일반 논리 AND 연산자 (논리곱)	
		 *  	피연산자 && 피연산자 
		 *  	true && true -> true
		 *  	true && false -> false
		 *  	false && true -> false
		 *  	false && false -> false
		 *   	두 피연산자가 참일 때만 참이됨.
		 *   
		 *  2) || 일반 논리 OR 연산자 (논리합)
		 *  	피연산자 || 피연산자
		 *  	true || true -> true //첫번째 피연산자 가 true 면 두번쨰 항을 확인하지 않고 그냥 true로 처리함.
		 *  	true || false -> true
		 *  	false || true -> true
		 *  	false || false -> false
		 *   
		 *    	둘 다 거짓인 경우에만 거짓이다.
		 *  3) !  부정 (NOT) 연산자
		 * 2.비트 논리 연산자
		 * 	1) & 비트 논리 AND 연산자
		 * 	2) | 비트 논리 OR 연산자
		 * 	3) ^ XOR 연산자
		 * 	4) ~ 틸드 연산자 (비트부정연산자)
		 * 	5)
		 */
		System.out.println(3>=5 && 10>=5); // false
		System.out.println(3<=5 && 10>=5); // true 
		
		System.out.println(3>4 || 4>1);
		System.out.println(3<=4 || 4>1);
		System.out.println(3<=4 || 4<1);
		
		// ! 부정(NOT)연산자 
		// !참 = 거짓
		// !거짓 = 참
		System.out.println(!true);
		System.out.println(3>=4);
		//The operator ! is undefined for the argument type(s) int
		// 우선 순위 ! , >=
		System.out.println(!(3>=4)); // true
		
		// 다르다 연산자 !=
		// 
	}

}
