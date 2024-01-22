package days12;

import java.io.IOException;
import java.util.Scanner;

public class Review4 {
	public static void main(String[] args) throws IOException {
		final int STUDENT_COUNT = 30;
		final int CLASS_COUNT = 3;		
		String [][] names = new String[CLASS_COUNT][STUDENT_COUNT];
		int [][][] infos = new int[CLASS_COUNT][STUDENT_COUNT][6];
		double [][] avgs = new double[CLASS_COUNT][STUDENT_COUNT];
		
		char con = 'y'; 	
		int [] counts = new int[CLASS_COUNT];

		String name;
		int kor, eng, mat, tot, rank, wrank;
		double avg;		
		int classnumber;
		int count =0;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("반을 입력하세요");
			classnumber = scanner.nextInt();
			System.out.println("학생이름을 입력하세요");
			name = scanner.next();
			System.out.println("국어점수를 입력하세요");
			kor = scanner.nextInt();
			System.out.println("수학점수를 입력하세요");
			mat = scanner.nextInt();
			System.out.println("영어점수를 입력하세요");
			eng = scanner.nextInt();
			names[classnumber][count] = name ;
			infos[classnumber][count][0] = kor;
			infos[classnumber][count][1] = mat;
			infos[classnumber][count][2] = eng;
			infos[classnumber][count++][3] = kor+mat+eng;
			System.out.println("계속 하시려면 Y를 입력하세요.");
			con = (char)System.in.read();
			System.in.skip(System.in.available());
		} while (Character.toUpperCase(con)=='Y');
		whatrank(infos);
		disinfo(infos,count,names);
		
		
	}

	private static void whatrank(int[][][] infos) {
		int b = 0;
		int a =1;
		for (int i = 0; i < infos.length; i++) {
			for (int j = 0; j < infos[i].length; j++) {
					if (infos[b][i][3]<infos[i][j][3]) {
						a++;
						infos[i][j][4]=a;
				} else {

				}
			}
			b++;
			
			}
		
		
		
		
	}

	private static void disinfo(int[][][] infos,int count,String names[][]) {
		for (int i = 0; i < infos.length; i++) {
			for (int j = 0; j < infos[count].length; j++) {
				System.out.println(names[i][j]+"님의 정보"+ infos[i][j][0]+ " "+infos[i][j][1]+ " "+infos[i][j][2]+ " "+infos[i][j][3]+ " "+infos[i][j][4]+" "+ infos[i][j][5]);
			
			}
		}
		
	}

}
