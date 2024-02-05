package days06;

import java.util.Scanner;

/**
 * @author user
 * @date 2024. 1. 8. 오후 4:01:13
 * @subject
 * @contents
 */
public class Ex06 {
	public static void main(String[] args) {
		// 본인의 영어이름을 입력받아서 char [] 로 변환후 
		// foreach문을 사용해서 출력하는 코딩을 하세요.
		String name;
		Scanner sc = new Scanner(System.in);
		name = sc.nextLine(); //kwon mal geum
		System.out.printf("name : %s\n",name);
		int arraylength = name.length();
		
		char [] nameCharArray = new char[arraylength];
		for (int i = 0; i < arraylength; i++) {
			nameCharArray[i] = name.charAt(i);
			
		}
		for (char c : nameCharArray) {
			System.out.printf("'%c'",c);
			
		}
	}

}
