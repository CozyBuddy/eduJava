package days12;

import java.util.Random;
import java.util.Scanner;

public class Review2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("게임 횟수를 입력하세요>");
		int n =sc.nextInt();
		int lottos[][] = new int[n][6];
		filllottos(lottos,n);
		dislottos(lottos,n);
	}

	private static void dislottos(int[][] lottos, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < lottos[i].length; j++) {
				System.out.println("lottos["+i+"]["+j+"] = "+lottos[i][j]);
			}
			
		}
		
	}

	private static void filllottos(int[][] lottos,int n) {
		Random rd = new Random();
		int index=0;
		
		for (int i = 0; i < n; i++) {
			int a = rd.nextInt(45)+1;
			lottos[i][0]= a;
			for (int j = 1; j < lottos[i].length; j++) {
				int b = rd.nextInt(45)+1;
				if (!(isDuplicate(lottos,b,i,j))) {
					lottos[i][j]=b;
				} else {
					j--;
					
				}
			}
			
		}
		
		
	}

	private static boolean isDuplicate(int[][] lottos ,int b,int i,int j) {
		if (lottos[i][j]==b) {
			return true;
			
		} else {
			return false;
		}
		
	}

}
