package days06;

import java.util.Scanner;

/**
 * @author user
 * @date 2024. 1. 8. 오후 12:41:41
 * @subject
 * @contents
 */
public class Ex03_02 {
	/*public static void main(String[] args) {
		//3번문제
		/*아래 실행결과와 같이 문자를 입력받아서  출력하는 코딩을 2번 하세요.

	    [실행결과]
		> 한 문자 입력 ? a 엔터
		one='a' 
		> 한 문자 입력 ? b 엔터
		one='b'
	 */

	public static void main(String[] args) {
		char con = 'y';
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("한 문자 입력 ? ");
			String one1 = sc.next();
			char one = one1.charAt(0);
			System.out.println("one : "+one);
			System.out.print("계속 하시겠습니까> ");
			con = sc.next().charAt(0);
			
		} while (con == 'y' || con=='Y');
		System.out.println("종료합니다.");
		

	}
}


