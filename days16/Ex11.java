package days16;

/**
 * @author user
 * @date 2024. 1. 22. 오후 4:29:45
 * @subject
 * @contents
 */
public class Ex11 {
	public static void main(String[] args) {
		// [다형성]
		// -"여러 가지 형태를 가질 수 있는 능력"
		// - Up Casting
		// Employee e1 =new Regular() ;
		// Employee e2 =new salesMan() ;
		// Employee e3 =new Temp() ;
		// 문제점) Employee에 없는 메서드는 getPay() X
		/*Employee emp4 = new Temp("박정호","서울 성북구","01026584975","2023.03.01",20,72000);
		
		// 실제 참조된 객체 Temp의 getPay() 메서드가 호출됨.
		System.out.println(emp4.getPay());*/
		
		/*
		 * Regular emp1 = new Regular("주강민", "서울 양천구"
             , "010-3123-2311", "2021.03.21", 4000000);
      SalesMan emp2 = new SalesMan(
            "임경재", "경기도 성남시"
            , "010-9837-2342", "2021.03.12"
            , 500000
            , 20, 70000);
      Temp emp3 =  new Temp("박정호", "서울 목동", "010-2319-3422"
            , "2020.01.01", 20, 250000);
      
      // 급여 계산
      emp1.getPay();
      emp2.getPay();
      emp3.getPay();
         :
          :
		 */
		//클래스 배열 선언
		/*Employee emps[] = new Employee[3];
		emps[0] = new Regular("주강민", "서울 양천구"
		         , "010-3123-2311", "2021.03.21", 4000000);
		  emps[1] = new salesMan(
		        "임경재", "경기도 성남시"
		        , "010-9837-2342", "2021.03.12"
		        , 500000
		        , 20, 70000);
		  emps[2] =  new Temp("박정호", "서울 목동", "010-2319-3422"
		        , "2020.01.01", 20, 250000);*/
		//클래스 배열 초기화
		Employee emps[] = {new Regular("주강민", "서울 양천구"
		         , "010-3123-2311", "2021.03.21", 4000000),new salesMan(
		 		        "임경재", "경기도 성남시"
				        , "010-9837-2342", "2021.03.12"
				        , 500000
				        , 20, 70000),new Temp("박정호", "서울 목동", "010-2319-3422"
						        , "2020.01.01", 20, 250000)};
		for (int i = 0; i < emps.length; i++) {
			emps[i].getPay();
		}
		
		
	}

}
