package days07;

/**
 * @author user
 * @date 2024. 1. 9. 오후 3:31:23
 * @subject
 * @contents
 */
public class Ex08 {
	public static void main(String[] args) {
		//계차 수열
		// 항의 갯수가 20개 까지의 합
		/*공식답
       int term = 1;
		int sum = 0;
		int difference =0;
		for (int i = 1; i <=20; i++) {
			term+=difference;
			System.out.printf("%d+",term);
			difference++;
			sum+= term;
		}
		System.out.printf("=%d+",sum);
		}
}
*/
		int x1[] = new int[365];
		x1[0]=1;
		int dif=0;
		int sum =x1[0];
		
		
		
		for (int i = 1; i < x1.length; i++) {
			dif++;
			x1[i]= dif+x1[i-1];
			sum+=x1[i];
			System.out.printf("%d+",x1[i]);
		}
		System.out.printf("=%d",sum);
	}

}
