package days17;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import days16.Employee;

/**
 * @author user
 * @date 2024. 1. 23. 오전 10:46:37
 * @subject
 * @contents
 */
public class Ex04 {
	public static void main(String[] args) {
		//업캐스팅 Up casting
		//Employee emp = new Temp();
		
		List list = new ArrayList();
		test(list);
		test(new ArrayList()); // new saleMan();
		test(new Vector()); // new Regular();
		test(list);
	}//						Employee emp						
	public static void test(List list) {
		
	}

}
