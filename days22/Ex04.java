package days22;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * @author user
 * @date 2024. 1. 30. 오전 11:04:33
 * @subject
 * @contents
 */
public class Ex04 {
	public static void main(String[] args) {
		//	[Vector 컬렉션 클래스]
		// 	ㄴ List 인터페이스를 구현
		//  ㄴ순서 유지 , 중복허용
		//  ㄴArrayList 동일
		// 		차이점 : 멀티 스레드 안전(동기화 처리O)
		
		//StringBuffer 멀티 스레드 안전(동기화 처리O)
		//StringBuilder 멀티 스레드 안전x(동기화 처리x)
		
		Vector v = new Vector();
		v.addElement("강명건");
		v.add("박우현");
		v.add("김영진");
//		v.add(null);
//		v.add(null);
		System.out.println(v);
		System.out.println(v.size());
		System.out.println(v.capacity());
		v.trimToSize();
		System.out.println(v.size());
		System.out.println(v.capacity());
		v.setSize(5);
		System.out.println(v);
		String name = (String)v.get(0);
		name =(String) v.elementAt(0);
		//v.remove(index);
		//boolean v.isEmpty();
		//모든 요소를 출력 : 반복자 (iterator)
		/*Iterator ir = v.iterator();
		while (ir.hasNext()) {
			String object = (String) ir.next();
			System.out.println(object);
		}*/
		//모든 요소를 출력 : 열거자(enumeration)
		/*Enumeration en = v.elements();
		while (en.hasMoreElements()) {
			name = (String) en.nextElement();
			System.out.println(name);
		}*/
		//반복자와 열거자 차이점 파악
		// v벡터 안에 null*2 그래서 null 요소를 삭제
		v.removeIf(n->n==null);
		//System.out.println(v);
		v.forEach(n->System.out.println(n));
		//메서드 참조 
		v.forEach(System.out::println);
		//v.clear() 
		
		List subList = v.subList(0, 2);
		System.out.println(subList);
	}

}
