package sec01.exam06;

import sec01.exam04.Audio;
import sec01.exam04.Television;

public class MyClassExample {
	public static void main(String[] args) {
		System.out.println("1)"+"*".repeat(60));
		
		Myclass myclass1 =new Myclass();
		myclass1.rc.turnOn();
		myclass1.rc.setVolume(5);
		
		System.out.println("2)"+"*".repeat(60));
		
		Myclass myclass2 = new Myclass(new Audio());
		System.out.println("3)"+"*".repeat(60));
		
		Myclass myclass3 = new Myclass();
		myclass3.methodA();
		
		System.out.println("4)"+"*".repeat(60));
		
		Myclass myclass4 = new Myclass();
		myclass4.methodB(new Television()) ;
		
	}

}
