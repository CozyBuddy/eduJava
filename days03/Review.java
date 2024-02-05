package days03;

import java.util.Scanner;

public class Review {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		/*System.out.println("이름_국어_영어_수학_입력 : ");
		String name = sc.next();
		byte kor = sc.nextByte();
		byte eng = sc.nextByte();
		byte math = sc.nextByte();
		
		int sum = kor+eng+math;
		int avg = (kor+eng+math)/3;
		
		System.out.printf("이름 : \"%s\",국어 : %d , 영어 : %d , 수학 : %d ,총점 : %d , 평균 : %d",name,kor,eng,math,sum,avg);
		
		*/
		
		System.out.print("x_y 값을 입력하세요.");
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int max = (x>y ? x : y);
		
		System.out.println(max);
		
		sc.close();
		
		/*System.out.println("> 실수 입력 :");
		double a = sc.nextDouble();
		
		System.out.printf("> 결과 : %.2f",a);*/
		
	}

}
