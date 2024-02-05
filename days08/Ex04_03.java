package days08;

/**
 * @author user
 * @date 2024. 1. 10. 오후 12:20:42
 * @subject
 * @contents
 */
public class Ex04_03 {
	public static void main(String[] args) {
		//재귀 함수 예제)
		//팩토리얼(factorial ) = 계승
		// 정의 ) 1에서 양의 정수의 곱
		// n! = n*(n-1) ... 1
		// 0! = 1 (약속)
		int n = 0;
		//int result = factorial(n);
		int result = recursiveFactorial(n);
		System.out.println(result);
	}
	//재귀함수
	private static int recursiveFactorial(int n) {
		if(n==0) return 1;
		else return n*recursiveFactorial(n-1);
	}
	//일반 함수
	private static int factorial(int n) {
		// n!
		int result =1;
		for (int i = n; i >=1; i--) {
			result*=i;
		}
		return result;
	}

}
