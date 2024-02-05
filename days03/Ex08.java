package days03;

/**
 * @author user
 * @date 2024. 1. 3. 오후 4:50:22
 * @subject 연산자 활용
 * @contents 대문자 -> 소문자 변환
 * 			 소문자 -> 대문자 변환
 * 			 
 */
public class Ex08 {
	public static void main(String[] args) {
		System.out.printf("%c(%d)\n",'A',(int)'A');
		System.out.printf("%c(%d)\n",'B',(int)'B');
		System.out.printf("%c(%d)\n",'a',(int)'a');
		System.out.printf("%c(%d)\n",'b',(int)'b');
		System.out.printf("%c(%d)\n",'Z',(int)'Z');
		System.out.printf("%c(%d)\n",'z',(int)'z');
		
		// 소문자-32 = 대문자
		char lowerCase ='x', upperCase ;
		upperCase = (char)(lowerCase -32) ;
		System.out.printf("%c(%d)\n",upperCase,(int)upperCase);
		
		lowerCase = (char)(upperCase+32);
		
		// '0' - 48
		// '1' -49
		// '9' -57
		System.out.println('4'-'2'); //52-50
		
		
		
		
	}

}
