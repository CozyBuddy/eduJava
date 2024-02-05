package days11;

import java.util.Arrays;

public class Review2 {
	public static void main(String[] args) {
		int m [] = {6,5,3,4,2,1};
		
		
		System.out.println(Arrays.toString(selectSort(m)));
	}

	public static int[] selectSort(int[] m) {
		for (int i = 0; i < m.length-1; i++) {
			int minindex=i;
			for (int j = minindex+1; j < m.length; j++) {
				if (m[minindex]>m[j]) {
					minindex=j;
				} 
			}
			int temp = m[i];
			m[i] = m[minindex];
			m[minindex]=temp;
			
		}
		return m;
		
	}

}
