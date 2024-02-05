package days22;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author user
 * @date 2024. 1. 30. 오후 2:05:27
 * @subject
 * @contents
 */
public class Ex08 {
	public static void main(String[] args) {
		// List - ArrayList,Vector,LinkedList,stack(LIFO),queue(FIFO),deque 더블 큐 구조
		// Set - Hash
		// Map - 
		
		//[PriorityQueue] 컬렉션 클래스
		// 우선순위+Queue
		// 우선순위가 높은 것부터 꺼내오는 큐.
		Queue q = new PriorityQueue();
		q.offer(3);
		q.offer(5);
		q.offer(2);
		q.offer(4);
		q.offer(1);
		System.out.println(q); //q자체에는 순서없이 있음.
		
		while (!q.isEmpty()) {
			System.out.println(q.poll());
		}
		//꺼내올때 작은 숫자가 우선순위가 높음.
		
	}

}
