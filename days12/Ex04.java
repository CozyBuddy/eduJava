package days12;

public class Ex04 {
	public static void main(String[] args) {
		//1차원 배열 -> 2차원배열 옮기는 코딩
		//2차원 배열 -> 1차원배열 옮기는 코딩
		int [] m = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12  };
		//dispM(m);
		
		int n[][] = new int[3][4];
		for (int i = 0; i < m.length; i++) {
			n[i/4][i%4]=m[i];
		}
		
		/*
		 * for (int i = 0; i < n.length; i++) { for (int j = 0; j < n[i].length; j++) {
		 * n[i][j] = m[i*4+j]; System.out.println(n[i][j]); }
		 * 
		 * }
		 */
		dispN(n);
	}

	private static void dispN(int[][] n) {
		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n[i].length; j++) {
				
				System.out.printf("n[%d][%d]=%d ",i,j,n[i][j]);
			}
			System.out.println();
		}
		
	}

	private static void dispM(int[] m) {
		for (int i = 0; i < m.length; i++) {
			System.out.printf("m[%d]=%d ",i,m[i]);
		}
		
	}

}
