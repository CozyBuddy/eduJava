package days08;

/**
 * @author user
 * @date 2024. 1. 10. 오전 11:50:42
 * @subject
 * @contents
 */
public class Ex04_02 {
	public static void main(String[] args) {
		// 1) 1~n까지의 합을 반환하는 일반함수
		// 2) 1~n까지의 합을 반환하는 재귀함수
		int n =10;
		int result = recursiveSum(n);
		System.out.printf("1~%d=%d",n,result);
		
	}
	private static int recursiveSum(int n) {
		if (n==1) { 
			return n;
			
		} else { 
			return n + recursiveSum(n-1); // 수열을 사용해야할때 쓰는 듯 
			// 트리 구조를 검색할때 자주사용됨. 

		}
	}
	//일반함수
	private static int sum(int n) {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			result +=i; //1234
		}
		return 0;
	}
	

}
