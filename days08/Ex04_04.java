package days08;

/**
 * @author user
 * @date 2024. 1. 10. 오후 12:42:16
 * @subject
 * @contents
 */
public class Ex04_04 {
	public static void main(String[] args) {
		//[문제]
		// [거듭제곱]==누승==멱==pow
		// 
		double result = power(-2,-4);
		System.out.println(result);
	}
	//일반함수
	private static double power(int n,int m) {
		int k =n;
		double y=0;
		if ( m>0) {
			for (int i = 0; i < m-1; i++) {
				 n*=k;
		}
			return n;
			} else if (m==0) {
			return n;
		} else {
         for (int i = 0; i < -m-1; i++) {
			 n*=k;
			 y = (double)1/n;
		}
		return y;
	}

	}
	//재귀함수
	private void name() {
		
	}
}

