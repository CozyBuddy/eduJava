package days21;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import days14.Student;
import days14.StudentManagement;

/**
 * @author user
 * @date 2024. 1. 29. 오후 3:52:37
 * @subject
 * @contents
 */
public class Ex14 {
	public static void main(String[] args) throws IOException {
		//한 반에 30명 학생 - 이름,국어,영어,수학,총점,평균,등수 성적처리
		//1,2,3 차원 배열
		// Student 클래스 배열 처리 + ArrasyList 컬렉션 클래스로 처리
		//Student student = new Student();
		String name;
		int kor,eng,math,tot,rank;
		double avg;
		//ArrayList 선언
		ArrayList list = new ArrayList();
		Scanner sc = new Scanner(System.in);
		char con = 'y';
		
		do {
			System.out.printf("%d번 학생 이름,국어,영어,수학 입력>",list.size()+1);
			name = sc.next();
			kor = sc.nextInt();
			eng = sc.nextInt();
			math = sc.nextInt();
			
			tot = kor+eng+math;
			avg = (double)tot /3;
			rank = 1;
			
			Student s = new Student();
			s.name =name;
			s.kor =kor;
			s.eng =eng;
			s.math =math;
			s.tot =tot;
			s.avg =avg;
			
			list.add(s);
			System.out.print("y를 누르면 계속합니다.");
			con = (char)System.in.read();
			System.in.skip(System.in.available());
			
		} while (Character.toUpperCase(con)=='Y');
		procRank(list);
		disStudent(list);
	}

	private static void procRank(ArrayList list) {
		Iterator ir = list.iterator();
		while (ir.hasNext()) {
			Student s = (Student) ir.next();
			s.rank = 1;
			for (int i = 0; i < list.size(); i++) {
				int targetTot = ((Student)list.get(i)).tot;
				if (s.tot<targetTot) {
					s.rank++;
				}
			}
		}
	}

	private static void disStudent(ArrayList list) {
		Iterator ir = list.iterator();
		while (ir.hasNext()) {
			Student s = (Student) ir.next();
			s.dispInfo();
		}
		
	}

	
	
	
	

}
	
