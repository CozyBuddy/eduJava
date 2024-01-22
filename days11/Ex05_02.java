package days11;

import java.io.IOException;
import java.util.Scanner;
/**
 * @author user
 * @date 2024. 1. 15. 오후 12:10:02
 * @subject
 * @contents
 */
public class Ex05_02 {
	public static void main(String[] args) throws IOException {
		//한 반에 최대 23명 학생의 
		// 성적 처리를 배열을 사용해서 입력
		//성적 처리(국,영,수,총,평균,등수)
		//1. 입력 - 이름,국어,영어,수학
		//2. 처리 - 총점, 평균
		//3. 파일 입출력, DB입출력 X
		
		String name;
		int kor,eng,math,tot,rank;
		double avg;
		final int STUDENT_COUNT = 23;
		String names[] = new String [STUDENT_COUNT];
		int kors[] = new int[STUDENT_COUNT];
		int engs[] = new int[STUDENT_COUNT];
		int maths[] = new int[STUDENT_COUNT];
		int ranks[] = new int[STUDENT_COUNT];
		double avgs[] = new double[STUDENT_COUNT];
		int tots[] = new int[STUDENT_COUNT];
		
		//15명
		Scanner sc = new Scanner(System.in);
		int count = 0; // 실제 입력받은 학생수
		char con = 'y';
		
		do {
			System.out.printf("%d번 학생 이름,국어,영어,수학 입력>",count+1);
			name = sc.next();
			kor = sc.nextInt();
			eng = sc.nextInt();
			math = sc.nextInt();
			
			tot = kor +eng+math;
			avg = (double)tot /3;
			rank = 1;
			
			//첫번째 학생의 성적 정보
			names[count] =name;
			kors[count] =kor;
			engs[count] =eng;
			maths[count] =math;
			tots[count] =tot;
			avgs[count] =avg;
			
			count ++; // 1명
			System.out.print("y를 누르면 계속합니다.");
			con = (char)System.in.read();
			System.in.skip(System.in.available());
			
		} while (Character.toUpperCase(con)=='Y');
		
		disStudentInfo(names,kors,engs,maths,tots,avgs,ranks,count);
		
		
	}

	private static void disStudentInfo(String[] names, int[] kors, int[] engs, int[] maths, int[] tots, double[] avgs,
			int[] ranks, int count) {
		
		System.out.printf("총 %d명 \n",count);
		for (int i = 0; i < count; i++) {
			System.out.printf("%d 번 \t%s\t%d\t%d\t%d\t%d\t%.2f\t%d등\n",i+1,names[i],kors[i],engs[i],maths[i],tots[i],avgs[i],ranks[i]);
		}
	}

}
