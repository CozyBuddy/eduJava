package days06;

/**
 * @author user
 * @date 2024. 1. 8. 오전 10:24:51
 * @subject
 * @contents
 */
public class Ex01_02 {
	public static void main(String[] args) {
		// '0' <=one&& '9' >=one
		char one = '0';
		System.out.println(Character.isDigit(one)); // 해당 문자가 숫자(0~9)인지 확인.
		char one2 = '1';
		System.out.println(Character.isDigit(one2)|| Character.isAlphabetic(one2));
		if (Character.isDigit(one)) {
			System.out.println("숫자");
		} else {
			System.out.println("숫자 아님");
		}
		
		one = 'A';
		one = 'a';
		one = '9';
		one = '야';
		System.out.println(Character.isAlphabetic(one)); // 알파벳이 아니라 단순히 문자인것을 체크함.
		
	}

}
