package days05;

import java.time.Year;
import java.util.Scanner;

/**
 * @author user
 * @date 2024. 1. 5. 오전 11:32:22
 * @subject 컴퓨터 - 사용자(user)
 * @contents 가위(1),바위(2),보(3) 게임
 * 			컴퓨터는 게임을 할 때 마다 임의의 1~3 발생
 */
public class Ex03 {
	public static void main(String[] args) {
		do { 
		try (Scanner sc = new Scanner(System.in);) {
			double a = Math.random();
			int com = (int)((a*10)%3+1);
			String com1[] = { "가위","바위","보"};
			System.out.print("가위(1),바위(2),보(3) 선택 >");
			int user = sc.nextInt();
			// 입력값에 대한 유효성 검사
			System.out.printf("컴퓨터 : %s , 사용자 : %s\n",com1[com-1],com1[user-1]);
			switch (user-com) {
			case -2: case 1:
				System.out.println("사용자 승리");
				break;
			case -1: case 2:
				System.out.println("컴퓨터 승리");
				break;
			default:
				System.out.println("무승부");
				break;
			} 
			
			
		   } catch (Exception e) {
			// TODO: handle exception
		  }
		Scanner sc1 = new Scanner(System.in);
		System.out.println("계속할까요?");
		String ch = sc1.next();
		char con = ch.charAt(0);
		} while (con=='y'|| con =='Y')
		//System.out.printf();
		//comstr = (com==1?"가위": (com==2? "바위","보"));
	}
}
