package days01;


/**
 * @author Sunny
 * @date 2023. 12. 29. - 오후 3:15:52
 * @subject 변수와 상수
 * @content
 */
public class Ex03 {

	public static void main(String[] args) {
      /*
       * 1. 변수(variable,var)
       * 	-수학 의미 : 변하는 수
       * 	-메모리상의 값을 저장하는 공간
       * 	 값을 한 번 저장한 후 변경할 수 있다. 
       * 2. 상수(const)
       * 	- 변하지 않는 수 (== 고정된 수)
       * 	-메모리상의 값을 저장하는 공간 
       *   	 값을 한 번 저장한 후 변경할 수 없다.
       *    (초기화)
       * 
       *    리터럴 X
       *    
       * 3. 자바에서 변수/상수 선언하는 형식
       * 	[변수 형식]
       * 	자료형 변수명[=초기값];
       * 	자료형 = 데이터 형식(data type)
       * 4. 자바에서 사용하는 자료형 종류
       * 
       *    담배심부름하다()
       * */
       System.out.println("권맑음");
       // name -> 변수명 ? 식별자랑 변수명이랑 뭐가다름?
       
       String name = "권맑음"; // = 대입(할당)연산자
       //The local variable name may not have been initialized
       // [local variable == 지역변수 ]
       System.out.println(name);
       name = "류본혁";
       System.out.println(name);
       
	}

}
