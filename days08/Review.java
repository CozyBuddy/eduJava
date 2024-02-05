package days08;

import java.util.Random;
import java.util.Scanner;

public class Review {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("정수를 입력하세요>");
		int a = sc.nextInt();
		String b = Integer.toBinaryString(a);
		System.out.printf("%s",b);
	}
	
	public static int fac(int n) {
		if (n==0) { 
			return 1;

		} else {
			return n*fac(n-1);

		}

	}

}
