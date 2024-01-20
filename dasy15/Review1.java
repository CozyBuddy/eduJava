package dasy15;

import java.io.IOException;
import java.util.Scanner;

public class Review1 {
	public static void main(String[] args) throws IOException {
		final int HEADCOUNT= 23;
		String name;
		int kor,eng,math,tot;
		double avg;
		int count = 0;
		char con = 'y';
		Student students[] = new Student[HEADCOUNT];
		Scanner sc = new Scanner(System.in);
		do {
			students[count]= new Student();
			System.out.print("학생 이름,국어,수학,영어 점수를 입력하세요>");
			name = sc.next();
			kor = sc.nextInt();
			math = sc.nextInt();
			eng = sc.nextInt();
			tot = kor+eng+math;
			avg = (double)tot/3;
			
			students[count].name = name;
			students[count].kor = kor;
			students[count].math =math;
			students[count].eng = eng;
			students[count].tot = tot;
			students[count].avg = avg;
			count++;
			System.out.print("계속하려면 Y를 입력하세요.");
			con = (char)System.in.read();
			System.in.skip(System.in.available());
			
			
		} while (Character.toUpperCase(con)=='Y');
		
		disinfo(students,count);
		
	}

	private static void disinfo(Student[] students, int count) {
		for (int i = 0; i < count; i++) {
			System.out.printf("%s 학생의 국어점수 : %d 수학점수 : %d 영어점수 : %d 총점: %d 평균은 %.2f점"
					,students[i].name,students[i].kor,students[i].math,students[i].eng,students[i].tot,students[i].avg);
			System.out.println();
		}
		
	}

}
