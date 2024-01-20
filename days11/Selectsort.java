package days11;

import java.util.Arrays;

public class Selectsort {
	public static void main(String[] args) {
		int m[] = {7,6,1,2,5,3,4};
		System.out.println(Arrays.toString(m));
		for (int i = 0; i < m.length; i++) {
			int minindex=i;
			for (int j = minindex+1; j < m.length; j++) {
				if (m[minindex]>m[j]) {
					minindex = j;
					
				}
				
			}
			if (minindex==i) continue;
			int temp = m[i];
			m[i] = m[minindex];
			m[minindex]=temp;
			System.out.println(Arrays.toString(m));
		}
		System.out.println(Arrays.toString(m));
	}
}
