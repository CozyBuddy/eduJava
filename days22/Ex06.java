package days22;

import java.util.Stack;

public class Ex06 {
	public static void main(String[] args) {
		//스택(Stack) 구조와 큐(Queue) 구조
		// 스택 구조
		//       
		//  ->  A B C 로 데이터를 추가하면 C B A 로 갖고 올수밖에없음 -> LIFO 구조 - push(),pop(),peek(),empty,search()
		//
		
		// Stack -> Vector -> List 
		Stack s = new Stack();
		s.push("김진영");
		s.push("이나딘");
		s.push("신슬기");
	
		/*System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		*/
		while (!s.empty()) { //s.isEmpty() Vector
			System.out.println(s.pop());
			
		}
		//s.indexOf("홍길동");
		//System.out.println(s.search("이나딘"));
	}

}
