package sec02.exam01;

public class Car {
	Tire frontleftTire = new HankookTire();
	Tire frontRightTire = new HankookTire();
	Tire backleftTire = new HankookTire();
	Tire backRightTire = new HankookTire();
	
	void run() {
		frontleftTire.roll();
		frontRightTire.roll();
		backleftTire.roll();
		backRightTire.roll();
	}

}
