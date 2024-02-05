package days20;

import java.util.Date;

public class Review2 {
	public static void main(String[] args) {
		d_day();
	}

	private static void d_day() {
		Date Dday = new Date(2024-1900,6-1,17,18,0);
		Date today = new Date();
		long a = Dday.getTime() - today.getTime();
		System.out.println(a);
		long b;
        b= a/(1000*60*60*24) ; 
		System.out.print(b+"일");
		a%= (1000*60*60*24);
		b=a/(1000*60*60);
		System.out.print(b+"시간");
		a%=(1000*60*60);
		b=a/(1000*60);
		System.out.print(b+"분");
		a%=(1000*60);
		b=a/(1000);
		System.out.print(b+"초");
		a%=(1000);
		
		
		
		
	}

}
