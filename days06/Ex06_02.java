package days06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author user
 * @date 2024. 1. 8. 오후 4:01:13
 * @subject
 * @contents
 */
public class Ex06_02 {
	public static void main(String[] args) {

		String name;
		Scanner sc = new Scanner(System.in);
		name = sc.nextLine(); //kwon mal geum
		System.out.printf("name : %s\n",name);
		//String.toCharArray()
		// String -> char[] 변환하는 함수(메서드)
		char [] nameCharArray = name.toCharArray();
		System.out.println(Arrays.toString(nameCharArray)); //배열 안의 값을 확인하는 용도로 Arrays.toString 메서드를 사용.
	  // 2)char[] -> String으로 변환하는 방법.
		System.out.println(name);
		name = String.valueOf(nameCharArray);
		System.out.printf("name :  %s\n",name);
		// char nameChararray[] = name.toCharArray();
		// Arrays.toString(nameChararray)
		

}
}
