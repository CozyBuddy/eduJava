
/**
 * @author user
 * @date 2024. 1. 23. 오전 9:34:55
 * @subject final 설명
 * @contents
 */
public class Ex01 {
	public static void main(String[] args) {
		
	}

}

class Parent{
	void test1() {}
	//상속된 후
	//자식클래스에서 재정의 할 수 없는 메서드
	final void test2() {}
}
class child extends Parent{
	//Cannot override the final method from Parent
	@Override
	void test1() {System.out.println("재정의 test1");}
	void test2() {System.out.println("재정의 test2");}
}
//최종(마지막) 클래스
final class FinalTest {
	// 인스턴스 변수(상수)
	//public final int MAX_SIZE =10 ; //명시적 초기화
	public final int MAX_SIZE  ; //
	
	//3.클래스 변수 / 클래스 생성과 동시에 메모리에 올라감.
	public final static int MIN_SIZE = 1;
	
	public FinalTest(int MAX_SIZE) {
		this.MAX_SIZE = MAX_SIZE;
		
	}
	void test1() {
		// 지역변수(상수) local variable
		final double PI = 3.14;
		
	}
	
	void test2(final int size) {
		
	}
}

//class Child extends FinalTest{}
