package days20;

import java.text.DecimalFormat;

public class Review6 {
	public static void main(String[] args) {
		int money = 1234567899;
		String pattern = " #,###";
		DecimalFormat df = new DecimalFormat(pattern);
		System.out.println(df.format(money));
	}

}
