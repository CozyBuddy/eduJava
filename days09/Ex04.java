package days09;

/**
 * @author user
 * @date 2024. 1. 11. 오전 11:14:41
 * @subject
 * @contents
 */
public class Ex04 {
	public static void main(String[] args) {
		int year ;
		for (int i = 2010; i <= 2030; i++) {
			System.out.println((isday(i))?i+"년은 윤년":i+"년은 평년");
		}
	
	}
	
	private static boolean isday(int year) {
		if (year%4==0 && year%100!=0 ||year%400==0) {
			
			return true;
		} else {
			return false;

		}  
  
	}

}
