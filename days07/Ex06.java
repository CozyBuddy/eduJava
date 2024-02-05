package days07;

/**
 * @author user
 * @date 2024. 1. 9. 오후 2:21:33
 * @subject
 * @contents
 */
public class Ex06 {
	public static void main(String[] args) {
		double sum=0;
		boolean sw = false;
		for (int i = 1; i <10; i++) {
			int j = i+1;
			System.out.print(i+"/"+j+"+");
			sum += (double)i/j;
			
		}
		System.out.printf("=%f",sum);
	}

}
