package days05;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		char grade = '가';
		try(Scanner sc = new Scanner(System.in);) {  // 오류나면 catch 블록으로 떨어짐
			System.out.print("국어 점수를 입력하세요> "); // 여러개 if를 쓰면 그냥 다 체크함 break 안하고 
			//elseif는 true가 나오면 나머지는 건너띔
			int a = sc.nextInt();
			switch (((a+9)+ 102/(a+3))/10) {
			case 11:
				System.out.println("입력 오류 : 정수 범위 초과");
				break;
			case 10:
				System.out.println("등급 : 수");

				break;
			case 9:
				System.out.println("등급 : 우");

				break;
			case 8:
				System.out.println("등급 : 미");

				break;
			case 7:
				System.out.println("등급 : 양");

				break;

			default:
				System.out.println("등급 : 가");
				break;
			}
		} catch (Exception e) {
			System.out.println("입력 오류 (숫자x)");

		}*/

	}
}


