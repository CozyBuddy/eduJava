package days20;

import java.net.SocketTimeoutException;
import java.util.Calendar;

public class Review4 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(c.DATE));
		System.out.println(c.get(c.MONTH));
		System.out.println(c.get(c.DAY_OF_YEAR));
		System.out.println(c.get(c.DAY_OF_MONTH));
		System.out.println(c.get(c.HOUR));
		System.out.println(c.get(c.MINUTE));
		System.out.println(c.get(c.SECOND));
	}

}
