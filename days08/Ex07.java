package days08;

/**
 * @author user
 * @date 2024. 1. 10. 오후 5:09:25
 * @subject
 * @contents
 */
public class Ex07 {
	public static void main(String[] args) {
		//[정처기 실기]
		int money = 125760;
		int m[] = { 50000 , 10000 ,5000,1000,500,100,50,10};
		for (int i = 0; i < m.length; i++) {
			int a = money/m[i];
			money = money -a*m[i];
			System.out.println(m[i]+"그리고 갯수"+a);
		}
	}
}
/*			a = money/50000 ;
			money = money - a*50000;
			b = money/10000 ;
			money = money - b*10000;
			c = money/5000 ;
			money = money - c*5000;
			 d = money/1000 ;
			money = money - d*1000;
			 e = money/500 ;
			money = money - e*500;
			 f= money/100 ;
			money = money - f*100;
			 g= money/50 ;
			money = money - g*50;
			 h= money/10 ;
			money = money - h*10;
	
		System.out.println(a+"+"+b+"+"+c+"+"+d+"+"+e+"+"+f+"+"+g+"+"+h);
	}
	*/
	/*   // 5만원 : 2개
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
   } // main

} // class


	 */


