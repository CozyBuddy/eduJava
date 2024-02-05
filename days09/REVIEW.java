package days09;

public class REVIEW {
	/*
	 * public static void main(String[] args) { double result = rP(2,-5);
	 * System.out.println(result); }
	 * 
	 * private static double rP(int i, int j) { if (j>1) return i*rP(i,j-1); else if
	 * (j==0) return 1; else if (j==1) return i; else return 1/rP(i ,-j);
	 * 
	 * }
	 */
	public static void main(String[] args) {
		int a [] = new int[32];
		int b = 10;
		int c;
		int d;
		int i= a.length-1;
		while (b>=0) {
			a[i] = b%2;
			b=b/2;
			i--;
			if (i==0) break;
			}
		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j]);
			if (j%8==7) {
				System.out.print(" ");
			}
		}
			
		}
		
	}

