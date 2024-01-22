package days05;

import java.util.Iterator;

/**
 * @author user
 * @date 2024. 1. 5. 오후 2:26:01
 * @subject
 * @contents
 */
public class Ex06_02 {
	public static void main(String[] args) {
		// 한 라인에 ASCII 10개 출력
		int i ; 
		int linenumber;
		for ( i = 0, linenumber=1 ; i < 256; i++) {
			if (i%10==0) {
				System.out.printf("%d : [%c]", linenumber++, (char)i);
			} else {
			System.out.printf((i%10==9)?"[%c]\n":"[%c]", (char)i);
			}
		}
	}

}
