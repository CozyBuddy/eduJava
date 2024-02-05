package days15;

/**
 * @author user
 * @date 2024. 1. 19. 오전 11:08:22
 * @subject
 * @contents
 */
public class Ex03 {
	//field
	String name;
	int age;

	public Ex03() { //default 생성자
		System.out.println(">Ex03 Default Constructor");
		name = "익명";
		age = 20;
	}
	public Ex03(String n , int a) { //넘어오는 값으로 초기화하려는 의도 n과 a 으로 둘다 초기화
		System.out.println(">Ex03 Default Constructor");
		name = n;
		age = a;
	}
	public Ex03(String n) { //n만 초기화
		System.out.println(">Ex03 Default Constructor");
		name = n;
		age = 20;
	}
	public Ex03(String string, int i, String string2) {
		name= string;
		age = i;
		name = string2;
				}
	// java.exe 실행할때 main메서드는 호출됨.
	public static void main(String[] args) {
		//Ex03(); undefined 원래 클래스에서 호출 X
		//Ex03 obj = new Ex03();
		//Ex03 obj = new Ex03("서영학",30,"부장");//The constructor Ex03(String, int, String) is undefined
//		System.out.println(obj.name);
//		System.out.println(obj.age);
		//Sample sample = new Sample();//The constructor Ex03(String, int, String) is undefined
	}
	/*
	 * [시험] 생성자(Constructor)
	 * 1.일종의 메서드
	 * 2.생성자명 = 클래스명// 반드시 일치해야함
	 * 3.리턴자료형을 사용하지 않음.
	 * 4.매개변수가 없는 생성자를 디폴트 생성자라고함.
	 * 5.접근지정자는 사용가능.
	 * 		기타제어자는 사용불가.
	 * 6.호출되는 시점 : 인위적으로 호출 불가.
	 * 				    but 객체가 생성될때 자동으로 호출. new Ex03();
	 * 7.생성자의 역할 : 객체 생성 -> 자동으로 생성자 호출 -> 필드 초기화 작업 // 기존의 필드 초기값보다 다른 초기값을 주려는 의도
	 * 8.생성자는 오버로딩(overloading)할 수 있음.
	 * 		오버라이딩 의미 : 상속받은 클래스에서 같은 메서드명을 사용해서 실행 하려는 클래스에서 부모 클래스의 메서드를 호출하지 않고 자식 클래스에서 호출 하게 하는 방식.
	 * 		오버로딩 의미 : 중복함수 매개변수나 자료형이 다른 같은 메서드명
	 * 9.클래스 선언시 생성자를 1개라도 선언되지 않으면 컴파일러가 자동으로 디폴트 생성자를 추가해서 컴파일함.
	 * 10. 생성자는 상속되지 않는다. 
	 */
	
	class Sample{
		 String name;
		/*public Sample(String s) {
			name=s;
			
		}*/
	}



}
