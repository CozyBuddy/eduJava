package days18;
import java.lang.*; // 컴파일러가 자동으로 추가 워낙 기본적인 클래스여서
/**
 * @author user
 * @date 2024. 1. 24. 오전 10:27:56
 * @subject java.lang 패키지 - 자바 가장 기본이 되는 클래스 
 * @contents 유용한 클래스(java.util 패키지)
 * 					Object.equals() + Overriding
 */
public class Ex02 {
	public static void main(String[] args) {
		//[java.lang.Object 클래스]
		// 1. 모든 클래스의 최상위 부모클래스 
		Item item1 = new Item(10);
		Item item2 = new Item(10);
		//       			객체  == 객체   참조주솟값 비교
		System.out.println(item1 == item2);
		// Object.equals () 실제값을 비교
		System.out.println(item1.equals(item2));
		//item1.//아무것도 멤버가 없어도 항상 Object가 최상위 클래스로 존재해서 래퍼클래스들이 나타남.
		item2 = item1 ; //객체 복사 
		System.out.println(item1 == item2);
		System.out.println(item1.equals(item2));
	}



}
class Item extends Object{
	//필드
	int value;
	//생성자1
	public Item(int value) {
		this.value = value;
	}

	// 다른 객체들을 비교할 때 value값만 같으면 
	// 같다라고 처리
	//			item1.equals(item2)
	@Override
	public boolean equals(Object obj) { //여기서 this는 호출한 객체를 지칭.
		//this.value == item1.value
		if (obj instanceof Item) {
			// down casting
			Item item2 = (Item) obj;
			if (this.value == item2.value) return true; 
		} 
		return false;
	}
}


