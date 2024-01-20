import java.util.Scanner;
import java.util.function.BiConsumer;

public class _06_ {

	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		double sum = 0;
		Scanner scanner = new Scanner(System.in);
		while (run) {
			System.out.println("--------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3. 점수리스트 | 4.분석 |5.종료");
			System.out.println("--------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			if (selectNo ==1 ) {
			 System.out.print("학생수 > ");
			 int students =  Integer.parseInt(scanner.nextLine());
			 scores= new int[students] ;
				
			 } else if (selectNo ==2 ) {
				for (int i = 0; i < scores.length; i++) {
					System.out.print("scores["+i+"]> ");
					scores[i] = Integer.parseInt(scanner.nextLine());
				}
				
			} else if (selectNo ==3 ) {
				for (int i = 0; i < scores.length; i++) {
					System.out.println("scores["+i+"]> "+ scores[i]);
				}
			
			} else if (selectNo ==4 ) {
				int max = 0;
				for (int i = 0; i < scores.length-1; i++) {
					if (scores[i]<scores[i+1]) {
						max = scores[i+1];
					} else {
						max = scores[i];
					}
					
					
					
				}
				for (int i = 0; i < scores.length; i++) {
					sum+= scores[i];
				}
				System.out.println("최고 점수 : "+ max);
				System.out.println("평균 점수 : "+ (double)sum/scores.length);
				
			} else if (selectNo ==5 ) {
				run =false ;
				
			}
			
		}
		System.out.println("종료");
	}

}
