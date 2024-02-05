package days23;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author user
 * @date 2024. 1. 31. 오전 11:39:39
 * @subject
 * @contents
 */
public class Ex05 {
	public static void main(String[] args) {
		/*
		 * Set : HashSet, LinkedHashSet ..
		 * 			[TreeSet] 컬렉션 클래스
		 * 1.중복허용x ,순서 유지 x
		 * 2.이진 검색 트리라는 자료 구조로 데이터를 저장하는 컬렉션 클래스. 각각을 트리노드라고 부름,
		 * 	 제일 위에 있는 노드를 루트노드라고 부름. 같은 수평에 있는 노드들을 형제 노드라고함
		 * 		바로 위에 있는 노드를 부모노드, 부모 밑에 있는 노드를 자식 노드
		 * 3.이진 검색 트리 - 검색, 정렬 , 범위 검색하는데 성능이 높음
		 * 4. 링크드리스트처럼 노드(Node)가 서로 연결된 구조
		 * 5. 최상위 노드 : 루트(root)노드
		 * 6. 노드들 간의 관계 : 부모노드, 자식노드, 형제노드
		 * 7. 트리 노드 
		 * 	class TreeNode{
		 *  	Object element;
		 *  	TreeNode left; // 왼쪽에 오는 자식노드 참조
		 *  	TreeNode right : // 오른쪽에 오는 자식노드 참조
		 *  
		 *  }
		 */
		
		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(7);
		ts.add(4); // 왼쪽 자식 노드에 추가됨. , 부모 노드에 자식 노드 참조값이 추가됨.
		ts.add(9); // 오른쪽 자식 노드에 추가됨. , 부모 노드에 오른쪽 자식 노드 참조값이 추가됨.
					// 자동으로 정렬이 되어서 값에 따라 오름차순으로 1은 맨 왼쪽 노드에 오게 되고 가장 큰 값이 가장 오른쪽에 옴.
		ts.add(1);
		ts.add(5);		
		ts.add(6);
		ts.add(77);
		System.out.println(ts);
		//정렬된 순서에서 가장 왼쪽에 있는 , 가장 작은값
		System.out.println(ts.first());
		System.out.println(ts.last()); //가장 큰 값
		
		//범위 검색
		SortedSet<Integer> ss = ts.subSet(4, 7);
		System.out.println(ss);
		System.out.println(ts.subSet(4, 7));
		System.out.println(ts.higher(1)); // 1노드보다 큰 값들 중에서 가장 작은값
		System.out.println(ts.lower(4)); // 4노드보다 작은 값들 중에서 가장 큰 값
		
		//지정된 값3 과 같은 객체를 반환
		// 트리구조에 3 값이 없으면 작은 값을 가진 객체 중에 가장 가까운 값을 반환
		System.out.println(ts.floor(3)); //1
		 //트리구조에 3 값이 없으면 큰 값을 가진 객체 중에 가장 가까운 값을 반환
		System.out.println(ts.ceiling(3)); //4
		
		
	}

}
