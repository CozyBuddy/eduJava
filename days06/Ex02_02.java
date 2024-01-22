package days06;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**
 * @author user
 * @date 2024. 1. 8. 오후 12:02:38
 * @subject
 * @contents
 */
public class Ex02_02 {
	public static void main(String[] args) {
		//람다식과 스트림 
		int [] m = new Random().ints(5,16).limit(10).toArray(); // 5~ 15까지의 intstream 객체 10개를 생성하고
		int max2 =5;
		for (int i = 0; i < m.length; i++) {
			max2 = Math.max(max2, m[i]);
			
		}
		System.out.println(max2);
		// toArray로 자동형변환 ->배열로 생성
		System.out.println(Arrays.toString(m));
		int max = new Random().ints(5,16).limit(10).max().getAsInt(); //getAsInt는 return타입을 integer로 바꾸는듯
		System.out.println(max);
		int [] m1 = new Random().ints(5,16).limit(10).toArray();
		int max1 = new Random().ints(5,16).limit(10).max().getAsInt();
		
	}
	

}
