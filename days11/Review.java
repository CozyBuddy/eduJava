package days11;

import java.util.Arrays;

public class Review {
	public static void main(String[] args) {
		int m[] = {3,2,5,1,4,6};
		
		for (int i = 0; i < m.length-1; i++) {
			int minindex=i;
			for (int j = i+1; j < m.length; j++) {
				if (m[minindex]>m[j]) {
					minindex=j;
					
				}
			}
				int temp = m[i];
				m[i] = m[minindex];
				m[minindex] =temp;
				
			
			
			
			
		}
		System.out.println(Arrays.toString(m));
	}

}
