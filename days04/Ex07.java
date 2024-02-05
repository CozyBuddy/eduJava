package days04;

import java.util.Scanner;

/**
 * @author user
 * @date 2024. 1. 4. 오후 4:53:05
 * @subject 분기문 : switch 문
 * @contents
 */
public class Ex07 {
	public static void main(String[] args) {
		//명령코딩이 한줄인 경우 {} 생략가능 if,for ,else 에서
		try(Scanner sc = new Scanner(System.in);) {
			System.out.print("정수를 입력하세요>");
			int n = sc.nextInt() ;
			switch (n%2) {
			case 0:
				System.out.println("짝수(even number)");
				break;

			case 1: System.out.println("홀수 (odd number)");
				break;
			}
		} catch (Exception e) {

		}
		for (int i = 0; i < args.length; i++) {
			
		}
			break;

		default:
			break;
		}

	}

}
