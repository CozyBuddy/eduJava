package days17;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author user
 * @date 2024. 1. 23. 오후 3:32:51
 * @subject [멀티 catch 문]
 * @contents JDK 1.7부터 추가
 */
public class Ex13_03 {
	public static void main(String[] args) {
		int a = 0 , b=0;
		Scanner sc = new Scanner(System.in);
		//예외 처리 방법 1. try catch // 상속 관계가 있는 Exception의 클래스에서 자식 클래스를 
		//먼저 catch 블록에 잡아야 상위 예외 클래스에서 안 잡힘.
			
		try {
			System.out.print("a,b 두 정수 입력 ?");
			// InputMismatchException
			a = sc.nextInt();
			b=  sc.nextInt();
			double c = a / b;
			System.out.printf("%d /%d = %.2f\n",a,b,c);
		} catch (InputMismatchException | ArithmeticException e) {
			System.out.println("[1]\n"+e.toString());
			System.out.println("[2]\n"+e.getMessage());
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			// 예외의 발생 유무에 상관없이 처리할 구문
			// 파일 열어서 사용 -> finally 구문에서 파일,DB을 close() 해야함.
			System.out.println("종료합니다.");
		}
		/*if (b==0) {
			System.out.println("0으로 나눌수 없습니다.");
			return ; //프로그램 종료
		}*/ //if 문으로 항상체크하는 것으로 값을 돌리기 때문에 예외처리라고 안 봄.
		
		System.out.println("--종료--");
		
		
	}

}
