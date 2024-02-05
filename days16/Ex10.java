package days16;

/**
 * @author user
 * @date 2024. 1. 22. 오후 3:07:24
 * @subject
 * @contents
 */
public class Ex10 {
	public static void main(String[] args) {
		// [1] 사원 객체 생성
		/*Employee emp1 = new Employee("이준희","서울시 서초구","01033994975","2014.03.01");
		emp1.disEmpInfo();
		// Object.toString();
		System.out.println(emp1.toString()); // 패키지명.클래스명@16진수값
		System.out.println(emp1);*/
		// toString()가 사원 정보를 출력하도록 오버라이딩
		
		//[2]
		/*Regular emp2 = new Regular("최강희","서울 성북구","01026584975","2023.03.01");
		//Employee로 부터 상속받은 disEmpInfo메서드 단점 - > 사원 정보 출력에 basePay를 출력하지 않음.
		//emp2.disEmpInfo();
		System.out.println(emp2.toString());*/
		
		// 정규직은 사원이다.
		// 자식객체를 생성해서 부모클래스에 참조시킬 수 있다.
		// 클래스의 자동형변환(Up Casting)
		 //Employee emp2 = new Regular("최강희","서울 성북구","01026584975","2023.03.01");
		
		// 문제점
		// emp2.getPay() X
		//emp2.disEmpInfo();
		//[3]
		//Up Casting 클래스간의 형변환
		/*Employee emp3 = new salesMan("임경재","서울시 성북구","01025684975","2023.03.01",500000,2,70000);
		System.out.println(emp3.getPay());*/
//		
//		
//		
//		
//		
//		
//		
//		[4] 크래스 간의 형변환 - Up Casting (자동 형변환) -> getPay 함수가 부모클래스에 없어서 사용불가
		Employee emp4 = new Temp("박정호","서울 성북구","01026584975","2023.03.01",20,72000);
		emp4.disEmpInfo();
		//System.out.println(emp4.getPay());
		
	}

}
