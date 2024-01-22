package days05;

import java.util.Scanner;

/**
 * @author user
 * @date 2024. 1. 5. 오후 3:36:19
 * @subject if,switch, for, while 
 * 				[do ~ while] 문
 * @contents break,
 */
public class Ex07_02 {
	public static void main(String[] args) {
		/*
		 * [while/ do~while 문 의 차이점 이해]
		 
		int i = 10;
		while (i<2) {
			System.out.println("A");
			
		}
		do {
			System.out.println("B");
		} while (i<2);
		*/
		
		int kor ;
		Scanner sc = new Scanner(System.in);
		String strKor ;
		int i =0;
		String regex = "\\d{1,2}|100"; // 정규식 표현 \\d 의 뜻은 0~9까지의 숫자,
		// {1,3}은 1자리수부터 3자리수까지 범위 제한, 
		
		do {
			if (i!=5) {
			System.out.printf((i !=0 ? "%d번 오류입니다. 다시 입력하세요>":"국어 점수를 입력하세요> "),i);
			
			} else if(i==5){
				System.out.println("(5번 입력오류)입력 횟수가 초과하였습니다. 잠시 후 다시 시도해주세요.");
				return;
			}
			strKor = sc.next();
			i++;
		} while (!strKor.matches(regex));
			kor = Integer.parseInt(strKor);
			System.out.println("입력된 국어 점수 : "+ kor);
		}
	
		
	}


