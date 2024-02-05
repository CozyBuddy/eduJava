package days16;

public class Engine  {
	// field
	int speed;
	
	//생성자
	
	//메서드
	void moreFuel(int fuel) {
		this.speed += fuel*0.05;
	}
	void lessFuel(int fuel) {
		this.speed -= fuel*0.05;
	}
	void stop() {
		this.speed =0;
	}

}
