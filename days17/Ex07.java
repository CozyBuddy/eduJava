package days17;

/**
 * @author user
 * @date 2024. 1. 23. 오후 12:30:49
 * @subject
 * @contents
 */
public class Ex07 {
	public static void main(String[] args) {
		//[인터페이스 장점]
		// 1. 개발 시간을 단축 시킬 수 있음.
		//		 이유? 인터페이스만 작성 -> 개발 진행
		//			인터페이스를 구현한 클래스 선언X
		// 2. 표준화 가능
		//   	프로젝트 진행 - 인터페이스만 작성
		// 3. 서로 관계없는 클래스들에게 관계를 맺어줄 수 있음.
		// 	  같은 Super 클래스가 아니라도 
		// 	  아무 관계 없는 클래스들일지라도 같은 인터페이스만 구현했다면 관계를 줄 수 있음.
		// 4. 독립적인 프로그래밍이 가능함.
		
		Idis a1 = new A();
		Idis b1 = new B();
		print(a1);
		// 클래스 제작자(생산자) -> 클래스 사용자
		//			Provider          User
		// 	  인터페이스만 선언        사용가능
		// 		구현된 클래스x
	}

	private static void print(Idis a1) {
		
	}

}
interface Idis{
	void disp();
	
}

class A implements Idis{

	@Override
	public void disp() {
		
		
	}}
class B implements Idis{

	@Override
	public void disp() {
		
		
	}}
