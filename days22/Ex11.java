package days22;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import days14.Student;
import days14.StudentManagement;

/**
 * @author user
 * @date 2024. 1. 30. 오후 3:06:51
 * @subject 시험.
 * @contents
 */
public class Ex11 {
	public static void main(String[] args) throws IOException {
		// [3반 30명 학생 성적 처리]
		// Student 클래스 배열 선언
		// Student students[] = new Student[30] days14.Ex08.java
		// Student students[][] = new Student[3][30]; days15.Ex01.java 2차원 배열
		// 1)Student 클래스 사용 2) 입력받는 순서 유지 - List : ArrayList 컬렉션 클래스 
		ArrayList list = new ArrayList();
		String name;
		int kor,eng,math,tot,rank;
		double avg;
		
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
			//첫번째 학생의 성적 정보
			//s = new Student();
			s.name =name;
			s.kor =kor;
			s.eng =eng;
			s.math =math;
			s.tot =tot;
			s.avg =avg;
			s.rank = rank;
			list.add(s);
			
			System.out.print("y를 누르면 계속합니다.");
			con = (char)System.in.read();
			System.in.skip(System.in.available());
			
		} while (Character.toUpperCase(con)=='Y');
		
		procRank(list);
		disStudentInfo(list);
	
	}

	private static void procRank(ArrayList list) {
			Iterator ir = list.iterator();
			while (ir.hasNext()) {
				Student object = (Student) ir.next();
				object.rank=1;
				Iterator ir2 = list.iterator();
				while (ir2.hasNext()) {
					Student object2 = (Student) ir2.next();
					if(object.tot< object2.tot) object.rank++;
				}
				
			}
		
	}

	private static void disStudentInfo(ArrayList list) {
		System.out.printf("총 %d명 \n",list.size());
		Iterator ir = list.iterator();
		while (ir.hasNext()) {
			Student object = (Student) ir.next(); // list 안에있는 실제값이 어떤 타입으로 선언되어있는지 확인
			object.dispInfo();
			}
		}
		
	

}
