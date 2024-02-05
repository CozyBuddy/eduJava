package days07;

import java.util.function.BiConsumer;

/**
 * @author user
 * @date 2024. 1. 9. 오후 5:06:18
 * @subject
 * @contents
 */
public class Ex10_02 {
	public static void main(String[] args) {
		int [] arr = {1,2};
		System.out.println(sum(arr));
		
		int [] arr2 = {1,2};
		System.out.println(sum(arr2));
		
	}

	private static int sum(int[] m) {
		int result = 0;//a
		for (int i = 0; i < m.length; i++) {
			result+=m[i]; // a
		}
		return result;
	}
	//[람다와 스트림]
	// return IntStream.of(m),sum(); //a를 대신할 수 있음.
	

}
