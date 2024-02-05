package days06;

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		//5.두 정수 (x,y)를 입력받아서
		// 두 정수 사이의 짝수의 합을 출력하는 코딩을 하세요.
		int x,y;
		int sum=0;
		Scanner sc=new Scanner(System.in);
		System.out.print("x,y값을 넣으세요>");
		x= sc.nextInt();
		y= sc.nextInt();
		int min = Math.min(x,y);
		int max = Math.max(x,y);
		/* 1번 풀이
		for (int i = min; i <=max; i++) {
			if (i%2 ==0) {
				sum +=i;
				System.out.printf("%d+",i);
			}
			*/
		// 2번 풀이 내 답안
		for (int i = min; i <=max; i+=2) {
			if (i%2 ==0) {
				sum +=i;
				System.out.printf("%d+",i);
			}
		}System.out.printf("=%d\n",sum);
	}

}
