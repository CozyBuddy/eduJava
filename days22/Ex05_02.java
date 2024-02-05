package days22;

import java.util.LinkedList;

/**
 * @author user
 * @date 2024. 1. 30. 오후 12:05:07
 * @subject
 * @contents
 */
public class Ex05_02 {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add("김진영");
		list.add("나딘");
		list.add("신슬기");
		System.out.println(list);
		list.addFirst("임민수");
		System.out.println(list);
		
		list.size();
		System.out.println(list.size());
		list.contains("홍길동");
		list.indexOf("홍길동"); // 없으면 -1 반환
		list.lastIndexOf("홍길동"); // 뒤에서부터 찾음
		
		// 신슬기를 찾아서 "고경림"으로 이름을 수정
		//((list.contains("신슬기") ? list.set(list.indexOf("신슬기"), "고경림"): list.indexOf("신슬기") );
		int index = -1;
		if ((index = list.indexOf("신슬기"))!=-1) {
			list.set(index,"고경림");
			
		}
		System.out.println(list);
		//			  읽기 	삽입/삭제	     비고
		//Arraylist  빠르다	느리다		순차적으로 추가,삭제 작업은 빠름
		//Linkedlist 느리다	빠르다		데이터가 많으면 많을 수록 접근성이 떨어짐
		
	}

}
