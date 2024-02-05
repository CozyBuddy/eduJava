package days09;

import java.util.Random;

public class Ex02 {
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
	private static void dispLotto(int[][] lotto, int n) {
		for (int i = 0; i < 6*n; i++) {
			System.out.printf("lotto[%d]=[%d]\n",i,lotto[i]);
		}

	}
	public static void fillLotto(int[][] lotto,int n) {
		Random rd = new Random();
		int b=rd.nextInt(45)+1;
		lotto[0]= b;
		int i =1;
		int c=1;
		while (c <=n) {
			
	
		out : while (i<=5) {
			b =rd.nextInt(45)+1; 
			for (int j = 6*(i-1); j < 6*(i-1); j++) { // for 문 바깥에서 처리하는거랑 for 문 안에서 else로 처리하는걸 구분해야할듯
				if (b==lotto[j]) {
					/*
					 * a=true; break;
					 */
					continue out;
				} 
			}
			lotto[i++]= b;
			
			
			

		}
		
		
		}


	}


}





