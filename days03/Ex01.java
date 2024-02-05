package days03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01 {
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String name;
			byte kor,eng,math;
			short tot; 
			double avg;
			//Scanner scanner = new Scanner(System.in);
			
			System.out.println("이름을 입력하세요 >");
			name = br.readLine();
			//String name = scanner.nextLine();
			
			System.out.println("국어 점수를 입력하세요>");
			 kor = Byte.parseByte(br.readLine());
			 
			System.out.println("수학 점수를 입력하세요>");
			math = Byte.parseByte(br.readLine());
			
			System.out.println("영어 점수를 입력하세요>");
			eng = Byte.parseByte(br.readLine());
			
			// 강제 형변환 1번째 경우
			tot = (short)(kor + math +eng) ; // int 보다 작은 자료형은 연산할 때 cpu가 int 자료형으로 처리해서 연산
			avg = (double)tot/3;
			
			System.out.printf("%s님은 국:%d 수:%d 영:%d 총점 :%d 평균 : %.2f",name,kor,math,eng,tot,avg);
			
			
		}

	}


