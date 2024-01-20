package days11;

import java.util.Arrays;

/**
 * @author user
 * @date 2024. 1. 15. 오전 10:31:30
 * @subject
 * @contents
 */
public class Ex03 {
	public static void main(String[] args) {
		// 순차 검색 (Sequence Search)
		int m[] = { 3, 5, 2, 4, 1 };
		int foundIndex = indexOf(m, 4);
		// System.out.println(foundIndex);
		int temp[] = new int[m.length + 5];
		//System.arraycopy(m, 0, temp, 0, foundIndex);
		//System.arraycopy(m, foundIndex, temp, foundIndex+1, m.length-foundIndex);
		System.arraycopy(m, 0, temp, 0, m.length);
		System.out.println(Arrays.toString(temp));
		temp[foundIndex]= 100;
		System.out.println(Arrays.toString(temp));
	}
		// Arrays.copyOfRange(null, foundIndex, foundIndex);
		// System.arraycopy(m, 1, temp, 2, 3);
		/*
		 * System.arraycopy(m, 0, temp, 0, m.length);
		 * System.out.println(Arrays.toString(temp));
		 * 
		 * for (int i = m.length; i >= foundIndex; i--) {
		 * 
		 * temp[i+1]=temp[i]; } System.out.println(Arrays.toString(temp));
		 * temp[foundIndex]=100; System.out.println(Arrays.toString(temp));
		 */

		// 100삭제
		/*for (int i = 4; i < m.length; i++) {
			temp[i - 1] = temp[i];

		}
		// temp[foundIndex] = 100;
		temp[5] = 0;
		System.out.println(Arrays.toString(temp));

	}
*/
	private static int indexOf(int[] m, int i) {
		for (int j = 0; j < m.length; j++) {
			if (m[j] == i)
				return j;
		}
		return -1;
	}

}
