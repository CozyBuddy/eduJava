package days06;

import java.util.Iterator;

/**
 * @author user
 * @date 2024. 1. 8. 오후 4:17:44
 * @subject
 * @contents
 */
public class Ex07 {
	public static void main(String[] args) {
		//[이름 혹은 라벨 이 붙은 반복문] 설명
		/*
		 * d=2
		 * 2단 
		 *  ㄴ i=1,2,3,4,5,6,7,8,9  i=10
		 *  d=3
		 *  3단 
		 *  ㄴ i=1,2,3,4,5,6,7,8,9  i=10
		 */
		for (int d = 2; d <= 9; d++) {
			System.out.println(d+"단");
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d*%d=%d\n",d,i,(i)*d);
			}
			
			
		}
	}

}
