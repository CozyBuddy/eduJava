package sec01.exam05;

import sec01.exam05.Outter.Nested;

public class OutterExample {
	public static void main(String[] args) {
		Outter outter = new Outter();
		Outter.Nested nested = outter.new Nested();
		nested.print();
		
	}

}
