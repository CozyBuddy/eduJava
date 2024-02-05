package days24;

import java.util.ArrayList;

/**
 * @author user
 * @date 2024. 2. 1. 오후 3:09:36
 * @subject [제한된 제네릭 클래스] 
 * @contents Box<T> Type 모든 자료형 제한된이라는건 T를 제한
 * 
 */
public class Ex06_05 {
	public static void main(String[] args) {
		//먹을 수 있는 과일로만 T를 제한
		/*Box04<Fruit> toyBox = new Box04();
		Box04<Grape> gBox = new Box04();
		Box04<빵> g1Box = new Box04();*/
		/*toyBox.add(new Fruit());
		toyBox.add(new Toy());
		toyBox.add(new Toy());*/
	}

}
/*class 빵 implements eatable{
	
}
interface eatable {
	
}
class Fruit implements eatable{
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
// 먹을 수 있는 과일만 T 타입으로 제네릭 클래스 선언
//class Box04<T> {
class Box04<T extends eatable> {
	ArrayList<T> list = new ArrayList<>();
	void add(T item) { this.list.add(item);}
	int size() { return this.list.size();}
	T get(int i) { return this.list.get(i);}
	public String toString() { return this.list.toString();}
	
}*/
