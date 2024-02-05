package days17;

/**
 * @author user
 * @date 2024. 1. 23. 오후 12:42:45
 * @subject
 * @contents
 */
public class Ex08 {
	public static void main(String[] args) {
		// 클래스들의 관계
		// 1)has -a 관계 (포함관계)
		// 2) is -a 관계(상속관계)
		
		// (인터페이스 장점)
		//Car+Engine 클래스 +인터페이스 사용
		Engine engine = new H_Engine();
		Car myCar = new Car(engine);
		myCar.speedUp(10);
		myCar.setEngine(new K_Engine());
		myCar.speedUp(10);
		
		//2024년 H_Engine,K_Engine 2개 엔진
		//2029년 S_Engine 등장
		
	}

}
