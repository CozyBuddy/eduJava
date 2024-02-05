package days21;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author user
 * @date 2024. 1. 29. 오후 2:33:11
 * @subject
 * @contents
 */
public class Ex12_01 {
	public static void main(String[] args) {
		//ArrayList 컬렉션 클래스
		// 제네릭
		ArrayList list = new ArrayList(3);
		list.add("전하영");
		list.add("김진영");
		list.add("주강민");
		
		System.out.println(list); // 전하영 김진영 주광식
		System.out.println(list.size());
		
		list.add("홍길동");
		System.out.println(list); // 전하영 김진영 주광식 홍길동
		System.out.println(list.size()); // 자동 배열 크기 추가
		System.out.println(list.contains("전하영")); // true false
		System.out.println(list.indexOf("전하영")); // 위치 값 반환 없으면 -1 반환
		
		list.add(2, "권맑음");
		System.out.println(list);
		// 전하영 김진영 권맑음 홍길동 -> 주광식 삭제
		int index = -1;
		if ((index = list.indexOf("주광식"))!=-1) {
			//list.remove(index);
			
			
		}
		System.out.println(list);
		
		//"주강민" -> "주광미" 수정
		if ((index = list.indexOf("주강민"))!=-1) {
//			list.remove(index);
//			list.add(index, "주강미");
			list.set(index, "주강미");
			
		}
		System.out.println(list);
		//
		/*System.out.println(list.isEmpty());//false
		//list.clear();
		System.out.println(list.isEmpty());//true
		*/		
		//모든 요소를 출력...
		//get(index)
		/*System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));*/
		/*for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}*/
		
		//요소출력 할때 iterator 반복자
		//요소를 순차적으로 처리할 수 있는 반복자 : Iterator
		Iterator ir = list.iterator();
		while (ir.hasNext()) { //hasNext() 요소를 가지고 있으면 true 아니면 false
			String object = (String) ir.next(); //next() 요소를 얻어옴 ir에서 next로 사라짐.
			System.out.println(object);
			
		}
		//ArrayList 메서드
		// 1)add
		// 2)set
		// 3)contains
		// 4)indexOf
		// 5)clear
		// 6)remove
		// 7)iterator
		// 8)isempty
		// 9)get
		// 10)size
		
		//번외 ) Iterator hasNext next
		
		
		
		
	}

}
