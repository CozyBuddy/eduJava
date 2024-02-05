package days17;

public class Ex02 {
	public static void main(String[] args) {
		//추상클래스 - 공통적인 멤버를 가진 클래스 설계 
		//			  Employee
		//객체를 생성할 수 없는 일종의 클래스 
		
		/*Child c = new Descendant();
		c.disA();
		c.disB();*/
		//[업캐스팅]
		//자식 객체 생성 후 부모 클래스에 참조
		Parent c = new Descendant();
		c.disA();
		c.disB();
	}

}
abstract class Parent{
	//필드
	//생성자
	//메서드
	//추상메서드 // body 몸체 {} 가 구현이 안된 메서드 (불완전한 메서드) abstract 키워드
	abstract void disA();
	abstract void disB();
}

abstract class Child extends Parent{ //The type Child must implement the inherited abstract method Parent.disA()
	//필드
	//생성자
	//메서드
	@Override
	void disA() {
		System.out.println("disA() 호출");
	}
}
class Descendant extends Child {

	@Override
	void disB() {
		System.out.println("disB() 호출");
		
	}
	
}
