package days14;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author user
 * @date 2024. 1. 18. 오후 2:45:19
 * @subject days11.Ex05_02.java 
 * @contents Student 학생 클래스로 수정...
 */
public class Ex08 {
	public static void main(String[] args) throws IOException {
		String name;
		int kor,eng,math,tot,rank;
		double avg;
		
		final int STUDENT_COUNT = 23;
		
		Student students[] = new Student[STUDENT_COUNT];
		Scanner sc = new Scanner(System.in);
		int count = 0; // 실제 입력받은 학생수
		char con = 'y';
		
		do {
			System.out.printf("%d번 학생 이름,국어,영어,수학 입력>",count+1);
			name = sc.next();
			kor = sc.nextInt();
			eng = sc.nextInt();
			math = sc.nextInt();
			
			tot = kor+eng+math;
			avg = (double)tot /3;
			rank = 1;
			
			//첫번째 학생의 성적 정보
			students[count] = new Student();
			students[count].name =name;
			students[count].kor =kor;
			students[count].eng =eng;
			students[count].math =math;
			students[count].tot =tot;
			students[count].avg =avg;
			
			count ++; // 1명
			System.out.print("y를 누르면 계속합니다.");
			con = (char)System.in.read();
			System.in.skip(System.in.available());
			
		} while (Character.toUpperCase(con)=='Y');
		StudentManagement.procRank(students ,count);
		disStudentInfo(students,count);
	}

	
	private static void disStudentInfo(Student[] students, int count) {
		System.out.printf("총 %d명 \n",count);
		for (int i = 0; i < count; i++) {

			students[i].dispInfo();
			/*	System.out.printf("%d 번 \t%s\t%d\t%d\t%d\t%d\t%.2f\t%d등\n",
						i+1,students[i].name,students[i].kor,students[i].eng,
						students[i].math,students[i].tot,students[i].avg,students[i].rank);*/
		}
	}
	
}