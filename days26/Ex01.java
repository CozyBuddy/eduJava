package days26;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Ex01 {
	public static void main(String[] args) throws IOException {
		 int [] score = {
	         // 번호 국   영   수
	            1, 100, 90, 90,    // 4*4
	            2, 70 , 90,100,
	            3, 100,100,100,
	            4, 70 , 60, 80,
	            5, 70 , 90,100
	      };
		 String name = ".\\days26\\score.dat";
		 String mode = "rw";
		 
		try( RandomAccessFile raf = new RandomAccessFile(name, mode);) {
			for (int i = 0; i < score.length; i++) {
				long fp = raf.getFilePointer();
				System.out.printf("포인터 : %d - [%d]",fp,score[i]);
				raf.writeInt(score[i]);
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.print(" 엔터치면 진행");
		System.in.read();
		System.in.skip(System.in.available());
		
		// 모든 학생의 번호,국,영,수 성적정보를 출력 .. (score.dat)
		int no ,kor,eng,math;
		int tot;
		double avg;
		
		try( RandomAccessFile raf = new RandomAccessFile(name, mode);) {
			int studentNumber = score.length/4;
			for (int i = 0; i < studentNumber; i++) {
				no = raf.readInt(); // 1
				kor =raf.readInt(); // 1 번의 kor
				eng =raf.readInt(); // 1 번의 eng
				math = raf.readInt(); // 1 번의 math
				tot = kor + eng+ math;
				avg = (double)tot/3;
				System.out.printf("번호 : %d , 국어 : %d  영어 : %d 수학 : %d, 총점 %d, 평균 : %f" ,no,kor,eng,math,tot,avg);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 문제
		// 3번 학생의수학점수 (100-> 20)점 수정.
		// 수정된 3번 학생의 성적정보를 출력
		System.out.println("end");
		RandomAccessFile raf = new RandomAccessFile(name,mode);
		raf.seek(44); // 포인터 위치값은 바이트 각각의 바이트값 한 int당 4바이트
		
		raf.writeInt(20);
		raf.seek(32);
			int studentNumber = score.length/4;
			
				no = raf.readInt(); // 1
				kor =raf.readInt(); // 1 번의 kor
				eng =raf.readInt(); // 1 번의 eng
				math = raf.readInt(); // 1 번의 math
				tot = kor + eng+ math;
				avg = (double)tot/3;
				System.out.printf("번호 : %d , 국어 : %d  영어 : %d 수학 : %d, 총점 %d, 평균 : %f" ,no,kor,eng,math,tot,avg);

			
			
		
	}
	
}
	/*public static void main(String[] args) {
		int n =3 ;
		int s =9 ;
		
		solution(n,s);
	}
	

	private static List solution(int n, int s) {
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		
		generateSet(al,new ArrayList<Integer>(), n, s,1);
		
		return al ;
		
		
	}


	private static void generateSet(ArrayList<ArrayList<Integer>> al, ArrayList<Integer> currentlist, int n, int s,int start) {
		if (s==0 && n==0) {
			al.add(currentlist);
		}
		for (int i = start; i <= 9; i++) {
            if (n > 0 && s - i >= 0) {
                currentlist.add(i);
                generateSet(al, currentlist, n - 1, s - i, i + 1);
                currentlist.remove(currentlist.size() - 1);
                Arrays.fill
            }
		
	}
	}
}

*/

	


