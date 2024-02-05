package days22;

import java.util.LinkedList;
import java.util.Queue;

public class Ex07 {
	public static void main(String[] args) {
		//큐(Queue) 구조 선입선출 => input,output 곳이 고정.
		//디큐(Deque) 구조 = 더블 큐 구조 => 양쪽에서 input ,output 을 받을 수 있음
		//FIFO 구조 먼저 들어간게 먼저 나옴.
		//offer()- 데이터 추가  poll(),peek()- 데이터 끄집어낼때
		//  LinkedList -> List,Deque ->Queue ->Collection
		Queue q = new LinkedList();  //인터페이스
		q.offer("김진영");
		q.offer("이나딘");
		q.offer("신슬기");
		
		// Deque 타입이면
		// q.offerFirst 
		// q.offerLast 
		// q.pollFirst
		// q.pollLast
		
		while (!q.isEmpty()) {
			System.out.println(q.poll());
		}
		
		
	}

}
