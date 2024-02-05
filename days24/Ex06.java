package days24;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex06 {
	public static void main(String[] args) {
		/*
		 * [제네릭(Generics)]
		 * 1. jdk 1.5 - 제네릭
		 * 	  jdk 1.8 - 람다식
		 * 2. 제네릭?
		 * 		[다양한 타입]의 객체를 다루는 메서드, 컬렉션
		 * 		클래스에서 [컴파일(코드작성시에)] 에 타입을 체크해 주는 기능.
		 * 3. 객체의타입을 컴파일할때 체크하는 이유
		 * 		(제네릭의 장점)
		 * 		1) 객체의 타입 안전성을 높임.
		 * 		2) 형 변환의 번거로움이 줄어든다. -> 코드가 간결해짐.
		 * 		
		 * 		
		 * 
		 */
		/*ArrayList list = new ArrayList();
		list.add(100);
		list.add(3.14);
		list.add('A');
		list.add("홍길동");
		list.add(true);
		list.add(new MemberVO());
		
		//제네릭이 없으면 밑에 처럼 데이터를 대입하려면 형변환을 수동으로 해야함.
		int i = (int) list.get(0);
		System.out.println(i);
		double d = (double) list.get(1);
		System.out.println(d);*/
		
		//[제네릭클래스] Arraylist 랑 Arraylist<E>랑 별개의 것으로 취급
		ArrayList<String> list = new ArrayList<>();
		list.add("홍길동");
		list.add("김진영");
		list.add("신슬기");
		
		//[첫 번째 장점] - 타입 안전성
		// 컴파일러가 타입 체크 list.add(100);
		
		//[두 번째 장점] - 자동형변환
		String name = list.get(0);
		name = list.get(1);
		name = list.get(2);
		
		Iterator<String> ir = list.iterator();
		while (ir.hasNext()) {
			name = (String) ir.next(); //형변환 필요X
			
		}
		
		
	}

}
