package days06;

/**
 * @author user
 * @date 2024. 1. 8. 오전 10:35:30
 * @subject
 * @contents
 */
public class Ex01_03 {
	public static void main(String[] args) {
		String strcheck = "#@$!";
		char one = '@';

		for (int i = 0; i < strcheck.length(); i++) {
			
			if (one ==strcheck.charAt(i)) {
				System.out.printf("%d - %c\n",i,one);
				System.out.println("특수문자입니다.");
				break;
			} else {
				System.out.printf("%d - %c\n",i,one);
				System.out.println("특수문자가 아닙니다.");
				break;

			}
		}
	}
}
/*
 * char one = 'A';
 * for (int i = 0 ; i strcheck.length();i+1);
 * if (one == strcheck.charAt(i))
 */
	/*public static void main(String[] args) {

		// 한 문자가 특수문자(#@$!) 체크
		char one = '$';      
		// [2]
		String strCheck = "#@$!";

		// 문자열 길이 구하는 함수 : String.length()
		// System.out.println( strCheck.length() ); // 4
		boolean flag = false;
		// char String.charAt(index)
		for (int i = 0; i < strCheck.length() ; i++) {
			System.out.printf("%d - '%c'\n", i, strCheck.charAt(i));
			if( one == strCheck.charAt(i) ) {
				flag = true; 
				break;
			}




			if( one == strCheck.charAt(i) ) {
				// 특수문자
				System.out.println("특수문자 O");
				break;
			}else {
				System.out.println("특수문자 X");
			}  
		}
	}
}
*/





