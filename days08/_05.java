package days08;

import java.util.Random;

public class _05 {
	public static void main(String[] args) {
		int lotto [] = new int[6];
		filllotto(lotto);
		dislotto(lotto);

	}

	private static void dislotto(int lotto[]) {
		for (int i = 0; i < 6; i++) {
			System.out.println(lotto[i]);

		}

	}

	private static void filllotto(int lotto[]) {
		Random a = new Random();
		int b = a.nextInt(45)+1;
		lotto[0]=b;
		int i =1;

		out :while (i<=5) { // i==5 랑 i<=5랑 while 문에서 뭔차이???
			b= a.nextInt(45)+1;
			for (int j = 0; j < i; j++) {
				if (b==lotto[j]) {
					continue out;
				} 
			} 
			lotto[i]=b;
			i++;
		}

	}
}






