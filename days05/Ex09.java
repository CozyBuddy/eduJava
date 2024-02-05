package days05;

/**
 * @author user
 * @date 2024. 1. 5. 오후 4:39:05
 * @subject		if , switch , for ,while , do ~ while
 * @contents  	break, foreach
 * 				continue
 */
public class Ex09 {
	public static void main(String[] args) {
		/*int sum=0;
		for (int i = 1; i <= 10; i++) {
			if (i%2==0) continue;
			if (i%2!=0) {
			sum+=i;
			System.out.print(i+"+");
		} 	
	} System.out.print("="+sum);

	}
		 */
		// 홀수의 합 출력 방법
		//
		/* int sum=0 ;
	for (int i = 1; i <= 10; i++) {
		if (i%2==0) continue;

		sum+=i;
		System.out.print(i+"+");

} System.out.print("="+sum); */
		int sum=0;
		for (int i = 1; i <= 10; i+=2) {
			sum+=i;
			System.out.print(i+"+");
		} 	

		System.out.print("="+sum);


	}


}
