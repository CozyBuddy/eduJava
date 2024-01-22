package days08;

import java.util.Random;

public class Review2 {
	public static void main(String[] args) {
		int lotto[] = new int[6];
		filllotto(lotto);
		dislotto(lotto);
		

	}
	private static void dislotto(int[] lotto) {
		for (int i = 0; i < lotto.length; i++) {
			System.out.println(lotto[i]);
		}

	}
	private static void filllotto(int[] lotto) {
		Random rd = new Random();
		lotto[0] = rd.nextInt(45)+1;
		int i = 1;
		int b ;
		out :while (i<=5) {
			b =rd.nextInt(45)+1;
			for (int j = 0; j <= i; j++) {
				if (b==lotto[j]) {
					continue out;

				}
			}  
					lotto[i++]=b;
				
			}
			


		}

	}


