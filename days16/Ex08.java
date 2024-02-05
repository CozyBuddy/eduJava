package days16;

//static import문
import static java.lang.Math.random;
import static java.lang.Math.PI;
/**
 * @author user
 * @date 2024. 1. 22. 오후 2:01:08
 * @subject
 * @contents
 */
public class Ex08 {
	public static void main(String[] args) {
		/*
		 * 1.패키지(package)
		 *  	- 서로 관련이 있는 클래스,인터페이스들의 묶음.
		 *  	- 클래스를 효율적으로 관리하기 위해서
		 *  	예)java.io 패키지
		 *  			input  입력
		 *  			output 출력
		 *  	-days14.Point 클래스
		 *  	 days15.Point 클래스
		 *  	 동일한 클래스명일지라도 충돌을 막기 위해서 패키지를 사용.
		 *  	 예) 개발자가 구현한 클래스명과 다른 개발자가 구현한 클래스명이 동일할지라도 패키지명으로
		 *  		 충돌을 막고 구분해서 사용할 수 있음. 
		 *  
		 *   - 도메인명 = 패키지명 ->각 개발자들의 충돌 방지
		 *   naver.com  // sist.org
		 *   -패키지는 물리적으로 디렉토리(폴더) 생성
		 *   예)java.lang.System 클래스
		 *   
		 *   	java 폴더
		 *   		ㄴ lang폴더
		 *   			ㄴ System.class 파일로 존재
		 *   - 클래스를 선언할 때 소스파일의 첫 번째 라인(문장)에 패키지를 선언한다.
		 *   - 패키지명은 소문자로 작성.
		 *   - 소스파일에 다른 패키지의 클래스를 사용하려면 import 문을 사용해서
		 *   - 클래스가 포함된 패키지명을 적어야 함.
		 *   - [클래스의 풀네임(full name)]  -> 패키지명.클래스명
		 *   - import문이 없는 경우 ctrl + Shift +o 단축키 - > 자동으로 필요한 import구문 추가.
		 *   - import java.io.* ; -> java.io 패키지 안의 모든 클래스,인터페이스 등을 import 한다는 뜻
		 *   - 
		 *   	
		 */
		System.out.println(random());
		System.out.println(PI);
		
	}

}
