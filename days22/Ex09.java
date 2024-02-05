package days22;

import java.util.HashSet;

/**
 * @author user
 * @date 2024. 1. 30. 오후 2:19:09
 * @subject
 * @contents
 */
public class Ex09 {
	public static void main(String[] args) {
		// Collection 인터페이스를 상속
		// List - ArrayList,Vector,LinkedList,Stack,Queue(LinkedList),PriorityQueue ...
		// Set 특징)
		//		1)순서유지X 2)중복 허용X 
		//		- HashSet 컬렉션 클래스 
		//			만약) Set+순서 유지가 필요하면 => LinkedHashSet 컬렉션 클래스 사용 (중복허용X)
		
		HashSet hs = new HashSet(); // 16이 초기값
		/*hs.add(hs);
		hs.addAll(hs);*/ //컬렉션 안에 있는 메서드
		hs.add(9);
		hs.add(1);
		hs.add(15);
		hs.add(10);
		/*	hs.add(18);
			hs.add(2);*/
		System.out.println(hs); // 순서유지X
		hs.add(1); // 중복 허용 X
		System.out.println(hs);
		
		
	}

}
