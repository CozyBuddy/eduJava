package days12;

public class Ex04_02 {
	public static void main(String[] args) {
		//2차원 배열 -> 1차원 배열 
		int n[][] = {{1,2,3,4},{5,6,7,8}};
		dispN(n);
		int row = n.length;
		int col = n[0].length;
		int m[] = new int[2*4];
		
		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n[i].length; j++) {
				m[i*col+j] = n[i][j];
			}
		}
		dispM(m);
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
