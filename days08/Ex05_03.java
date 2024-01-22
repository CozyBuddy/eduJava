package days08;

import java.util.Random;

public class Ex05_03 {
	public static void main(String[] args) {

		// 1 7 19 28 45 23

		int lotto[] = new int[6];
		fillLotto(lotto);
		dispLotto(lotto);
	}


	/*	}
	}
	 */
	private static void dispLotto(int[] lotto) {
		for (int i = 0; i < 6; i++) {
			System.out.printf("lotto[%d]=[%d]",i,lotto[i]);
		}

	}
	
	public static void fillLotto(int[] lotto) {
		Random rd = new Random();
		int b=rd.nextInt(45)+1;
		lotto[0]= b;
		boolean a= false;
		int i =1;
		while (i<=5) {
			b =rd.nextInt(45)+1; 
			System.out.println(b);

			if(!isDuplicatelotto(lotto,10,6))  lotto[i++]= b;

		}


	}



private static boolean isDuplicatelotto(int[] lotto,int lottoNumber,int index) {
	for (int i = 0; i < index; i++) {
		if (lottoNumber==lotto[i]) {
			return true;
		}
	}
		return false;
	}

}



