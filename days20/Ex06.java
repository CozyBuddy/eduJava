package days20;

import java.text.DecimalFormat;

/**
 * @author user
 * @date 2024. 1. 26. 오후 2:26:19
 * @subject [형식화 클래스 4가지]
 * @contents SimpleDateFormat ***
 * 			  DecimalFormat
 * 			  ChoiceFormat
 * 			  Message Format
 */
public class Ex06 {
	public static void main(String[] args) {
		// [Decimal Format] 
		// 숫자 		형식화 하는 클래스
		//int money = 3257600;
		//double money = 3257600.826;
		double money = 3257600.8;
		// 출력 형식 : "3,257,600"
		//[3] DecimalFormat  숫자 -> 형식화 클래스 
		String pattern = "#,###.00";
		//String pattern = "#,###.##";
		//String pattern = "\u00A4#,###";
		DecimalFormat df = new DecimalFormat(pattern);
		String result = df.format(money);
		System.out.println(result);
	}

	
	
	 //[2]
	//String result = String.format("%,d", money);
	//System.out.println(result);
		/*String a = money+"";
		String strMoney = money + "";
		String result = "";
		for (int i = 0; i < a.length(); i++) {
			char one = strMoney.charAt(i);
			int placeValue = a.length()-i;
			//System.out.println(one+" "+placeValue);
			result += one;
			if (placeValue%3 ==1 ) {
				//System.out.println(",");
				result+=",";
			}
			
		}
		System.out.println(result.substring(0,result.length()-1));
	}*/
		/*int count = a.length();
		String b="";
		for (int i = (int) Math.ceil((double)a.length()/3); i >0 ; i--) {
			b += a.substring(count-3);
			a=a.substring(0,count-3);
			count=count-3;
		}
		System.out.println(b);
	}*/

}
