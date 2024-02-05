package days14;
//import days14.Student;
/**
 * @author user
 * @date 2024. 1. 18. 오전 11:23:35
 * @subject
 * @contents
 */
public class Ex04 {
	private static class Member() {
		
	}

	public int age = 20;
	public static void main(String[] args) {
		/*[접근지정자 설명]
		 * 1.클래스 앞의 접근지정자
		 * 	1)public : 패키지 내부 또는 외부 어디서든 그 클래스에 대해서 상속과 참조 사용 가능.
		 * (패키지 내부)
		 * 	days14.Ex04.java 
		 * 	days14.TV.java
		 * (패키지 외부)
		 * days13.Ex01.java
		 * import days14.TV;
		 * days14.TV.java
		 */
			TV tv1 = new TV(); // 참조가능
			Student s1 = new Student();
		 /* 	2)package(class 앞에 아무것도 붙지 않음, default) : 패키지 내부에서만 해당 클래스에 대해서 상속과 참조 사용 가능.
		  * (패키지 내부)
		 * 	days14.Ex04.java 
		 * 	days14.Student.java
		 * (패키지 외부)
		 * days13.Ex01.java
		 * days14.Student.java
		 * 	독립적인 클래스를 선언할 때는 사용할 수 없는 접근지정자다.
		 *  클래스 안에 클래스 선언(중첩 클래스)
		 *  ***내부 클래스 4가지
		 * 	3)private	비활성화 : 같은 파일 내에서만 상속,참조 가능하다.
		 * 	4)protected	비활성화 : package 기능 + 패키지 외부에서는 상속만 가능함.
		 * 1-2. 클래스 앞의 기타제어자
		 * 	1)abstract - 추상클래스 
		 * 	2)final - 상수 선언시 사용 , 최종 클래스 (상속)
		 * 	3)static 비활성화 -> 중첩 클래스 선언시에만 사용 가능.
 		 * 2.멤버 앞의 접근지정자
		 * 	1)public
		 * 	2)package
		 * 	3)private
		 * 	4)protected
		 * 
		 * 
		 * */
	}

}
