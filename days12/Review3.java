package days12;

public class Review3 {
	public static void main(String[] args) {
		int [] m = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12  }; // 0 1 2 3 ..
		int n[][] = new int [6][2]; //00 01 10 11 ..
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < n[i].length; j++) {
				n[i][j] = m[i*2 +j];
			}
			
		}

		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n[i].length; j++) {
				System.out.println(n[i][j]);
			}
		}
	}

}
