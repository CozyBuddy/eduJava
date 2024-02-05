package days24;

import java.util.ArrayList;

/**
 * @author user
 * @date 2024. 2. 1. 오후 3:50:50
 * @subject
 * @contents
 */
public class Ex06_07 {
	public static void main(String[] args) {
		//제네릭 클래스
		//ArrayList<Integer> list = new ArrayList<>();
		//일반 클래스
		//ArrayList list = new ArrayList<>();
		
		Box05<String> box1 = new Box05();
		//밑에껀 이거랑 같다고 보면 됨. Box05<Object> box2 = new Box05();
		Box05 box2 = new Box05();
		
		//원시타입과 제네릭 타입 간의 형변환은 자동으로 일어나고 경고만 발생
		// - <T>가 없으면 Object타입으로 컴파일함.
		
		
	}
}
