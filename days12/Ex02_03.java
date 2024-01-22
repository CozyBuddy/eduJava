package days12;

public class Ex02_03 {
	public static void main(String[] args) {
			// 2면 2행 2열 3차원 배열
			//int m[][][] = new int[2][2][2];
			
			/*
			 * System.out.println(m.length);2 면갯수
			 * System.out.println(m[0].length); 2 0행갯수
			 * System.out.println(m[1].length); 2 1행갯수
			 * System.out.println(m[0][0].length); 2 0면0행 열갯수
			 * System.out.println(m[0][1].length); 2 0면1행열갯수
			 * System.out.println(m[1][0].length); 2 1면0행열갯수
			 * System.out.println(m[1][1].length); 2 1면1행열갯수
			 
			 */		
			// 2면 2행 4열 3차원배열
			int [][][] m = {{{1,2,3,4},{5,6,7,8}},{{11,12,13,14},{15,16,17,18}}};
			dispM(m);
		}

		private static void dispM(int[][][] m) {
			for (int i= 0;  i< m.length; i++) { //면갯수
				System.out.printf("[%d]면\n",i);
				for (int j= 0; j < m[i].length; j++) {
					for (int k = 0; k < m[i][j].length; k++) {
						System.out.printf("m[%d][%d][%d]=%d",i,j,k,m[i][j][k]);
					}
				}
				System.out.println();
			}
		}

	}