package days22;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import days14.Student;

public class Review1 {
	public static void main(String[] args) throws IOException {
		ArrayList class1 = new ArrayList();
		ArrayList class2 = new ArrayList();
		ArrayList class3 = new ArrayList();
		
		ArrayList sist = new ArrayList();
		sist.add(class1);
		sist.add(class2);
		sist.add(class3);
		
		Scanner sc = new Scanner(System.in);
		String name ;
		int kor,math,eng,tot,rank,wrank;
		int ban;
		double avg;
		char con;
		
		do {
			System.out.print("반을 입력하세요");
			ban = sc.nextInt();
			System.out.printf("[%d]반 [%d]번 학생 이름 ,국어,수학,영어 점수를 입력하세요",ban,((ArrayList) sist.get(ban-1)).size()+1);
			name = sc.next();
			kor = sc.nextInt();
			math = sc.nextInt();
			eng = sc.nextInt();
			tot = kor+math+eng;
			avg = (double)tot/3;
			rank =1;
			wrank=1;
			
			Student s = new Student(name,kor, eng,math,tot,rank,avg,wrank);
			((ArrayList)sist.get(ban-1)).add(s);
			
			System.out.print("계속 하려면 Y를 누르세요");
			con = (char) System.in.read();
			System.in.skip(System.in.available());
			
		} while ('Y'== Character.toUpperCase(con));
		proRank(class1);
		proRank(class2);
		proRank(class3);
		disInfo(sist);
	}

	private static void proRank(ArrayList sist) {
		Iterator<Student> ir = sist.iterator();
		while (ir.hasNext()) {
		Student sist1 = (Student)ir.next();
		sist1.rank=1;
		Iterator<Student> ir2 = sist.iterator();
		while (ir2.hasNext()) {
			Student student = (Student) ir2.next();
			if (sist1.tot < student.tot) {
					sist1.rank++;
			}
		}
			
		}
		
	}

	private static void disInfo(ArrayList sist) {
		Iterator<ArrayList> ir = sist.iterator();
				while (ir.hasNext()) {
				ArrayList sist1 = (ArrayList) ir.next();
				Iterator<Student> ir2 = sist1.iterator();
				while (ir2.hasNext()) {
					Student student = (Student) ir2.next();
					student.dispInfo();
				}
					
				}
		
		
		
		};
		
	}


