package days03;

/**
 * @author user
 * @date 2024. 1. 3. 오후 12:28:13
 * @subject 연산자(operator)
 * @contents 1. 산술 연산자
 */
public class Ex04_02 {
	public static void main(String[] args) {
		int i = 10, j=3;
		System.out.println(i+j); // 덧셈연산자
		System.out.println(i-j); // 빼기연산자
		System.out.println(i*j); // 곱셈연산자
		System.out.println((double)i/j); // 나누기연산자
		System.out.println(i%j); //나머지 연산자
		
		// 주의점
		// ArithmeticException:ArithmeticException(산술적 예외)가 발생
		// System.out.println(10/0);
		
		// Infinity 리터럴(값자체) -> 고정된값
		 System.out.println(10.0/0);
		 
		 // ArithmeticException:ArithmeticException(산술적 예외)가 발생
		 //System.out.println(10%0);
		 
		 // NaN(not a number) 리터럴 -> 고정된값
		 System.out.println(10.0%0);
	}

}
