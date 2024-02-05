package days19;

public class Ex05 {
	public static void main(String[] args) {
		//java.lang.Math 클래스
		//모든 멤버들(필드,메서드) : static
		System.out.println(Math.random());
		System.out.println(Math.pow(2, 3));
		System.out.println(Math.max(2, 3));
		System.out.println(Math.min(2, 3));
		System.out.println(Math.abs(-99));
		System.out.println(Math.abs(-99.2222));
		System.out.println(Math.sqrt(4));
		System.out.println(Math.E);
		System.out.println(Math.PI);
		
		// (기억) 반올림 ,올림,내림
		System.out.println(Math.ceil(2.0));
		System.out.println(Math.ceil(2.179));
		System.out.println(Math.ceil(2.555));
		System.out.println(Math.ceil(2.999));
		
		System.out.println(Math.floor(2.0));
		System.out.println(Math.floor(2.179));
		System.out.println(Math.floor(2.555));
		System.out.println(Math.floor(2.999));
		
		// long으로 반환
		System.out.println(Math.round(2.179));
		System.out.println(Math.round(2.555));
		System.out.println(Math.round(2.999));
		
		//Math 클래스는 최대 성능을 위해서 
		//JVM이 설치된 OS의 메서드를 호출해서 처리
		//따라서 OS에 따라서 결과가 다르게 나오기도함.
		//--> [StrictMath 클래스] 성능 포기하고 결과값이 동일하게 처리
		
	}                         

}
