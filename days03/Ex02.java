package days03;

/**
 * @author user
 * @date 2024. 1. 3. 오전 11:19:40
 * @subject
 * @contents
 */
public class Ex02 {
	public static void main(String[] args) {
		int i = Integer.MAX_VALUE ; //100;
		int j = 100 ; //100;
		long k = (long)i +j;
		System.out.printf("%d+%d = %d\n",i,j,k); // 산술 오버플로우(overflow) :
		//표시할수 있는 자료형보다 더 큰 숫자가 와서 정수에 정수를 더했는데 음수가 나오는 현상
		
	}
	// scanner 설명 
	// A simple text scanner which can parse primitive types and strings using regular expressions.

}
