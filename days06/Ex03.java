package days06;

import java.util.Scanner;

/**
 * @author user
 * @date 2024. 1. 8. 오후 12:41:41
 * @subject
 * @contents
 */
public class Ex03 {
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
		Scanner sc = new Scanner(System.in);
		System.out.print("한 문자 입력 ? ");
		String one1 = sc.next();
		char one = one1.charAt(0);
		System.out.println("one : "+one);
		System.out.print("한 문자 입력 ? ");
		String one2 = sc.next();
		one = one2.charAt(0);
		System.out.println("one : "+one);

	}
}


