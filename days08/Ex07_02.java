package days08;

/**
 * @author user
 * @date 2024. 1. 10. 오후 5:23:34
 * @subject
 * @contents 로또 머니 윤년
 */
public class Ex07_02 {
	public static void main(String[] args) {
		
		// [정보 처리 기사 실기]
		int money = 125760;
		int count = 0;
		// 화폐단위 : 5만원, 1만원, 5천원, 1천원, 5백원, 1백원, 5십원, 1십원, 5원, 1원
		int [] unit = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		String [] sunit = { "5만원", "1만원", "5천원", "1천원", "5백원", "1백원", "5십원", "1십원", "5원", "1원" };
		
		for (int  i  = 0 ; i < unit.length; i++) {
			count = money/unit[i];
			System.out.printf("%s : %d개\n", sunit[i], count);
			money %= unit[i]; 
		}
		
		/*
		// 5만원 : 2개
		count = money/50000;
		System.out.printf("5만원 : %d개\n", count);
		money %= 50000; // 25760

		// 1만원 : 2개 
		count = money/10000;
		System.out.printf("1만원 : %d개\n", count);
		money %= 10000; // 5760

		// 5천원 : 1개
		count = money/5000;
		System.out.printf("5천원 : %d개\n", count);		
		money %= 5000; 

		// 1천원 : 0개
		count = money/1000;
		System.out.printf("1천원 : %d개\n", count);		
		money %= 1000;

		// 5백원 : 1개
		count = money/500;
		System.out.printf("5백원 : %d개\n", count);		
		money %= 500; 

		// 1백원 : 2개
		count = money/100;
		System.out.printf("1백원 : %d개\n", count);		
		money %= 100; 

		// 5십원 : 1개
		count = money/50;
		System.out.printf("5십원 : %d개\n", count);		
		money %= 50;

		// 1십원 : 1개
		count = money/10;
		System.out.printf("1십원 : %d개\n", count);		
		money %= 10; 

		//   5원 : 0개
		count = money/5;
		System.out.printf("5원 : %d개\n", count);		
		money %= 5;

		//   1원 : 0개
		count = money/1;
		System.out.printf("1원 : %d개\n", count);		
		money %= 1; 
		*/ 
	} // main

}
