package days16;

/**
 * @author user
 * @date 2024. 1. 22. 오후 5:16:09
 * @subject
 * @contents
 */
public class Ex12 {
	public static void main(String[] args) {
		// 클래스 간의 형변환
		// 반드시 상속 관계가 있어야한다.
		// Regular emp = new Temp(); X
		// Up Casting (업캐스팅) 자동타입변환
		/*Regular emp = new salesMan();
		// Down Casting 다운캐스팅 수동타입변환
		// cast 연산자 사용
		salesMan sm = (salesMan)emp ;*/
		
		Regular emp = new Regular();
		//ClassCastException:
		salesMan sm = (salesMan)emp;
		sm.getName();
	}

}
