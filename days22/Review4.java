package days22;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import days14.Student;

public class Review4 {
	public static void main(String[] args) throws IOException {
		ArrayList class1 = new ArrayList();
		ArrayList class2 = new ArrayList();
		ArrayList class3 = new ArrayList();
		
		ArrayList major = new ArrayList();
		major.add(class1);
		major.add(class2);
		major.add(class3);
		
		Scanner sc = new Scanner(System.in);
		int kor,math,eng,tot,rank,wrank;
		double avg;
		char con;
		
		do {
			System.out.print("반을 입력하세요");
			int ban = sc.nextInt();
			System.out.print("학생의 이름 ,국어,수학,영어 점수를 입력하세요");
			String name = sc.next();
		     kor = sc.nextInt();
			 math = sc.nextInt();
			eng = sc.nextInt();
			tot = kor+math+eng;
			avg = (double)tot/3;
			rank =1;
			wrank =1;
			Student s = new Student(name, kor, eng, math, tot, rank, avg, wrank);
			
			((ArrayList) major.get(ban-1)).add(s);
			
			System.out.print("계속 진행하려면 Y를 눌러주세요");
			con = (char) System.in.read();
			System.in.skip(System.in.available());
			
		} while (Character.toUpperCase(con)=='Y');
		disInfo(major);
	}

	private static void disInfo(ArrayList major) {
		Iterator ir = major.iterator();
		while (ir.hasNext()) {
			ArrayList object = (ArrayList) ir.next();
			Iterator ir2 = object.iterator();
			while (ir2.hasNext()) {
				Student object2 = (Student) ir2.next();
				object2.dispInfo();
			}
			
		}
		
	}

}
