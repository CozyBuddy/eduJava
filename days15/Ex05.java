package days15;

public class Ex05 {
	public static void main(String[] args) {
		//[시험2]
		//어떤 클래스(Person)의 필드를 private로 선언했다.
		//private 선언된 필드에 접근하는 방법?
		//Person p1 = new Person();
		//p1 사람의 이름을 홍길동으로 설정.
		//private 클래스 내에서만 참조(접근) 가능
		// 같은 패키지 내부라도 접근X
		//p1.name = "홍길동"; //The field Person.name is not visible
		Person ps = new Person();
		ps.setAge(25);
		System.out.println(ps.getAge());
		
	}

}
