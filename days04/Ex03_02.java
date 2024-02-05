package days04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author user
 * @date 2024. 1. 4. 오전 11:45:31
 * @subject 이름,국,영,수,총,평  -> BufferedReader -> 한 번에 입력 받아서 처리 예정
 * @contents  BufferedReader 사용한 예제 (내일 복습 나옴)
 * 
 *  			배열 사용 
 */
public class Ex03_02 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name;
		byte kor,eng,math;
		short tot; 
		double avg;
		//Scanner scanner = new Scanner(System.in); // 눌러서 작동시키고 다시 눌러서 종료시키는 기능을
		System.out.print("이름,국어,영어 ,수학 입력 >");
		String input = br.readLine(); // 홍길동,89,78,56
		// 콤마(,)를 구분자로 input문자열을 잘라내기 해야함 -> "홍길동" "89" "78" "56"
		// String String.format(String format, Object args)
		// boolean String.equals(비교할문자열)
		// String.split(구분자) -> 구분자로 자르는 함수 -> 배열로 return 해서 배열로 선언해야함.
		String regex = "\\s*,\\s*";
		String data[] = input.split(regex); //regex - > regular expression 정규식
		
		name = data[0];
		kor = Byte.parseByte(data[1]);
		eng = Byte.parseByte(data[2]);
		math = Byte.parseByte(data[3]);
		
		//1
		// 강제 형변환 1번째 경우
		tot = (short)(kor + math +eng) ; // int 보다 작은 자료형은 연산할 때 cpu가 int 자료형으로 처리해서 연산
		avg = (double)tot/3;
		
		System.out.printf("%s님은 국:%d 수:%d 영:%d 총점 :%d 평균 : %.2f",name,kor,math,eng,tot,avg);
		
		
	}

}
