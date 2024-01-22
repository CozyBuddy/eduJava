package days02;

/**
 * @author user
 * @date 2024. 1. 2. 오전 11:20:03
 */
public class Ex03 {
	public static void main(String[] args) {
		System.out.println("안녕하세요. 홍길동입니다.");
		// Alt+Shift +Y
		String name = "권맑음"; //%s
		int age = 32; //%d
		final double PI = 3.141592; //%f
		char grade = 'A'; //%c
		
		System.out.printf("이름 : %s, 나이 : %d ,PI : %f , 등급 :%c\n",name,age,PI,grade);
		
		/*
		 *  [식별자(변수명) 명명 규칙]
		 *  1. 자바는 대소문자 구분한다. ex)String name; -> sout(Name)
		 *  2. 키워드(예약어)를 사용x ex) int char;
		 *  3. $ ,_ 특수문자만 사용 가능 ex)int $age;
		int _height ;
		 *  4. 숫자로 시작할 수 없다. ex) int 1kor; X , int kor1;
		 */
		
		// String firstName ; ->권장
		
	}

}
