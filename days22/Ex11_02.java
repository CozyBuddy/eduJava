package days22;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import days11.Ex05_03;
import days14.Student;

/**
 * @author user
 * @date 2024. 1. 30. 오후 3:38:26
 * @subject 시험
 * @contents
 */
public class Ex11_02 {
	public static void main(String[] args) throws IOException {
		// 1반 30명 *3반
		// X Student students[][] = new Student[][]
		// --> 컬렉션 클래스 사용 수정
		
		ArrayList class1list = new ArrayList();
		ArrayList class2list = new ArrayList();
		ArrayList class3list = new ArrayList();
		
		ArrayList sistList = new ArrayList();
		sistList.add(class1list);
		sistList.add(class2list);
		sistList.add(class3list);
		
		//입력
		String name;
		int kor,math,eng,tot,rank,wrank; 
		double avg;
		Scanner sc = new Scanner(System.in);
		//Student s = new Student();
		int ban;// 입력받는 반
		char con;
		do {
			System.out.printf("반 입력>");
			ban = sc.nextInt();
			System.out.printf("%d반의 [%d]번 학생 이름, 국어,수학,영어 성적을 입력하세요>",ban,(((ArrayList) sistList.get(ban-1)).size()+1));
			name = sc.next();
			kor = sc.nextInt();
			math = sc.nextInt();
			eng = sc.nextInt();
			tot = kor +math+eng;
			avg = (double)tot/3;
			rank=1;
			wrank=1;
			Student s = new Student(name, kor,eng,math,tot,rank, avg, wrank);
			((ArrayList) sistList.get(ban-1)).add(s);
			System.out.print("계속 하려면 Y를 입력하세요.");
			con = (char)System.in.read();
			System.in.skip(System.in.available());
		} while (Character.toUpperCase(con)=='Y');
		
		//출력
	    disStudentInfo(sistList);
		
		

	}

	private static void disStudentInfo(ArrayList sistList) {
		//int totalStudents = sistList.stream().mapToInt(ArrayList::size).sum(); // IntStream 객체 생성
		
		Iterator ir = sistList.iterator();
		int a = 1;
		int count = 0;
		while (ir.hasNext()) {
			ArrayList object = (ArrayList) ir.next();
			System.out.println("-".repeat(60));
			System.out.print(a+"반"+object.size()+"명");
			a++;
			Iterator ir2 = object.iterator();
			while (ir2.hasNext()) {
				Student object2 = (Student) ir2.next();
				object2.dispInfo();
				count++;
				
			
			}
			
			
			
		}
		System.out.printf("총 학생 수 : %d",count);
		
	}

}
