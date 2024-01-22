package days10;

import java.util.Arrays;

/**
 * @author user
 * @date 2024. 1. 12. 오후 5:30:41
 * @subject
 * @contents
 */
public class Ex05 {
	public static void main(String[] args) {
		
		int [] m = {1,2};		
		System.out.println( "main-m:"+  Arrays.toString(m) );
		
		// m[2]=3;
		m = increaseM(m);
		
		System.out.println( "main-m:"+  Arrays.toString(m) );
	} // main

	private static int [] increaseM(int[] x) {
		 
		int [] temp = new int[x.length + 2];
		
		for (int i = 0; i < x.length; i++) {
			temp[i] =x[i];
		}
		
		//m = temp;
		System.out.println( "inc-m:"+ Arrays.toString(x) );
		return temp; //전역 변수랑 지역변수 구분 해야함.
	}

	

}
