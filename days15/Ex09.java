package days15;

/**
 * @author user
 * @date 2024. 1. 19. 오후 4:12:45
 * @subject
 * @contents
 */
public class Ex09 {
	
	// [멤버변수 == 필드]
	// 1)인스턴스 변수  // 필드를 선언할때 멤버 변수에 값을 할당하는 것을 명시적 초기화
	String name="홍길동";
	int age=0;
	boolean gender=true;
	// 2)클래스 변수
	static double rate=0.09;
	
	static {
		// [클래스 초기화 블럭]
		// 클래스 변수를 초기화 하기 위한 블럭.
		// 객체 생성과 상관없이 프로그램이 시작할때 한 번 static 초기화 블럭은 실행됨.
		rate = 0.07;
		// 인스턴스 변수 초기화 X static 만 가능
		// age =0;
		System.out.println("클래스 초기화 블럭 호출됨");
	}
	//[생성자]
	{
		this.name = "익명";
		System.out.println("인스턴스 초기화 블럭 호출됨");
	}
	Ex09() {
		//this.name = "익명";
		System.out.println("디폴트 생성자 호출됨");
	}
	Ex09(int age) {
		//this.name = "익명";
		this.age = age;
	}
	Ex09(int age,boolean gender) {
		//this.name = "익명";
		this.age = age;
		this.gender = gender;
	}
	public static void main(String[] args) {
		
		Ex09 obj1 = new Ex09();
		Ex09 obj2 = new Ex09(20);
		System.out.println(obj1.name); // 익명
		System.out.println(Ex09.rate);
		//[변수의 초기화]
		/*
		 * 1.지역변수 : 반드시 초기화해야 사용할 수 있음
		 * 2.인스턴스 변수
		 * 3.클래스(static) 변수
		 * 
		 * [멤버 변수 초기화 하는 방법]
		 * 1. 명시적 초기화
		 * 2. 생성자 초기화
		 * 3. 초기화 블럭
		 * 		ㄴ 인스턴스 초기화 블럭
		 * 		ㄴ 클래스(static) 초기화 블럭
		 */
	}

}
