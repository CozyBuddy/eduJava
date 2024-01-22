package days04;

import java.util.Scanner;

/**
 * @author user
 * @date 2024. 1. 4. 오전 10:24:23
 * @subject 문자열 비교
 * @contents == X 이름입력받아서 비교 예제 
 */
public class Ex01 {
	public static void main(String[] args) {
		/*// 숫자(정수,실수) ==
		// 문자 ==
		// boolean ==
		// 문자열 ?? equals() 
		String name1 = "홍길동";
		Scanner sc = new Scanner(System.in);
		System.out.print("> 이름 입력 ? ");
		String name2 = sc.next(); //Duplicate local variable name
		System.out.println(name1.equals(name2)); // ==는 객체 자체를 보고 판단하고 
		//equals는 값자체를 판단. 
		*/
		
		String msg1 = "Malgeum", msg2 = "malgeum";
		System.out.println(msg1.equals(msg2)); // false
		// 대소문자를 구분하지 않고 문자열이 같은지 비교
		System.out.println(msg1.equalsIgnoreCase(msg2));// 대소문자 무시하고 비교
		
		String name1 = "홍길동";
		String name2 = new String("홍길동");
		
		System.out.println(name1 == name2);
		
		
		
	}

}
