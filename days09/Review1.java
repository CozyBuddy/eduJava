package days09;

import java.util.Calendar;
import java.util.Scanner;

public class Review1 {
	public static void main(String[] args) {
		// rrn = "931101-1"
		System.out.println(americanAge("931101-1074112"));
	}
	public static int americanAge(String rrn) {
		Calendar c = Calendar.getInstance();
		String birthYear;
		int e= c.get(Calendar.YEAR);
		if (rrn.substring(7,8).equals("9")||rrn.substring(7,8).equals("0")) {
			birthYear = "18";
		} else if(rrn.substring(7,8).equals("1")||rrn.substring(7,8).equals("2")||rrn.substring(7,8).equals("5")||rrn.substring(7,8).equals("6")) {
			birthYear = "19";
		} else {
			birthYear = "20";
		}
		int a = Integer.parseInt(birthYear+rrn.substring(0,2));
		int b = (c.get(Calendar.MONTH)+1)*100+c.get(Calendar.DATE);
		int d = e-a;
		if (Integer.parseInt(rrn.substring(2,6))>=b) {
			return d-1;
			
		} else {
			return d;
		}
		
	}
	
	
	
	
	/*
	 * public static void main(String[] args) { Scanner sc = new Scanner(System.in);
	 * System.out.print("정수를 입력하세요>"); int a = sc.nextInt(); String b =
	 * Integer.toHexString(a); System.out.println(b);
	 * 
	 * 
	 * }
	 */
	/*
	 * public static void main(String[] args) {
	 * System.out.println(check("931101-1022222")); } public static boolean
	 * check(String rrn) { int a[] = new int[14]; int b[] =
	 * {2,3,4,5,6,7,0,8,9,2,3,4,5}; int c=0; for (int i = 0; i < a.length; i++) {
	 * a[i] = rrn.charAt(i)-48; } for (int i = 0; i < b.length; i++) { c+=a[i]*b[i];
	 * 
	 * } int d = (11-c%11)%12; if (a[13]==d) { return true; } else { return false; }
	 * 
	 * 
	 * }
	 */
}
