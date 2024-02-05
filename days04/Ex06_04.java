package days04;

/**
 * @author user
 * @date 2024. 1. 4. 오후 4:43:33
 * @subject
 * @contents
 */
public class Ex06_04 {
	public static void main(String[] args) {
		int sum =0;
		for (int i = 1; i <=10; i++) {
			
			sum +=i;
			System.out.printf((i==10?"%d":"%d+"),i);
			
		} System.out.printf("=%d",sum);
	}

}
