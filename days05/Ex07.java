package days05;

/**
 * @author user
 * @date 2024. 1. 5. 오후 2:42:13
 * @subject  if ,switch case , for , if else ,break; ,return 
 * @contents [while 조건반복문]
 */
public class Ex07 {
	public static void main(String[] args) {
		/* [1]
		int i =1;
		int sum =0;
			while (i<=10 ) {
				sum += i;
				System.out.printf((i==10)?"%d":"%d+",i++);

			} System.out.printf("=%d",sum);

		 */
		/*[2]
		  int i = 0, sum = 0;
	      while ( i < 10 ) {  
	         i++;  
	         System.out.printf("%d+", i); 
	         sum += i;  

	       } // while
	      System.out.printf("=%d\n", sum); 
			      }
			   // i = 0 에서 조건식이 참인 것을 확인하고 1을 더하고 i 값을 출력하고 sum이라는 변수에 해당하는 i 값을 1을 누적시킴
			//  i = 1 을 조건식과 참인것을 확인하고 1을 더하고 i 값을 출력하고 sum이라는 변수에 해당하는 i 값 2를 누적시킴
			//  .... i=9을 조건식과 참인것을 확인하고 i에 1을 더해 10이 되고 해당하는 i값을 출력시킴 그리고 sum 변수에 10을 누적시키고
			// 다시 조건식이 거짓인것을 확인하고 while 문을 빠져나옴 그 다음 sum 값을 출력함.
		 */
		/*//[3]
		   int i = 0, sum = 0;
	      while ( i++ <= 10 ) {
	         System.out.printf("%d+", i); 
	         sum += i;   

	      } // while
	      System.out.printf("=%d\n", sum);
	      // i=0 에서 while 조건식인 i <=10 과 대조를해서 참인 것을 확인하고 i에 1을 더한다.즉 i=1
	      // 그 다음 i의 값을 출력형식으로 1+ 로 출력하고 sum 변수에 i 값을 누적시킨다.
	      // i=1 에서 while 조건식인 i <=10 과 대조를해서 참인 것을 확인하고 i에 1을 더한다.즉 i=2
	      // 그 다음 i의 값을 출력형식으로 2+ 로 출력하고 sum 변수에 i 값을 누적시킨다.
	      // ... i=10 에서 while 조건식인 i <=10 과 대조를해서 참인 것을 확인하고 i에 1을 더한다.즉 i=11
	      // 그 다음 i의 값을 출력형식으로 11+ 로 출력하고 sum 변수에 i 값을 누적시킨다.
	      // 그다음 i=11이고 조건식이 거짓인 것을 확인하고 while 문을 빠져나오고 sum 변수에 1~11까지 더한 수를 출력한다.
	      // 해결방법 i 증감의 후위형을 전위형으로 바꿈 i 
		 * 
		 */

		//[4]
		/*
		int i =10;
		int sum =0;
			while (i>=1 ) {
				sum += i;
				System.out.printf((i==1)?"%d":"%d+",i--);

			} System.out.printf("=%d",sum);
		 */
		// [5]
		int i =10;
		int sum =0;
		while (true ) {
				if (i <1) break;
			sum += i;
			System.out.printf((i==1)?"%d":"%d+",i--);

		} System.out.printf("=%d",sum);
	}

}
