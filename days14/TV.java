package days14;

public class TV {
	//멤버변수(field)
	public String color;
	public boolean power;
	public int channel;
		
	
	//멤버함수(메서드)
	public void power() {
		power = !power;
	}
	public void channelUp() {
		channel++;
	}
	
	public void channelDown() {
		channel--;
	}
}
