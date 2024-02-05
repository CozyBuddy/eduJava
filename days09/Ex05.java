package days09;

import java.util.Scanner;

/**
 * @author user
 * @date 2024. 1. 11. 오전 11:19:54
 * @subject
 * @contents
 */
public class Ex05 {
	public static void main(String[] args) {
		int money = 125760;
		int unit = 50000;
		boolean sw =false;
		int count =0;

		while (unit>=1) {
			count = money /unit;
			System.out.printf("%d원 : %d개\n",unit,count);
			money%= unit;
			unit /=(sw?2:5);
			sw=!sw;

		}

	}
}
/*// money를 입력받아서 각 화폐단위의 갯수를 
		// 출력하는 코딩.
		Scanner sc = new Scanner (System.in);
		System.out.print("돈을 입력하세요>");
		int money = sc.nextInt();
		int a [] = { 50000, 10000,5000,1000,500,100,50,10,5,1};

		for (int i = 0; i < a.length; i++) {
			int b = money/a[i];
			money = money - b*a[i];
			System.out.print(a[i]+"원 짜리 " +b+"개");
			System.out.println();
		}

	}

 */

