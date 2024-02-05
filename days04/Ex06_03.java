package days04;

/**
 * @author user
 * @date 2024. 1. 4. 오후 4:23:15
 * @subject for문 예제
 * @contents
 */
public class Ex06_03 {
	public static void main(String[] args) {
		int sum=0;
		int i =1;
		for ( ; ; ) { // 조건식이 공백이면 무한루프 돎.
			if( i >10) break;
			sum+=i+1;
			System.out.printf("%d+",i+=2);
			
			
			
		} System.out.printf("=%d",sum);

	}

}
