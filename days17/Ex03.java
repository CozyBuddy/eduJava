package days17;

import days16.Employee;
import days16.Regular;
import days16.Temp;
import days16.salesMan;

/**
 * @author user
 * @date 2024. 1. 23. 오전 10:18:32
 * @subject [매개변수 다형성]
 * @contents
 */
public class Ex03 {
	public static void main(String[] args) {
		Regular emp1 = new Regular("최강희","서울 성북구","01026584975","2023.03.01", 4000000);
		
		//disGetPay(emp1);
		
		salesMan emp2 = new salesMan("임경재","서울시 성북구","01025684975","2023.03.01",500000,2,70000);
		disGetPay(emp2);
		
		Temp emp3 = new Temp("박정호","서울 성북구","01026584975","2023.03.01",20,72000);
		//disGetPay(emp3);
		
		System.out.println("테스트".replace("테스", "xx")); //charSequence가 String 보다 상위 클래스임. 
		
		// CharSequence String
		String name;
	}
	// 오버로딩
	/*private static void disGetPay(Temp emp3) {
		System.out.printf("임시직 사원 급여 : %d원\n",emp3.getPay());
		
	}
	private static void disGetPay(salesMan emp2) {
		System.out.printf("영업직 사원 급여 : %d원\n",emp2.getPay());
		
	}
	// 사원의 급여를 출력하는 메서드 
	
	private static void disGetPay(Regular emp1) {
		System.out.printf("정규직 사원 급여 : %d원\n",emp1.getPay());
		
	}*/
	
	//                           매개변수 다형성
	//							 Regular/salesMan/Temp 객체
	private static void disGetPay(Employee emp) {
		// instanceOf 연산자
		// (주의) 자식 클래스 먼저 체크한다. 부모클래스보다 // 부모클래스를 먼저 체크하면 부모클래스에서 멈춤 salesMan을 disp하고 싶어도 
		String type = null ;
		if (emp instanceof salesMan) {
			type = "영업직";
			salesMan sm = (salesMan)emp; // 다운캐스팅
		} else if (emp instanceof Regular) {
			type = "정규직";
			Regular rg = (Regular)emp; 
		} else if(emp instanceof Temp){
			type = "임시직";
			Temp tp = (Temp)emp; 
		}
		
		System.out.printf("%s 사원 급여 : %d원\n",type,emp.getPay());
		
	}

}

class Temp2 extends Temp {
	
}
