package days06;

import java.util.Iterator;

/**
 * @author user
 * @date 2024. 1. 8. 오후 4:17:44
 * @subject
 * @contents
 */
public class Ex07_02 {
	public static void main(String[] args) {
		int d = 2;
		int i = 1;
		System.out.println(d+"단");
		while (d<=9) {
			i=1;
		while (i<=9) {
			System.out.printf("%d*%d=%d\n",d,i,(i)*d);
			i++;
		}
		System.out.println(d+1+"단");
		}
		/*for (int d = 2; d <= 9; d++) {
			System.out.println(d+"단");
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d*%d=%d\n",d,i,(i)*d);
			}
			
			
		}
		*/
		
	}

}
