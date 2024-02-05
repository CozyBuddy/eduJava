package days04;

import java.util.Scanner;

/**
 * @author user
 * @date 2024. 1. 4. 오후 2:21:03
 * @subject 정수를 입력받아서 짝수면 짝수라고 출력, 홀수면 홀수라고 출력
 * @contents
 */
public class Ex05_02 {
	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in);) {
			System.out.print("정수를 입력하세요>");
			int n = sc.nextInt() ;
			if (n%2==0) {
				System.out.println("짝수");
				
			} if(n%2!=0) {
				System.out.println("홀수");
			}
		} catch (Exception e) {
			
		}
		
}
}
