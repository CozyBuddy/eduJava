package days02;

/**
 * @author user
 * @date 2024. 1. 2. 오후 2:49:59
 * @subject
 * @contents
 */
public class Ex07 {
	public static void main(String[] args) {
		byte b =10;
		short s =11;
		int i = 12;
		long l = 13;
		// %d 출력서식 : 10진수 출력 
		// %o 출력서식 : 8진수 출력
		// %x,%x 출력서식 : 16진수
		System.out.printf("b=%d, s=%d, i=%d, l=%d\n",b,s,i,l);
		System.out.printf("b=%o, s=%o, i=%o, l=%o\n",b,s,i,l);
		System.out.printf("b=%x, s=%x, i=%x, l=%x\n",b,s,i,l);
		
	}

}
