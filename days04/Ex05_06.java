package days04;

import java.util.Scanner;

/**
 * @author user
 * @date 2024. 1. 4. 오후 3:08:53
 * @subject 조건문 if, if ~ else 활용 elseif 그냥 if 차이
 * @contents 국어 점수를 입력받아서 등급(수,우,미,양,가) 출력 
 */
public class Ex05_06 {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);) {  // 오류나면 catch 블록으로 떨어짐
			System.out.print("국어 점수를 입력하세요> "); // 여러개 if를 쓰면 그냥 다 체크함 break 안하고 
			//elseif는 true가 나오면 나머지는 건너띔
			int a = sc.nextInt();
			if ( 0 <=a && a<=100) {
				String grade = "가";
			if ( a>=90 ) {
				grade = "수";
			} else if( a>=80)  {
				grade = "우";	
			} else if( a>=70 ) {
				grade = "미";
			} else if  (a>=60) {
				grade = "양";
			}
			System.out.println(grade);
			} else {
				System.out.println("입력 오류 (국어 점수 범위 : 0 ~ 100)");
			}
		} catch (Exception e) {
			System.out.println("입력 오류 (숫자x)");
			
		}
		
	}

}
