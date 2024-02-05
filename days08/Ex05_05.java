package days08;

import java.util.Random;

/**
 * @author user
 * @date 2024. 1. 10. 오후 3:44:28
 * @subject
 * @contents
 */
public class Ex05_05 {
	public static void main(String[] args) {
		new Random()
		.ints(1,46)
		.distinct()
		.limit(6)
		.sorted()
		.forEach(System.out::println);
		//.forEach(n->System.out.println(n)); // "->" 이것도 람다 연산자  
		
	}

}
