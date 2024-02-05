package days03;

import java.util.Scanner;
/**
 * @author user
 * @date 2024. 1. 3. 오전 11:44:24
 * @subject
 * @contents Scanner 클래스 예제
 */
public class Ex03 {
	public static void main(String[] args) {

	     String input = "1 fish 2 fish red fish blue fish";
	     // \\s*fish\\s* 구분자
	     // \s ==space == 공백 정규식에서는 역슬러시를 두번 꼭 써야함.
	     // * 반복횟수 0~ 여러개
	     Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
	     System.out.println(s.nextInt());
	     System.out.println(s.nextInt());
	     System.out.println(s.next());
	     System.out.println(s.next());
	     s.close();
		
	}

}
