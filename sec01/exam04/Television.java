package sec01.exam04;

import sec01.exam03.RemoteControl;

public class Television implements RemoteControl {
	private int volume;
	
	public void turnOn() {
		System.out.println("TV를 켭니다.");
		
	}
	public void turnOff() {
		System.out.println("TV를 끕니다.");
		
	}
	public void setVolume(int volume) {
		if (volume>RemoteControl.MAX_VALUE) {
			this.volume = RemoteControl.MAX_VALUE;
			} else if (volume<RemoteControl.MIN_VALUE) {
			this.volume = RemoteControl.MIN_VALUE;
			
		} else {
			this.volume = volume;
		}
		System.out.println("현재 볼륨은 "+this.volume+"입니다.");
		
	}

}
