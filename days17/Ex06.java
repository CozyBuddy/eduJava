package days17;

/**
 * @author user
 * @date 2024. 1. 23. 오전 11:37:21
 * @subject
 * @contents
 */
public class Ex06 {
	public static void main(String[] args) {
			// [시험 : 인터페이스](interface)
			/*1. 자바의 자료형
			 *  	1)기본형
			 *  	2)참조형 - 배열,클래스,[인터페이스]	
			 *  	예 ) 인터페이스명 변수명 ;
			 *  2.일종의 추상클래스다.
			 *  	추상클래스 ? 모든 객체에 공통적인 부분을 구현 클래스
			 *  	필드 선언 x
			 *  	일반 메서드 선언 x
			 *  	상수만 선언
			 *  	추상메서드만 선언
			 *  	     +
			 *  	JDK 1.9부터  1)static 메서드 o
			 *  				2) default 메서드 o		
			 *  
			 *     3.인터페이스 끼리 상속이 가능P){인터페이스 끼리 상속 가능)
			 *      * extends 키워드를 사용한다.
			 *      4.인터페이스를 사용하면 다중 상속이 가능하다.
			 *      5. 인터페이스를 구현할때 implements 키워드를 사용해서 클래스를 선언
			 *      6.인터페이스 안의 필드는 상수만 선언가능
			 *       * public PI = 3.14;
			 *       public final static double PI = 3.14;
			 *       
			 *       인터페이스 안의 메서드는 모두 추상메서드
			 *       void test();
			 *       [public abstract] void test();	 자동으로 붙여져 있음.
			 * 
			 */
	}
}
//자바 인터페이스명 : ~~~~ able 관례상

interface Moveable {
	//상수 , 추상 메서드 ,static매서드, defalut 메서드 사용가능
	// 추상 메서드
	void move(int x, int y); //public abstract 생략
}
abstract class Unit {
	int currentHP;// 현재 유닛의 체력
	int x ; // 현재 유닛의 위치(x좌표)
	int y ; // 현재 유닛의 위치(y좌표)
}
interface Attackable {
	void attack(Unit unit);
}
//인터페이스들 끼리는 다중상속 가능
interface Fightable extends Moveable,Attackable {
	// 추상메서드
	
}

//하늘 유닛
class AirUnit extends Unit{
	
}
//땅 유닛
class GroundUnit extends Unit{
	
}
//탱크,군인,무기 등등 수송선
class DropShip extends AirUnit implements Fightable,Repairable {

	@Override
	public void move(int x, int y) {
		
		
	}

	@Override
	public void attack(Unit unit) {
		
		
	}

}
//군인
//클래스 선언할 때 인터페이스를 구현하려면 implements
class Fighter implements Fightable{
	@Override
	public void move(int x, int y) {
		// 걷기 뛰기
	}
	public void attack(Unit unit) {
		// 총 공격
	}
}
//탱크
class Tank extends GroundUnit implements Fightable,Repairable{

	@Override
	public void move(int x, int y) {
		// 탱크 이동
		
	}

	@Override
	public void attack(Unit unit) {
		// 포 쏘는 공격
		
	}
	
}
//수리가 가능한 유닛 
//멤버 X
interface Repairable {
	
}
// SCV
// 수리가능 : Tank,SCV
// 수리 불가능 : Fighter 

class SCV extends GroundUnit implements Repairable{
	SCV() {
		
	}
	//수리하는 기능의 메서드
	void repair(Repairable unit) {
		if (unit instanceof Tank) {
			//탱크 수리코딩
			
		} else if(unit instanceof DropShip){
			// 수송선 수리코딩

		} else if(unit instanceof SCV) {
			//SCV 수리 코딩.
		}
		
	}
}
// 해상 
class Marine extends Unit implements Fightable {

	@Override
	public void move(int x, int y) {
	
		
	}

	@Override
	public void attack(Unit unit) {
		
		
	}
	
}