package days17;

public class Car  {
	//필드
	String name;
	String gearTyep;
	int door;//문갯수
	//결합력이 높은 코딩 -> 좋은 코딩x
	
	//생성자
	public Car() {
	}
	public Car(Engine engine) {
		this.engine = engine;
	}
	//메서드
	//엔진 객체
	// 인터페이스(다형성)
	private Engine engine ; // has-a관계 객체를 선언해서 사용하는것
	public Engine getEngine() {
		return engine;
	}
				//			현대,삼성,기아 엔진 매개변수 다형성
	public void setEngine(Engine engine) {
		this.engine = engine;
		System.out.println("엔진이 교체되었습니다.");
	}
	
	void speedUp(int fuel) {
		//this.engine = new Engine();
		this.engine.moreFuel(fuel);// java.lang.NullPointerException 오류가 engine 인걸 파악 메서드면 메서드 항목의 에러를 띄움.
		System.out.println("연료가 "+fuel+"주입되었습니다.");
	}
	void speedDown(int fuel) {
		this.engine.lessFuel(fuel);
	}
	void stop() {
		this.engine.stop();
	}

}
