package days17;

public class H_Engine implements Engine {
	int speed;
	@Override
	public void moreFuel(int fuel) {
		this.speed +=fuel*0.7;
		
	}

	@Override
	public void lessFuel(int fuel) {
		this.speed -=fuel*0.05;
		
	}

	@Override
	public void stop() {
		this.speed =0;
		
	}

}
