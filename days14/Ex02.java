package days14;

/**
 * @author user
 * @date 2024. 1. 18. 오전 10:25:15
 * @subject 선언된 클래스로 객체 생성 및 사용 
 * @contents
 */
public class Ex02 {
	public static void main(String[] args) {
		//지역변수 ,참조변수 ,배열
		//int m [];
		// 1)TV tv1 = null;왼쪽에 있는 tv1는 객체명으로 취급, 객체를 선언만함.(선언만해도 객체라고 함.)
		new TV(); // 오른쪽은 객체를 실제 생성함.(인스턴스화)
		// 실제 객체를 선언해서 힙영역에 그 주소가 올라가면 그 힙영역을 인스턴스라고 함.
		TV tv1 = new TV(); // TV 클래스의 변수 및 메서드를 모두 참조함.
		// 객체명.필드명 "."이 객체명의 멤버를 가리키는 것
		// field는 초기화안해도 각 변수의 초기값으로 지정되어 있음.
		//각 자료형의 호출 방법 : 객체명.필드명 ,배열명[index]
		tv1.power();
		System.out.println("TV : "+(tv1.power ? "ON":"OFF"));
		tv1.channelUp();
		tv1.channelUp();
		tv1.channelUp();
		System.out.println("현재 채널 :"+tv1.channel);
		
		tv1.power();
		System.out.println("TV : "+(tv1.power ? "ON":"OFF"));
		System.out.println("End");
	}

}
