package days17;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author user
 * @date 2024. 1. 23. 오후 3:32:51
 * @subject
 * @contents
 */
public class Ex13 {
	public static void main(String[] args) {
		int a = 0 , b=0;
		Scanner sc = new Scanner(System.in);
		//예외 처리 방법 1. try catch
		try {
			System.out.print("a,b 두 정수 입력 ?");
			// InputMismatchException
			a = sc.nextInt();
			b=  sc.nextInt();
			
		} catch (InputMismatchException e) {
			 System.out.println("입력 유효성 실패");
		}
		try {
			double c = a / b;
			System.out.printf("%d /%d = %.2f\n",a,b,c);
		} catch (Exception e) {
			System.out.println("입력 유효성 실패");
		} 
		/*if (b==0) {
			System.out.println("0으로 나눌수 없습니다.");
			return ; //프로그램 종료
		}*/ //if 문으로 항상체크하는 것으로 값을 돌리기 때문에 예외처리라고 안 봄.
		
		System.out.println("--종료--");
		
		
	}

}
