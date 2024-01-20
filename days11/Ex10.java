package days11;

import java.util.Arrays;

/**
 * @author user
 * @date 2024. 1. 15. 오후 3:43:35
 * @subject
 * @contents
 */
public class Ex10 {
	public static void main(String[] args) {
		// 정렬(sort) - 일정한 조건과 순서로 배치하는것
		// 오름차순 정렬 , 내림차순 정렬
		// 예)숫자 0 1 2 3 4 5 
//				  a b c d e f
//				  가 나 다 라 마
		// 1.버블정렬 -시험3?
		int m[]= {3,5,2,4,1};
		System.out.println(Arrays.toString(m));
		/*
		 * bubbleSort(m); System.out.println(Arrays.toString(m));
		 */
		//2. 선택정렬
		//selectionSort(m);
		selectionSort2(m);
		//System.out.println(Arrays.toString(m));
		// 3. 삽입정렬
		// 4. 병합정렬
		
		
		
		
	}

	private static void selectionSort2(int[] m) { // 시험?
		
			for (int i = 0; i < m.length-1; i++) {
				int minIndex = i;
				for (int j = i+1; j < m.length; j++) {
					if (m[minIndex] > m[j]) {
						minIndex = j;
						
					}
					
					}
				if (minIndex == i) continue;
				int temp = m[i];
				m[i] = m[minIndex];
				m[minIndex] = temp;
					/*
					 * do { if (m[i]>m[j]) { int temp = m[i]; m[i]=m[j]; m[j]= temp; } } while
					 * (m[i]>m[j]);
					 */
					
				
			}
			System.out.println(Arrays.toString(m));
			
			
		
	}

	private static void selectionSort(int[] m) {
			// 3,5,2,4,1
			// 1회전 1 5,3,4,2
			// 2회전 [1],[2],5,3,4
			// 3회전 [1],[2],[3],5,4
			// 4회전 1,2,3,4,5
		for (int i = 0; i < m.length-1; i++) {
			for (int j = i+1; j <= 4; j++) {
				if (m[i]>m[j]) {
					int temp = m[i]; 
					m[i]=m[j];
					m[j]= temp;
				}
				
				
			}
			System.out.println(Arrays.toString(m));
			
		}
	}

	// 오름차순 정렬 a>b
	private static void bubbleSort(int[] m) {
		// 3, 5, 2, 4, 1
		// 1회전 3 2 4 1 5
		// 2회전 2 3 1 4 5
		// 3회전 2 1 3 4 5
		// 4회전 1 2 3 4 5 
	for (int i = 1; i <= 4; i++) {
		for (int j = 1; j <= 5-i; j++) {
			System.out.printf("%d-%d",j-1,j);
			if(m[j-1]>m[j]) {
				int temp =m[j-1];
				m[j-1] = m[j];
				m[j] = temp;
			}
			System.out.println(Arrays.toString(m));
			
			
		}
		System.out.println();
		
	}
		
		
	}

}
