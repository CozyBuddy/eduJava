package days16;

public class Ex02 {
	public static void main(String[] args) {
		// [클래스들 간의 관계]
		// 1.has-a 관계
		// 	가지다
		// A 클래스가 B라는 클래스 가지는 관계
		//    객체          객체   포함
		//ex) 자동차			엔진  
		//    Car 			Engine 클래스 생성
		// 명시적 초기화
		// 2.is-a 관계 (상속 관계)
		Engine engine = new Engine();
		Car myCar = new Car();
		// DI(의존성 주입 ) dependence inject 방법 : setter
		//myCar.setEngine(engine);
		
		//DI(의존성 주입 ) dependence inject 방법: 생성자
		
		/*// 20년 사용하면 -> 엔진만 갈음
		engine = new Engine();
		myCar.setEngine(engine);*/
		// 속도 출력
		
		int currentSpeed = myCar.getEngine().speed;
		System.out.println("현재 속도 : "+ currentSpeed);
		
		myCar.speedDown(10);
		currentSpeed = myCar.getEngine().speed;
		System.out.println("현재 속도 : "+ currentSpeed);
	}

}
