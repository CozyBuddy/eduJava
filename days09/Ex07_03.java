package days09;

public class Ex07_03 {
	public static void main(String[] args) {
		/* Resident registration number, RRN
		 * [주민등록번호] 
		 *  6.검증 == check,verify + RRN
		 */
		String rrn = "910719-1071233";
		if (checkRRN(rrn)) {
			System.out.println("올바른 주민등록번호");
		} else {
			System.out.println("잘못된 주민등록번호");

		}
	}//       0 1   2  3  4  5  7  8  9 10  11 12
	//X=(11−(2A+3B+4C+5D+6E+7F+8G+9H+2I+3J+4K+5L)mod11)mod10
	//"991231-1074112"
	// 012345678910111213
	// ABCD... ..   X
	public static boolean checkRRN(String rrn) {
		int c =0;
		for (int i = 0; i <= 12; i++) {
			if (i==6) continue;
			int a = Integer.parseInt(rrn.substring(i,i+1));
			int b = (i<=8?(i<=5?i%9+2:i+1):i%9+2);
			c+=a*b;
			
		}
		int d = (11-c%11)%10;
		System.out.println(d);
		if (d==Integer.parseInt(rrn.substring(13))) {
			return true;
		} else {
			return false;
		}
		
	}
	/*
	 * public static boolean checkRRN(String rrn) {
      // String rrn = "990123-1700001"; 
      int A = rrn.charAt(0) - 48;
      int B = rrn.charAt(1) - 48;
      int C = rrn.charAt(2) - 48;
      int D = rrn.charAt(3) - 48;
      int E = rrn.charAt(4) - 48;
      int F = rrn.charAt(5) - 48;
      // rrn.charAt(6); // -
      int G = rrn.charAt(7) - 48;
      int H = rrn.charAt(8) - 48;
      int I = rrn.charAt(9) - 48;
      int J = rrn.charAt(10) - 48;
      int K = rrn.charAt(11) - 48;
      int L = rrn.charAt(12) - 48;
      
      int X =(11-(2*A+3*B+4*C+5*D+6*E+7*F+8*G+9*H+2*I+3*J+4*K+5*L)%11)%10;
      int LAST = rrn.charAt(13) - 48;
      
      return X==LAST;
   }
	 */
}
