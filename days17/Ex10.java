package days17;

/**
 * @author user
 * @date 2024. 1. 23. 오후 2:32:52
 * @subject
 * @contents
 */
public class Ex10 {
	public static void main(String[] args) {
		//인터페이스 멤버
		//  ㄴ 상수 
		//  ㄴ 추상메서드
		// JDK 1.8 이후 
		// 	ㄴ default 메서드 *** 
		// 	ㄴ static 메서드
		
		// 5년 지난 후... Ia 인터페이스에 추상메서드를 추가 하고 싶음.
	}

}
interface Ia{
	//3개 추상메서드 선언.
	default void fiveTest() { // default 라고 추가하면 implement하는 클래스들에 영향을 안 주고 메서드를 추가하는 방법.
		// 만약에 클래스에 있는 메서드랑 명이 같다면 혹은충돌되면 default 메서드는 무시됨.
		// 여러 인터페이스를 구현하면 default 메서드와 충돌나면 =>충돌나는 default 메서드를 오버라이딩 하면 해결.
		System.out.println("몸체 구현 완벽한 메서드 추가");
	}
	static void statictest() {
		System.out.println("몸체 구현"); // Ia.statictest() 로 구현 가능
	}
}
interface Ib{
	//1개 추상메서드 선언
}
interface Iab extends Ia,Ib{
	//4개 추상메서드 상속
	//1개 추가 추상메서드 선언
}
class Aa implements Ia {
	//3개 추상메서드 오버라이딩(재정의) 해야함.
}
class Bb extends Aa {
	//3개의 재정의된 메서드를 상속
}
class Cc implements Iab{
	//총 5개 메서드 오버라이딩 예정
	
}
