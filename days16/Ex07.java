package days16;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author user
 * @date 2024. 1. 22. 오후 12:28:16
 * @subject 오버로딩(overloading) 과 오버라이딩(overriding) 재정의함수 
 * @contents	중복함수 
 * 				drawLine()
 * 				drawLine(int n)
 * 				drawLine(int n ,Style s)
 * 				오버라이딩 ? Super클래스로부터 상속받은 메서드를 같은 메서드명과 같은 매개변수로 Super클래스의 메서드를 대체하는 것.
 * 				Override 사전적 의미 = 위에 덮어쓰다.
 * 
 * 				[오버라이딩의 조건] 
 * 				1. 메서드명 수정X
 * 				2. 매개변수 동일
 * 				3. 리턴타입 동일
 * 				4. 접근지정자는 부모의 접근지정자 범위보다 같거나 넓어야 함.
 * 				5. 부모클래스의 예외보다 더 넓은 범위의 예외를 선언할수 없다.
 * 				6. 부모클래스의 기타제어자를 자식클래스가 변경할 수 없음. //인스턴스 메서드 static 메서드 변경 X
 * 				
 */
public class Ex07 {
	public static void main(String[] args) {
		
	}

}
class Parent {
	int print(String n , int a) throws Exception{
		return 100;
	}
}
class Child extends Parent {
	@Override
	int print(String n , int a) throws IOException , SQLException {
		return 100+a;
	}
	//오버로딩
	/*int print(String n ) {
		return 100;
	}*/
	/*int print(String n , int a) {
		return 100;
	}*/
}