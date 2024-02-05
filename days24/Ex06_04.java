package days24;

import java.util.ArrayList;

/**
 * @author user
 * @date 2024. 2. 1. 오후 2:41:52
 * @subject  [제네릭클래스의 객체 생성과 사용]
 * @contents	과일(Fruit)
 * 					ㄴ 사과(Apple)
 * 					ㄴ 포도(Grape) =>3개 클래스 작성
 * 			장난감(Toy)
 * 
 * 			위의 물건(상품)을 담을 수 있는 상자(Box3) 제네릭 클래스
 * 			
 */
public class Ex06_04 {
	public static void main(String[] args) {
		// 제네릭 클래스의 객체 생성
		//Box03<Fruit> fruitBox = new Box03();
	/*	Box03<Apple> appleBox = new Box03();
		Box03<Grape> GrapeBox = new Box03();
		Box03<Toy> ToyBox = new Box03();
		
		//Box03<Apple> box1= new Box03<Grape>();//Type mismatch: cannot convert from Box03<Grape> to Box03<Apple>
		//Box03<Apple> box1 = new Box03<Grape>();
		//Box03<Apple> box1 = new Box03<Fruit>();
		//Box03<Fruit> box1 = new Box03<Grape>(); // 상속과 상관없이 자동형변환이 안됨.
		
		Box03<Fruit> fruitBox = new Box03();
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple()); // 상속 관계에 있는 건 객체 생성 가능
		fruitBox.add(new Grape()); // 상속 관계에 있는 건 객체 생성 가능
		//fruitBox.add(new Toy());  상속 관계가 없으면 안됨.
	}
	*/

}
/*class Fruit {
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
class Toy {
	public String toString() {
		return "Toy";
	}
}
// 상자(Box) 제네릭 클래스 선언
class Box03<T> {
	ArrayList<T> list = new ArrayList<>();
	void add(T item) { this.list.add(item);}
	int size() { return this.list.size();}
	T get(int i) { return this.list.get(i);}
	public String toString() { return this.list.toString();}
	
}
*/