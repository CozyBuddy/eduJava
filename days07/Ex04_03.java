package days07;

import java.util.Scanner;

public class Ex04_03 {
	public static void main(String[] args) {
   /*String email;
		Scanner sc=new Scanner(System.in);
		System.out.print("이메일 입력 : >");
		email = sc.next();
		String regex="^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$";
		if(email.matches(regex)) {
			System.out.println("이메일 사용 가능");
		} else {
			System.out.println("이메일 사용 불가능");
		}
		*/
		// 회원가입
		// 비밀번호 - 8~15자리, %$#@ 특수문자 반드시 1개이상, 
		// [0-9] 숫자 반드시 1개이상, 알파벳 대소문자 반드시 1개 이상포함.
		Scanner sc=new Scanner(System.in);
		String regex1 = "([0-9]+[%$#@]+[A-Za-z]+){8,15}";//"(?=(?:\\D*\\d){1})(?=(?:[^A-Za-z]*[A-Za-z]){1})(?=(?:[^%$#@]*[%$#@]){1}).{8,15}"

		System.out.println("비밀번호 입력하세요.");
		String password = sc.nextLine(); 
		if (password.matches(regex1)) {
			System.out.println("올바른 비밀번호");
			
		} else {
			System.out.println("올바르지 않은 비밀번호");

		}


	}
}
