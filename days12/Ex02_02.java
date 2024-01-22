package days12;

/**
 * @author user
 * @date 2024. 1. 16. 오전 10:29:13
 * @subject
 * @contents
 */
public class Ex02_02 {
	public static void main(String[] args) {
		// 2행 4열 2차원 배열
		//int m[][] = new int[2][4];
		
		/*
		 * System.out.println(m.length); // 2 행갯수 System.out.println(m[0]); // 4 0행 열갯수
		 * System.out.println(m[1]); // 4 1행 열갯수
		 */		
		int [][] m = {{1,2,3,4},{5,6,7,8}};
		dispM(m);
	}

	private static void dispM(int[][] m) {
		for (int i= 0;  i< m.length; i++) {
			for (int j= 0; j < m[i].length; j++) {
				System.out.printf("m[%d][%d]=%d",i,j,m[i][j]);
			}
			System.out.println();
		}
	}

}
