package days15;

import java.io.IOException;
import java.util.Scanner;

import days11.Ex05;
import days11.Ex05_03;

public class StudentGrade {
	public static void main(String[] args) throws IOException {
		String name;
		int kor,math,eng,tot,rank,wrank; // wrank는 전체 등수
		double avg;
		final int STUDENTCOUNT= 30;
		final int CLASSCOUNT = 3;
		
		Scanner sc = new Scanner(System.in);
		//2차원 클래스 배열
		Student students[][] = new Student[CLASSCOUNT][STUDENTCOUNT];
		int counts [] = new int[CLASSCOUNT]; // counts[0] 1반 학생수 
		int ban;// 입력받는 반
		char con;
		do {
			System.out.printf("반 입력>");
			ban = sc.nextInt();
			students[ban-1][counts[ban-1]+1]= new Student();
			System.out.printf("%d반의 [%d]번 학생 이름, 국어,수학,영어 성적을 입력하세요>",ban,counts[ban-1]+1);
			name = Ex05_03.getName();
			kor = Ex05_03.getScore();
			math = Ex05_03.getScore();
			eng = Ex05_03.getScore();
			tot = kor +math+eng;
			avg = (double)tot/3;
			wrank=rank=1;
			
			
			
			/*Student s = new Student();
			s.name = name;
			s.kor = kor;
			s.eng = eng;
			s.math = math;
			s.tot = tot;
			s.rank = rank;
			s.wrank = wrank;
			s.avg = avg;*/
			days14.Student s = new days14.Student(name, kor, eng, math, tot, wrank, avg, con,wrank);
			// 클래스 복사
			students[ban-1][counts[ban-1]]=s;
			
			/*students[ban-1][counts[ban-1]].name = name;
			students[ban-1][counts[ban-1]].kor = kor;
			students[ban-1][counts[ban-1]].math = math;
			students[ban-1][counts[ban-1]].eng = eng;
			students[ban-1][counts[ban-1]].tot = tot;
			students[ban-1][counts[ban-1]].avg = avg;*/
			counts[ban-1]++;
			
			System.out.print("계속 하려면 Y를 입력하세요.");
			con = (char)System.in.read();
			System.in.skip(System.in.available());
			
		
			
		} while (Character.toUpperCase(con)=='Y');
		//procRank(students,counts);
		
		disinfo(students,counts);

	}

	/*private static void procRank(Student[] students, int[] counts,int ban) {
		for (int i = 0; i < ban; i++) {
			for (int j = 0; j < counts[i].length; j++) {
				if (students[i].tot<students[j].tot) {
					students[i].rank++;
				} else {
	
				}
			}
		}
		
	}*/

	private static void disinfo(Student[][] students, int[] counts) {
		for (int i = 0; i < counts.length; i++) {
			System.out.printf("[%d반 학생 : %d명]\n",i+1,counts[i]);
			for (int j = 0; j < counts[i]; j++) {
				System.out.printf("%s 님의 국어점수 : %d 수학점수 : %d 영어점수 : %d 총점: %d 평균: %.2f 입니다. 반등수: %d 전교등수: %d\n",students[i][j].name,
						students[i][j].kor,
						students[i][j].math,students[i][j].eng,students[i][j].tot,students[i][j].avg,students[i][j].rank,students[i][j].wrank);
			}
			
		}
		
	}
	

	

}
