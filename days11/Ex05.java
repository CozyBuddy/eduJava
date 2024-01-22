package days11;

import java.util.Scanner;

/**
 * @author user
 * @date 2024. 1. 15. 오전 11:42:30
 * @subject
 * @contents
 */
public class Ex05 {
	public static void main(String[] args) {
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
		
		System.out.print("이름 ,국어,영어,수학 입력>");
		name = sc.next();
		kor = sc.nextInt();
		eng = sc.nextInt();
		math = sc.nextInt();
		
		tot = kor +eng+math;
		avg = (double)tot /3;
		rank = 1;
		
		//첫번째 학생의 성적 정보
		names[0] =name;
		kors[0] =kor;
		engs[0] =eng;
		maths[0] =math;
		tots[0] =tot;
		avgs[0] =avg;
		
		count ++; // 1명
		do {
			
		} while (count==STUDENT_COUNT);
		
		
	}

}
