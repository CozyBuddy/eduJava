package days14;

import java.io.IOException;
import java.util.Scanner;

public class Review1 {
	public static void main(String[] args) throws IOException {
		

	  final int STUDENT_COUNT = 23;
      String name;
      int kor,eng,math,tot,rank;
      double avg;
      char con='Y';
      Student student[] = new Student[STUDENT_COUNT];
     
      int count = 0;
      do {
    	  student[count] = new Student();
          Scanner sc = new Scanner(System.in);
          System.out.print("학생 이름,국어,수학,영어 점수를 입력하세요.>");
          name = sc.next();
          kor = sc.nextInt();
          math = sc.nextInt();
          eng = sc.nextInt();
          tot = kor+math+eng;
          avg = tot/3;
          

          student[count].name = name;
          student[count].kor = kor;
          student[count].math = math;
          student[count].eng = eng;
          student[count].tot = tot;
          student[count].avg = avg;

          count++;

          System.out.print("계속하려면 Y를 입력하세요.");
          con = (char)System.in.read();
          System.in.skip(System.in.available());

      } while (Character.toUpperCase(con)=='Y');
      proRank(student,count);
      disinfo(student,count);

  }

  private static void proRank(Student[] student, int count) {
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				if (student[i].tot <student[j].tot) {
					 student[i].rank +=1;
				} else {

				}
			}
		}
	}

private static void disinfo(Student[] student,int count) {
	  for (int i = 0; i < count; i++) {
		System.out.printf("%s 님의 성적은 국어 %d점 수학 %d점 영어 %d점 이고 총점은 %d 평균은 %.2f점 등수는 %d등",student[i].name,
				student[i].kor,student[i].math ,student[i].eng , student[i].tot ,student[i].avg,student[i].rank);
		System.out.println();
	}
	  
  }
  
}



