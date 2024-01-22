package days11;

import java.io.IOException;
import java.util.Scanner;

public class Review3 {
	public static void main(String[] args) throws IOException {
		String m[] = new String[30];
		int m1[] = new int[30];
		int m2[] = new int[30];
		int m3[] = new int[30];
		int m4[] = new int[30];
		int m6[] = new int[30];
		double m5[] = new double[30];
		String name;
		int kor;
		int math;
		int eng;
		int sum;
		double avg;
		int rank=0;
		char con;
		int i=0;
		Scanner sc = new Scanner(System.in);
	do {
		System.out.print("학생의 이름을 입력하세요>");
		name = sc.next();
		System.out.print("국어점수를 입력하세요>");
		kor = sc.nextInt();
		System.out.print("수학 점수를 입력하세요>");
		math = sc.nextInt();
		System.out.print("영어 점수를 입력하세요>");
		eng = sc.nextInt();
		System.out.print("Y키를 누르면 계속 진행합니다.");
		con = (char)System.in.read();
		System.in.skip(System.in.available());
		sum=kor+math+eng;
		avg=(double)sum/3;
		m[i]=name;
		m1[i] =kor;
		m2[i] =math;
		m3[i] =eng;
		m4[i] =sum;
		m5[i] =avg;
		i++;
	} while (Character.toUpperCase(con)=='Y');
		disinfoStudent(m,m1,m2,m3,m4,m5,i,rank);
		
		
	}

	private static void disinfoStudent(String[] m,int[] m1,int[] m2,int[] m3,int[] m4,double[] m5 , int j,int rank) {
		rank=0;
		int min=0;
		int n [] = new int[j];
		Review2 r = new Review2();
		
		n=r.selectSort(m4);
		for (int i = 0; i < j; i++) {
			if (m4[min]==n[i]) {
				rank=i+1;
			}
			min++;
			System.out.printf("%s 님의 국어성적은 %d , 수학성적은 %d, 영어 성적은 %d 이며 총점은 %d 등수는 %d 그리고 평균은 %f 입니다.\n",m[i],m1[i],m2[i],m3[i],m4[i],rank,m5[i]);
		}
		
		
		
		
	}

}
