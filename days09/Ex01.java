package days09;

/**
 * @author user
 * @date 2024. 1. 11. 오전 10:04:12
 * @subject
 * @contents
 */
public class Ex01 {
	public static void main(String[] args) {
		double result = rP(2,-3);
		System.out.println(result);

	}

	private static double rP(int i, int j) {
		if (j>1) return i*rP(i, j-1);
		else if(j==1) return i;
		else if (j==0) return 1;
		else return 1/rP(i,-j-1);
	}
	/*
	 * if (j==1) return i; else return i*rP(i,(j<0 ?1/(Math.abs(j)+1):j-1));
	 */
}


