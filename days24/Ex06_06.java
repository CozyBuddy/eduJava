package days24;

import java.util.ArrayList;

/**
 * @author user
 * @date 2024. 2. 1. 오후 3:22:09
 * @subject [와일드 카드]
 * @contents
 */
public class Ex06_06 {
	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox();
		FruitBox<Apple> appleBox = new FruitBox();
		FruitBox<Grape> grapeBox = new FruitBox();
		// 일반메서드로 호출 
		Juice juice = Juicer.makeJuice(fruitBox);
		juice = Juicer.makeJuice(appleBox);
		//juice = Juicer.makeJuice(grapeBox);
		// makeJuice()를 제네릭 메서드로 선언(수정) -> 호출하는 방법이 다르다.
		//juice = Juicer.<Grape>makeJuice(grapeBox);
		juice = Juicer.makeJuice(grapeBox); // <> 생략가능
	}
}
class Fruit {
	public String toString() {
		return "Fruit";
	}
}
class Apple extends Fruit {
	public String toString() {
		return "Apple";
	}
}
class Grape extends Fruit {
	public String toString() {
		return "Grape";
	}
}


// 먹을 수 있는 과일만 T 타입으로 제네릭 클래스 선언
// T 모든 타입
class Box05<T> {
	ArrayList<T> list = new ArrayList<>();
	void add(T item) { this.list.add(item);}
	int size() { return this.list.size();}
	T get(int i) { return this.list.get(i);}
	public String toString() { return this.list.toString();}
	
}
class FruitBox<T extends Fruit> extends Box05<T>{
	//
	
}
// [쥬스 클래스] , 제네릭 클래스 X 
class Juice {
	
}
// [쥬스 만드는 기기]
// 과일(사과, 포도) 재료 --> Juice 생산
class Juicer {
	//메서드 오버로딩 조건에 맞지가 않음 제네릭만 다르면
	// 제네릭형태의 매개변수는 오버로딩 조건에 해당하지 않음.
	// 해결책은 와일드카드 (기호 ? ) ? => 모든 타입 == Object와 같은 의미
	// 사용예시 <?> 모든타입, 타입 제한 없음.
	//	<? extends T> T와 T를 물려받은 자식타입이 가능
	//  <? super T> T와 그 조상들 가능
	/*static Juice makeJuice(FruitBox<? extends Fruit> box) {
		return new Juice();
	}*/
	//위의 일반 static 메서드를 제네릭 메서드로 변경
	// [제네릭 메서드]
	// 	ㄴ메서드의 선언부에 제네릭 타입이 선언된 메서드를 제네릭 메서드라고 함.
	//	ㄴ선언 형식
	//	public static <T> 리턴자료형 제네릭메서드명 (매개변수 ..){
    //  }
	static <T extends Fruit> Juice makeJuice(FruitBox<T> box) {
		return new Juice();
	}
	/*static Juice makeJuice(FruitBox<Fruit> box) {
		return new Juice();
	}
	static Juice makeJuice(FruitBox<Apple> box) {
		return new Juice();
	}
	static Juice makeJuice(FruitBox<Grape> box) {
		return new Juice();
	}*/
}
