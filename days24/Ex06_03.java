package days24;

/**
 * @author user
 * @date 2024. 2. 1. 오후 2:33:44
 * @subject
 * @contents
 */
public class Ex06_03 {
	public static void main(String[] args) {
		// [제네릭의 제한]
		// 
	}

}
class Box2<T>{
	//Cannot make a static reference to the non-static type T
	// [제네릭의 첫번째 제한]
	// 제네릭클래스에는 클래스변수(정적필드) 선언 X
	// static T item2; X 
	
	// [제네릭의 두 번째 제한]
	//클래스 메서드 선언 가능 + 매개변수 T 타입 사용 = > 위에랑 같은 오류
	/*	static int compare(T a ,T b) {
	//		return 0 ;
		}
	*/
	
	// T타입의 배열은 선언할 수 있음.
	T[] itemArr;
	
	
}
