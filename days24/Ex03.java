package days24;

 class Ex03 {
	public static void main(String[] args) {
		/*
		 * [중첩 클래스와 중첩 인터페이스]
		 * 1. 클래스와 클래스들 간의 관계
		 * 		ㄴhas-a (포함 관계) Car- Engine
		 * 		ㄴ is -a (상속 관계) 
		 * 2.가정)
		 *  	어떤 클래스가 특정 클래스만 관계가 있다면
		 *  	Engine Car 
		 *  
		 *  Car 클래스 내부(안)에 Engine 클래스를 선언한다.
		 *  3.중첩 클래스 특징
		 *  	1)장점 : 두 클래스의 (필드)멤버들을 서로 쉽게 접근할 수 있다.
		 *  	2)불필요한 관계 클래스를 감춤으로써 코드의 복잡성을 줄일 수 있다.
		 *  4. 중첩 클래스의 종류 : 선언 위치에 따라 구분 
		 *  	1) 클래스의 멤버 위치에 선언
		 *  		(1) 인스턴스 멤버 클래스
		 *  		(2) 정적(static) 멤버 클래스
		 *  	2) 메서드 내부 선언
		 *  		(3)로컬(local)클래스 - 메서드가 실행시에만 사용할 수 있음.
		 *  		(4)익명(Anonymous) 클래스 ***(중요)
		 *  		
		 *   
		 *  5.중첩 인터페이스(클래스 안에서 인터페이스를 선언) 
		 *  	
		 *   
		 */
	}

}
class A{
	private int age;
	//메서드
	void disp() {
		//메서드 안에 선언된 클래스 : 로컬 클래스
		// 로컬클래스는 접근지정자 사용불가
		class D {
			//static 필드,메서드는 선언할 수 없다.
			D(){}
			int d1;
			void test() {
				
			}
		}
		D obj = new D();
		obj.test(); // 메서드 안에서 객체 생성하고 사용함.ㄴ
	}
	// (2)정적(static) 멤버 클래스
	// 모든 필드,메서드를 선언할 수 있음.
	private static class C{
		int c1; // 인스턴스 변수
		static int sc1; //클래스변수
		void test1() {} //인스턴스 메서드
		static void test2(){} //클래스메서드
		
		/*
		 * C 객체 호출방법
		 * 
		 * A.C c = new A.C();
		 * c.c1 = 100;
		 * c.test1();
		 * A.C sc1 = 100;
		 * A.C.test2();
		 * 
		 */
	}
	//(1)인스턴스 멤버 클래스
	//A객체가 생성되어야지 B 중첩 클래스를 사용할 수 있음.
	class B{
		B(){}
		int b1;
		void test() {
			//static 필드,메서드를 선언할 수 없다.
			
			/*
			 * B클래스 호출하는 방법
			 * A a = new A();
			 * A.B b = a.new B();
			 * b.b1 =100;
			 * b.test();
			 */
		}
	}
	
}

