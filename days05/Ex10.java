package days05;

import java.util.Iterator;
import java.util.Scanner;

/**
 * @author user
 * @date 2024. 1. 5. 오후 4:51:48
 * @subject
 * @contents
 */
public class Ex10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*int sum=0 ;
		int n ; 
		System.out.print("n을 입력하세요>");
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			sum +=i;
			System.out.print(i+"+");
		} System.out.println("="+sum);
		*/
		// [문제] 두 정수 n , m 을 입력받아서 
		// 두 정수 사이의 합을 출력하는 코딩.
		int n;
		int m;
		int sum=0;
		/*System.out.print("n을 입력하세요>");
		n = sc.nextInt();
		System.out.print("m을 입력하세요.>");
		m = sc.nextInt();
		if (n<m) {
			for (int i = n+1 ; i <= m; i++) {
				sum +=i;
			} System.out.println(sum);
			
		} else {
			for (int i = m+1 ; i <= n; i++) {
				sum +=i;
			} System.out.println(sum);
			
		}
		*/
		/*
		 * if (n>m){
		 *  temp 사용
		 */
		 /* int n, m ;
	      Scanner scanner = new Scanner(System.in);
	      System.out.print("> n_m 입력 ? ");
	      n = scanner.nextInt();
	      m = scanner.nextInt();
	      
	      int sum = 0;
	      
	      
	      
	      for (int i = n; i <= m; i++) {
	         sum += i;
	         System.out.printf("%d+", i);
	      } // for
	      System.out.printf("=%d\n", sum);
	      */
		
		//[3]
		// int min = n> m ? m : n ;
		// int max = n>m ? n : m ;
		int min ;
		int max ;
		//[문제]
		// 두 정수 n,m을 입력받아서
		// 두 정수 포함 및 사이 홀수의 합 출력.
		
		
		System.out.print("n을 입력하세요> ");
		n = sc.nextInt();
		System.out.print("m을 입력하세요> ");
		m =sc.nextInt();
		
		min =  Math.min(n, m);
		max =  Math.max(n ,m);
		int min1 = (min%2==0? min+1 : min);
		for ( int i=min1 ; i <= max; i+=2) {
			sum += i;
			System.out.print(i+"+");
		} 
		System.out.println("="+sum);
	}

}
