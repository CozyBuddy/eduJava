package days11;

import java.util.Arrays;

/**
 * @author user
 * @date 2024. 1. 15. 오전 11:24:13
 * @subject
 * @contents
 */
public class Ex04 {
	public static void main(String[] args) {
		int m [] = new int[10];
		for (int i = 0; i < m.length; i++) {
			m[i]= i+1;
			
		}
		m=shuffle(m);
		System.out.println(Arrays.toString(m));
		//배열섞기...
		int a ;
		int n [] = new int[10];
		for (int i = 0; i < n.length; i++) {
			n[i]= i+1;
			
		}
		for (int i = 0; i < m.length; i++) {
			a =(int)( Math.random()*10);
			n[i] = m[i];
			m[i] = m[a];
			m[a] = n[i];
			
			
		}
		System.out.println(Arrays.toString(m));

	}

	private static int[] shuffle(int m[]) {
		int idx1 =0 ,idx2; //1~9
		
		for (int i = 0; i < 10; i++) {
			idx2 = (int)(Math.random()*9)+1; // 중복을 피하는 방법???
			
			int temp = m[idx1];
			m[idx1] = m[idx2];
			m[idx2] = temp;
		}
		return m;
		
	}
}
