package days08;

import java.util.Random;

/**
 * @author user
 * @date 2024. 1. 10. 오후 4:02:44
 * @subject
 * @contents
 */
public class Ex06 {
	public static void main(String[] args) {
		// 신용카드 번호
		String card = "1232-1231-1231-1234";
		// String [] String.split(regex)
		String regex = "-";
		String [] cardArr = card.split(regex);
		
		/*
		 * for (String c : cardArr) { System.out.println(c); }
		 */
		Random rd = new Random();
		int index =rd.nextInt(4); // 0<= int<4
		
		cardArr[index] = "****";
		
		/*
		 * String printCard =
		 * String.format("%s-%s-%s-%s",cardArr[0],cardArr[1],cardArr[2],cardArr[3]);
		 * System.out.println(printCard);
		 */
		String printCard=String.join("-",cardArr);
		System.out.println(printCard);
		// 카드결제 영수증
		
	}

}
