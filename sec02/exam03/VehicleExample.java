package sec02.exam03;

public class VehicleExample {
	public static void main(String[] args) {
		Vehicle vehicle = new Bus();
		vehicle.run();
		
		//vehicle.checkFare();
		
		Bus bus = (Bus) vehicle;
		bus.checkFare();
		bus.run();
	}

}
