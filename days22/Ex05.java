package days22;

/**
 * @author user
 * @date 2024. 1. 30. 오전 11:32:06
 * @subject
 * @contents
 */
public class Ex05 {
	public static void main(String[] args) {
		//LinkedList 컬렉션 클래스
		//사슬(고리) 연결된 + List
		// 단방향 링크드 리스트 : 뒤에 오는 노드들의 참조값만 가지고 있는 경우 , 맨 뒤와 맨 앞의 노드들이 참조값으로 연결되어있는 경우 환형 .
		// 더블 링크드 리스트 : 앞에 있는 노드와 뒤에있는 노드 둘 다의 참조값을 같이 갖고 있는 경우
		// [ ] - [ [그 뒤에 올 값의 참조변수가 안에서 필요함.]] - [ 노드] - [노드 ] - [ ]
		//
		//1. 장점
		//		1)배열의 장점 = 읽기 성능이 가장 빠르다.
		//		2)배열의 단점 = 배열크기고정,삽입,삭제시 속도가 매우 느림.
		//2. 링크드 리스트
		// 	1)특징 - 비연속적,삽입,삭제 성능이 빠르다.
		Node node1 = new Node();
		node1.value = 10;
		Node node2 = new Node();
		node2.value = 20;
		Node node3 = new Node();
		node3.value = 30;
		Node node4 = new Node();
		node4.value = 40;
		Node node5 = new Node();
		node5.value = 50;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		
		//모든 노드들의 value 출력
		Node node = node1;
		while (node !=null) {
			System.out.println(node.value);
			node = node.next;
		}
		
	}

}
class Node {
	int value ;
	//다음 노드를 참조할 수 있는 참조변수
	Node next;
	Node prev;
}
