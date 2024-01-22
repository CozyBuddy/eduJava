package days12;

/**
 * @author user
 * @date 2024. 1. 16. 오후 12:20:36
 * @subject [수업 후에 풀어보기]
 * @contents
 */
public class Ex04_03 {
	public static void main(String[] args) {
		
		int n[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		//2 행 6열 2차원 배열로
		int m[][] = new int[2][6];
		//n->m 하고 출력해봐라.
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
