package days07;

/**
 * @author user
 * @date 2024. 1. 9. 오후 2:34:42
 * @subject
 * @contents
 */
public class Ex07 {
	public static void main(String[] args) {
		//[2]
		// 토끼 암컷1
		// 토끼 숫컷1
		
		int firstTerm = 1;
		int secondTerm = 1;
		int nextTerm;
		int sum = firstTerm + secondTerm;
		System.out.printf("%d+%d+",firstTerm,secondTerm);
		
		 while ((nextTerm = firstTerm +secondTerm) <100) { //무한루프 
			 sum += nextTerm; 
			 System.out.printf("%d+",nextTerm);
			 firstTerm = secondTerm; 
			 secondTerm = nextTerm;
			  
			  }
			 
		/*
		 * [2]
		 * while (true) { //무한루프 nextTerm = firstTerm +secondTerm; if(nextTerm >100)
		 * break; sum += nextTerm; System.out.printf("%d+",nextTerm);
		 * 
		 * firstTerm = secondTerm; secondTerm = nextTerm;
		 * 
		 * 
		 * 
		 * }
		 */
		System.out.printf("=%d",sum);
	}
}
/*	[1]public static void main(String[] args) {
		//[피보나치 수열]
		// 항(term)
		// 1 +1 -> 고정
		int x[]= new int[100];
		x[2]=1;
		x[1]=1;
		int sum=x[1]+x[2];
		System.out.printf("%d+%d+",x[1],x[2]);
		for (int i = 3; i < x.length; i++) {
			x[i]= x[i-2]+x[i-1];
			if (x[i]>100) {break;
			}
			System.out.printf("%d+",x[i]);
			sum+=x[i];
			}
		System.out.printf("=%d",sum);
		}
		
	}
*/

