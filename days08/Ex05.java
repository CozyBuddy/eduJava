package days08;

import java.util.Random;

/**
 * @author user
 * @date 2024. 1. 10. 오후 2:00:43
 * @subject
 * @contents
 */
public class Ex05 {
	public static void main(String[] args) {
		// 로또 게임
		// Lotto 6/45
		// 1~45 임의의 정수 - 6개
		// 0.0<=Math.random()*45<1.0
		// 1.0<=Math.random()*45+1<46.0
		/*
		 * for (int i = 0; i < 6; i++) { System.out.println((int)(Math.random()*45)+1);
		 * // 중복제거 필요
		 * 
		 * }
		 */
		// Random 클래스 
		Random rnd = new Random();
		for (int i = 1; i < 60000000; i++) {
			int lottoNumber = rnd.nextInt(45)+1;
			if (lottoNumber <0 || lottoNumber>45) {
				System.out.println(lottoNumber);
				
			}
			
		}System.out.println("end");
	}
	public static void fillLotto(int[] lotto) {
		Random rd = new Random();
		for (int i = 0; i < lotto.length; i++) {
			for (int j =0 ; j < i+1 ;j++) {	
				(lotto[i]!=lotto[i-1]) ?lotto[i]= rd.nextInt(45)+1: );

}
