package days02;

/**
 * @author user
 * @date 2024. 1. 2. 오후 4:03:50
 * @subject
 * @contents 
 */
public class Ex09 {
	public static void main(String[] args) {
		
		// 10진수 10 -> 2진수 00001010
		// 8진수 10 -> 8진수 00 001 010 -> 012
		// 16진수 0000 1010 ->0x000a
		// char 유니코드 2바이트
		// 2진수 변환
		// 'A' -> 유니코드(65) ->
		char ch = 'A';
		System.out.printf("%c-%d\n",ch,(byte)ch);
		System.out.printf("%c-%d\n",'Z',(byte)'Z');
		System.out.printf("%c-%d\n",'a',(byte)'a');
		System.out.printf("%c-%d\n",'z',(byte)'z');
		
		System.out.printf("%c - %d\n",'가',(int)'가');
		System.out.printf("%c - %d\n",'힣',(int)'힣');
		
		// [u]nicode
		
		char x = '\u0061';
		System.out.printf("x : %c\n",x);
		
		
	}

}
