package sec01.exam06;

import sec01.exam03.RemoteControl;
import sec01.exam04.Audio;
import sec01.exam04.Television;

public class Myclass {
	RemoteControl rc = new Television();
	
	Myclass(){
		
	}
	Myclass(RemoteControl rc){
		this.rc =rc;
		rc.turnOn();
		rc.setVolume(5);
	}
	void methodA() {
		RemoteControl rc = new Audio();
		rc.turnOn();
		rc.setVolume(5);
	}
	void methodB(RemoteControl rc) {
		rc.turnOn();
		rc.setVolume(5);
	}
	
	

}
