package days12;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author user
 * @date 2024. 1. 16. 오전 11:01:52
 * @subject 1차원 배열 -> 2차원 배열로 변경.
 * @contents 내일 복습 문제
 */
public class Ex03 {
	public static void main(String[] args) throws IOException {
		// 한 반에 최대 23명 학생의
		// 성적 처리를 배열을 사용해서 입력
		// 성적 처리(국,영,수,총,평균,등수)
		// 1. 입력 - 이름,국어,영어,수학
		// 2. 처리 - 총점, 평균
		// 3. 파일 입출력, DB입출력 X

		String name;
		int kor, eng, math, tot, rank;
		double avg;
		final int STUDENT_COUNT = 23;
		String names[] = new String[STUDENT_COUNT];

		/*int kors[] = new int[STUDENT_COUNT];
		int engs[] = new int[STUDENT_COUNT]; 
		int maths[] = new int[STUDENT_COUNT]; 
		int ranks[] = new int[STUDENT_COUNT];
		int tots[] = new int[STUDENT_COUNT];*/

		int info[][] = new int[STUDENT_COUNT][5];
		double avgs[] = new double[STUDENT_COUNT];

		// 15명
		Scanner sc = new Scanner(System.in);
		int count = 0; // 실제 입력받은 학생수
		char con = 'y';

		do {
			System.out.printf("%d번 학생 이름,국어,영어,수학 입력>", count + 1);
			name = getName();
			kor = getScore();
			eng = getScore();
			math = getScore();

			tot = kor + eng + math;
			avg = (double) tot / 3;
			

			// infos 2차원배열 수정
			names[count] = name;
			info[count][0] = kor;
			info[count][1] = eng;
			info[count][2] = math;
			info[count][3] = tot;
			avgs[count] = avg;

			count++; // 1명
			System.out.print("y를 누르면 계속합니다.");
			con = (char) System.in.read();
			System.in.skip(System.in.available());

		} while (Character.toUpperCase(con) == 'Y');
		// 등수 출력
		procRank(info, count); // 총점으로 순위를 구분
		// 학생 정보 출력
		disStudentInfo(names, avgs, info, count);

	}

	private static void procRank(int[][] info, int count) {
		for (int i = 0; i < count; i++) {
			info[i][4] = 1;
			for (int j = 0; j < count; j++) {
				if (info[i][3] < info[j][3]) {
					info[i][4]++;
				} else {

				}
			}
			System.out.println(info[i][4]);
		}

	}

	private static String getName() {
		String lastNames[] = { "김", "이", "박", "최", "권", "홍" };
		Random rnd = new Random();

		int index = rnd.nextInt(lastNames.length); // 0<= int <6
		String lastName = lastNames[index];
		char firstNames[] = new char[2];
		for (int i = 0; i < firstNames.length; i++) {
			firstNames[i] = (char) (rnd.nextInt('힣' - '가') + '가');

		}
		String name = lastName + firstNames[0] + firstNames[1];
		return name;
	}

	private static void disStudentInfo(String[] names, double[] avgs, int info[][], int count) {

		System.out.printf("총 %d명 \n", count);
		for (int i = 0; i < count; i++) {
			System.out.printf("%d 번 \t%s\t%d\t%d\t%d\t%d\t%.2f\t%d등\n", i + 1, names[i], info[i][0], info[i][1],
					info[i][2], info[i][3], avgs[i], info[i][4]);
		}
	}

	// 랜덤하게 점수를 발생시키는 함수
	public static int getScore() {
		return (int) (Math.random() * 101);

	}

}
