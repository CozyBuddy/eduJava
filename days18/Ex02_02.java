package days18;

/**
 * @author user
 * @date 2024. 1. 24. 오전 10:51:32
 * @subject		Object. 클래스
 * @contents
 */
public class Ex02_02 {
	public static void main(String[] args) {
		// [4] [Object.toString()]
		// 현실에서는 주민등록번호가 동일하면 같은 사람.
		Person p1 = new Person("1234", "권지용");
		Person p2 = new Person("111", "백예린");
			
		// [Thread method] 
		/*Object.notify() , Object.notifyAll();
		Object.wait() X 안 다룸 지금은*/ 
		try {
			//Person p1Clone = (Person) p1.clone();
			Person p1Clone =  p1.clone(); //다운크새팅할 필요가 없음.
			System.out.println(p1Clone);
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
		}
		//p1.clone(p2);//The method clone() in the type Object is not applicable for the arguments (Person) 접근지정자 문제
		
		//4.[Object.toString()]
		// 객체 풀네임@해시코드의 16진수값
		/*System.out.println(p1.toString()); // hashCode를 16진수로 바꾸면 @뒤에 값이 나옴
		System.out.println(p2);
		
		System.out.println(Integer.toHexString(1940030785));*/
		//2.[Object.hashCode()]
		//System.out.println(p1.hashCode()); // 객체의 고유값
		/*System.out.println(p2.hashCode()); */
		//제네릭  <>
		//1. [Object.getClass()]
		/*Class cls = p1.getClass(); // 클래스타입을 반환하는 함수
		String fullName = cls.getName();
		System.out.println(fullName);
		String packageName = cls.getPackageName();
		System.out.println(packageName);
		String className = cls.getSimpleName();
		System.out.println(className);
		System.out.println(cls.getSimpleName());*/
	}

}
class Person implements Cloneable{ // clone()을 사용하려면 이 인터페이스가 꼭 필요함. 
	String rrn;
	String name;
	public Person(String rrn, String name) {
		super();
		this.rrn = rrn;
		this.name = name;
	}
	// 정보를 출력하는 메서드 disPerson() 
	// toString()메서드를 오버라이딩 해서 
	// 그 객체의 정보를 출력하는 용도
	@Override
	public String toString() {
		//return "Person [rrn=" + rrn + ", name=" + name + "]";
		return String.format ("주민번호:%s,이름:%s",rrn,name);
	}
	// Person pclone = p1.clone();
	// clone() ->얕은 복제 
	// 			 깊은 복제
	/*@Override
	protected Object clone()  throws CloneNotSupportedException {
		Person pclone = null;
		pclone =(Person) super.clone();
		return pclone;
	}*/
	
	//JDK 1.5 공변반환타입 추가
	// Object 클래스의 clone() 메서드를 오버라이딩 했기 때문에
	// 리터타입은 Object이어야 하지만 재정의하는 자식클래스의 타입으로 자동 변경
	@Override
	protected Person clone()  throws CloneNotSupportedException {
		Person pclone = null;
		pclone =(Person) super.clone();
		return pclone;
	}
	/*@Override
	protected Person clone()  {
		Person pclone = null;
		try {
		pclone =(Person) super.clone();
		} catch(ConeNotSupportedException e) {
		}
		return pclone;
	}*/
	
	
	
}

