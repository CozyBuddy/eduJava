package days19;

import days15.Person;
import days15.Point;

/**
 * @author user
 * @date 2024. 1. 25. 오후 2:04:33
 * @subject
 * @contents
 */
public class Ex07 {
	public static void main(String[] args) {
		//[자동(auto) boxing/unboxing]
		// 기본형 => 래퍼클래스
		int i = 100;
		//auto boxing 
		Integer j=i; //j는 객체 <-- i는 기본형 
		// j 객체 -->k 기본형 변환 (오토 언박싱)
		int k = j;
		
		test(new Person());
		test(new Point());
		// 모든 자료형이 Object 이기 때문에 모든 자료형을 사용할 수 있음.
		test(1); //전부 오토박싱 되서 래퍼클래스로 자동형변환 
		test(true);
		test('a');
		test(3.14);
		test("string");
		
		
	}
	public static Object test(Object o) {
		
		return null;
	}

}
