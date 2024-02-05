package days18;

/**
 * @author user
 * @date 2024. 1. 24. 오후 12:06:49
 * @subject [객체로부터 Class 객체를 얻어오는 방법 3가지]
 * @contents
 */
public class Ex03 {
	public static void main(String[] args) {
		// 1.Object.getClass()
		Person p = new Person("111", "홍길동");
		Class cls = p.getClass();
		System.out.println(cls.toString());
		
		//2.모든 클래스마다 class 클래스변수가 제공된다.? 그 클래스의 정보를 얻어옴. ~~~.class 
		Class cls1 = Person.class;
		System.out.println(cls1);
		/*// Person 클래스 ->Person 객체 p1 생성
		try {
			Person p1 = Person.class.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//3. 
		String fullName = "days18.Person";
		try {
			Class cls3 = Class.forName(fullName) ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}
}
