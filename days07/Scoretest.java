package days07;

import java.util.Scanner;

public class Scoretest {
	public static int scoretest(int n) {
		Scanner sc=new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		String m = "[0-9]{1,2}||100";
		if ((n+"").matches(m)) {
			return n;
			
		}
		
	} 

}
