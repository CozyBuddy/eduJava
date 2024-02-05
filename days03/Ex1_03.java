package days03;

import java.util.Scanner;

// ctrl +Shift +O -> 자동으로 import 구문 처리

public class Ex1_03 {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		String name;
		byte kor,eng,math;
		short tot; 
		double avg;
		// Scanner 구분자를 콤마(,) 사용하는 방법.
		// nextXXX() 메서드 사용
		System.out.print("> 이름_국어_영어_수학 입력 ?");
		
		name =sc.next();
		kor = sc.nextByte();
		eng = sc.nextByte();
		math = sc.nextByte();
		/*name = sc.nextLine();
		
		System.out.println("국어 점수를 입력하세요>");
		kor = Byte.parseByte(sc.nextLine());

		System.out.println("수학 점수를 입력하세요>");
		math =Byte.parseByte(sc.nextLine());

		System.out.println("영어 점수를 입력하세요>");
		eng = Byte.parseByte(sc.nextLine());
		*/

		// 강제 형변환 1번째 경우
		tot = (short)(kor + math +eng) ; // int 보다 작은 자료형은 연산할 때 cpu가 int 자료형으로 처리해서 연산
		avg = (double)tot/3;

		System.out.printf("%s님은 국:%d 수:%d 영:%d 총점 :%d 평균 : %.2f",name,kor,math,eng,tot,avg);


	}

}


