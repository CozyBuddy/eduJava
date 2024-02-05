package days19;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

import days15.Point;

/**
 * @author user
 * @date 2024. 1. 25. 오후 2:17:03
 * @subject
 * @contents
 */
public class Ex08 {
	public static void main(String[] args) {
		//Arrays 클래스 : toString(),sort(),binarySearch()
		//Objects 클래스 : 모든 메서드가 static 이다.
		//					Objects.메서드()
		// 					객체의 비교 또는 null 체크에 유용
		Point p1 = null;
		//
		//
		//
		/*// =>p1이 생성 유무 체크
		if (Objects.isNull(p1)) { // p1이 null 일때 true 반환 
			
		} if (Objects.nonNull(p1)) { // p1이 null이 아닐때 true 반환
			
		} if (!Objects.isNull(p1)) {
			
		// p1이 null이면 예외 발생
		} if (p1==null) {
			new IOException("예외 메시지 ");
		}
		Point pCopy = p1;
		Point pCopy2 = Objects.requireNonNull(p1,"예외 메시지");
		
		if (p1!=null && p1.equals(pCopy2)) {
			
		}
		if (Objects.equals(p1, pCopy2)) {// 위 코딩이랑 같음.
			
		}
		*/
		System.out.println("-".repeat(60));
		
		Random rnd = new Random();
		System.out.println(rnd.nextInt()); //-21억~ 21억
		System.out.println(rnd.nextInt(10)); // 0<= <10
		System.out.println(rnd.nextBoolean()); // true/false
		//rnd.nextXXX
		
		}
	

}
