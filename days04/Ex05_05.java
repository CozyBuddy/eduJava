package days04;

import java.util.Scanner;

/**
 * @author user
 * @date 2024. 1. 4. 오후 3:08:53
 * @subject 조건문 if, if ~ else 활용 elseif 그냥 if 차이
 * @contents 국어 점수를 입력받아서 등급(수,우,미,양,가) 출력 
 */
public class Ex05_05 {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);) { 
			System.out.print("국어 점수를 입력하세요> ");
			int a = sc.nextInt();
			if ( a>=90 && a<=100) {
				System.out.println("등급 : 수");
			} else if( a>=80 && a<90) {
				System.out.println("등급 : 우");	
			} else if( a>=70 && a<80) {
				System.out.println("등급 : 미");
			} else if( a>=60 && a<70) {
				System.out.println("등급 : 양");
			} else if(a>=0 && a<60) {
				System.out.println("등급 : 가");
				} else {
					System.out.println("입력 오류");
				}
		} catch (Exception e) {
			
		}
		
	}

}
