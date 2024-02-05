package days04;

/**
 * @author user
 * @date 2024. 1. 4. 오후 4:02:14
 * @subject 1~10까지 합 구하기
 * @contents
 */
public class Ex06_02 {
	public static void main(String[] args) {
		int sum = 0;
	
		for (int i = 1; i <=10 ; i++) {
			System.out.printf("%d+",i);
			sum+=i;
		}
		System.out.printf("\b=%d",sum); // backspace 앞에꺼 지우는 형식이 \b 근데 이클립스에서는 버그로 안됨. 다른 프로그램에서는 잘 지워질듯
	}
	/*public static void main(String[] args) {
		int sum = 0;
	
		for (int i = 1; i <=10 ; i++) {
			if (i==10) {
				System.out.printf("%d",i);
			} else {
				System.out.printf("%d+",i);

			}
			sum+=i;
		}
		System.out.printf("=%d",sum);
	}
*/
} 
