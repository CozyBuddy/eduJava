package days14;

/**
 * @author user
 * @date 2024. 1. 18. 오후 5:06:52
 * @subject
 * @contents
 */
public class Ex11 {
	public static void main(String[] args) {
		/*
		 * [멤버(필드,메서드,생성자)앞의 접근지정자]
		 * 1.public - 패키지 외부,내부 어디서나 참조가능
		 * 2.package(default) -패키지 내부에서만 참조가능
		 * 3.private - 클래스 내에서만 참조가능
		 * 4.protected - 패키지 내부에서만 참조가능 그리고 패키지 외부에서는 상속 관계면 참조가능.
		 * 
		 * 범위 : public > protected > package > private
		 * 지역변수는 접근지정자를 사용할 수 없음.
		 * 
		 * 	Time 클래스 선언
		 */
		Time t = new Time();
		
	}
	

}
/*class Time{
   // field
   public int hour;
   int minute;
   protected int second;
   private int millisecond;
   
   // method
}*/
