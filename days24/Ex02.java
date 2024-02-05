package days24;

import java.util.ArrayList;
import java.util.Comparator;

import static java.util.Collections.*;

/**
 * @author user
 * @date 2024. 2. 1. 오전 11:23:36
 * @subject
 * @contents
 */
public class Ex02 {
	public static void main(String[] args) {
		//Arrays 클래스 : 배열을 사용하기 쉽도록 기능(메서드) 이 구현된 클래스
		// [Collections 클래스] // import 구문에서 static으로 다 가져와서 Collections.생략함.
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println(list);
		// <? super T> 매개변수 다형성
		addAll(list, 1,2,3,4,5);
		System.out.println(list);
		
		/*Collections.rotate(list, 2); // 뒤에오는 숫자는 distance , distance 값만큼 오른쪽으로 이동
		System.out.println(list);*/
		
		swap(list, 0, 3);
		System.out.println(list); // 자리바꿈
		
		//shuffle() 임의의 자리변경
		shuffle(list);
		System.out.println(list); // 자리섞기
		
		sort(list);
		System.out.println(list);
		
		// 내림차순 정렬
		sort(list, (o1,o2)->o2-o1);
		System.out.println(list);
		
		/*sort(list, new Comparator<Integer>() {
		
			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o2-o1;
			}
		});*/
		
		sort(list,reverseOrder()); // reverseOrder -> 내림차순을 명령하는 Comparator 
		System.out.println(list);
		
		fill(list, 100);
		System.out.println(list);
	}

	

}
