package days12;

import java.util.Random;

public class Ex06 {
	public static void main(String[] args) {

		// 로또 게임 횟수 입력 (n)

		int n = 5;
		//int lotto[] = new int[6*n];
		int lotto[][] = new int[n][6];
		fillLotto(lotto,n);
		dispLotto(lotto,n);
	}


	/*	}
	}
	 */
	private static void dispLotto(int[][] lotto,int n) {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < lotto[i].length; j++) {
				System.out.printf("lotto[%d][%d]=[%d]\n",i,j, lotto[i][j]);
			}
		}
		System.out.println();       
	}

	private static void fillLotto(int[][] lotto, int i) { // i = 0, 1, 2
		Random rnd = new Random(); 
		int index = 0;
		int index1 = 0;
		int lottoNumber;
		lottoNumber = rnd.nextInt(45)+1;
		for (int j = 0; j < lotto.length; j++) {

			lotto[j][index] = lottoNumber;
		}
		System.out.printf("[%d]",lottoNumber); 
		while (index1<=4) {


			while (index<=5) {           
				lottoNumber = rnd.nextInt(45)+1;
				System.out.printf("[%d]",lottoNumber); 

				// 11:02 수업 시작~
				if( !isDuplicateLotto(lotto,lottoNumber , index , i-(i++-1) ) ) 
					lotto[index1][index++] = lottoNumber;
				//index++;
			} // while
			index1++;
		}
	}

	private static boolean isDuplicateLotto(int[][] lotto, int lottoNumber, int index , int j) {
		for (int i = 0 ; i < 6; i++) {
			if( lottoNumber == lotto[j][i]) {
				return true;                
			}
		}
		return false;
	}

} // class



