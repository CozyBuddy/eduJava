package days16;

public class Car  {
	//필드
	String name;
	String gearTyep;
	int door;//문갯수
	//결합력이 높은 코딩 -> 좋은 코딩x
	//엔진 객체
	private Engine engine= null; // has-a관계 객체를 선언해서 사용하는것
	
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	//생성자
	public Car() {
	}
	public Car(Engine engine) {
		this.engine = engine;
	}
	//메서드
	
	void speedUp(int fuel) {
		//this.engine = new Engine();
		this.engine.moreFuel(fuel);// java.lang.NullPointerException 오류가 engine 인걸 파악 메서드면 메서드 항목의 에러를 띄움.
	}
	void speedDown(int fuel) {
		this.engine.lessFuel(fuel);
	}
	void stop() {
		this.engine.stop();
	}

}
