package days06;

import java.util.Iterator;

/**
 * @author user
 * @date 2024. 1. 8. 오후 4:17:44
 * @subject
 * @contents
 */
public class Ex07_03 {
	public static void main(String[] args) {
		//구구단 가로출력
		for (int d = 2; d <= 9; d++) {
			System.out.printf("[%d단]",d);
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d*%d=%02d ",d,i,(i)*d);
			}
			System.out.println();


		}
	}

}
