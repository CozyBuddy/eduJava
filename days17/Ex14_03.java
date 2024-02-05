package days17;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author user
 * @date 2024. 1. 23. 오후 4:17:40
 * @subject  [개발자가 고의로 예외를 발생시키기]
 * @contents 1.throw 문을 사용해서 예외를 발생시킬 수 있다.
 * 		실습) 국어점수를 입력받아서 반환하는 getScore() 메서드 선언
 *            ㄴ 입력이 잘못된 경우에는 강제로 예외를 발생시킴.
 *            	!(0<=score<=100)
 *            
 *            직접 예외처리 ->try catch 넘겨서 간접 예외처리 ->throw
 */				
public class Ex14_03 {
	public static void main(String[] args) {
			
			int kor = 0;
			try {
				kor = getScore();
				System.out.println(kor);
			} catch (ScoreOutOfBoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	
		System.out.println("end");
	}

	private static int getScore() throws ScoreOutOfBoundException {
		int score ;
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 입력?");
		String input = sc.next();
		String regex = "100|[1-9]?\\d";
		if (input.matches(regex)) {
			score = Integer.parseInt(input);
			return score;
		} else {
			throw new ScoreOutOfBoundException("점수 범위(0~100) 초과");
		} 
		
	}

}
