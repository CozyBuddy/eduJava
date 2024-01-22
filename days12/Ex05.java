package days12;

/**
 * @author user
 * @date 2024. 1. 16. 오후 12:23:08
 * @subject
 * @contents
 */
public class Ex05 {
	public static void main(String[] args) {
		// [가변 배열]
		// 1반 학생수 10명
		// 2반 학생수 8명
		// 3반 학생수 20명
		
		int m[][] = new int[3][]; // 열갯수를 의도적으로 안줌
		m[0] = new int[10];
		m[1] = new int[8];
		m[2] = new int[20];
		dispN(m);
		
		
	}
	private static void dispN(int[][] n) {
		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n[i].length; j++) {

				System.out.print("[ ]");
			}
			System.out.println();
		}
	}

}
