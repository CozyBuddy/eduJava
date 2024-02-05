package days20;

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * @author user
 * @date 2024. 1. 26. 오후 3:12:15
 * @subject
 * @contents
 */
public class Ex06_02 {
	public static void main(String[] args) {
		String strMoney = "3,257,600.80";
		double money ;
		//[2] DecimalFormat 형식화클래스 
		// 			ㄴ format()
		// 			ㄴ parse() 파싱
		String pattern = "#,###.00";
		DecimalFormat df = new DecimalFormat(pattern);
		try {
			Number n = df.parse(strMoney);
			// Number -> int ,double 변환 
			money = n.doubleValue();
			System.out.println(money);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		//[1]
		/*strMoney =strMoney.replace(",", "");
		money = Double.parseDouble(strMoney);
		System.out.println(money);*/
	}

}
