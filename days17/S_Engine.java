package days17;

public class S_Engine implements Engine {
	int speed;
	@Override
	public void moreFuel(int fuel) {
		this.speed += 0.15;

	}

	@Override
	public void lessFuel(int fuel) {
		this.speed -= 0.05;

	}

	@Override
	public void stop() {
		this.speed=0;

	}

}
