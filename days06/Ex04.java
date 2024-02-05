package days06;

/**
 * @author user
 * @date 2024. 1. 8. 오후 2:43:36
 * @subject
 * @contents
 */
public class Ex04 {
	public static void main(String[] args) {
		for (int i = 'A'; i <= 'Z'; i++) {
			System.out.printf("%c(%03d)",i,i);
			if(i%10==4) {
				System.out.println();
			}
		}
		for (int i = 'a'; i <= 'z'; i++) {
			System.out.printf("%c(%03d)",i,i);
			if(i%10==0) {
				System.out.println();
			}
		}
	}  

}


