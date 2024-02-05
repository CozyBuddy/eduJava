package days02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author user
 * @date 2024. 1. 2. 오후 5:13:14
 * @subject 이름, 국어 ,영어, 수학 점수를 키보드로부터 입력
 * @contents 총점 , 평균 계산
 */
public class Ex12 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name;
		byte kor,eng,math;
		short tot; 
		double avg;
		//Scanner scanner = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요 >");
		name = br.readLine();
		//String name = scanner.nextLine();
		
		System.out.println("국어 점수를 입력하세요>");
		 kor = Byte.parseByte(br.readLine());
		 
		System.out.println("수학 점수를 입력하세요>");
		math = Byte.parseByte(br.readLine());
		
		System.out.println("영어 점수를 입력하세요>");
		eng = Byte.parseByte(br.readLine());

		tot = (short)(kor + math +eng) ;
		avg = tot/3;
		
		System.out.printf("%s님은 국:%d 수:%d 영:%d 총점 :%d 평균 : %.2f",name,kor,math,eng,tot,avg);
		
		System.out.println(3+5+'0');
		
	}

}
