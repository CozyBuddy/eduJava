package days19;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

public class Ex01_02 {
	public static void main(String[] args) {
		// 구본혁, 권맑음, 김영진, 김진성
		int m [] = {3,5,2,4,1};
		System.out.println(Arrays.toString(m));
		Arrays.sort(m); //오름차순 정렬
		/*
		// 내림차순 정렬
		int temp[] = new int[m.length];
		for (int i = 0; i < m.length; i++) {
			temp[m.length-1-i] = m[i];
		}
		m=temp;*/
		//Arrays.sort(m,Collections.reverseOrder());
		//int[] => Integer [] 변환 IntStream - > Stream<Integer>->Integer[]
		//IntStream 객체 boxed => 기본형 자료형을 래퍼 클래스로 객체화 시킴(IntStream -> Stream<Integer>)
		Integer temp [] =Arrays.stream(m).boxed().toArray(Integer[]::new);
		Arrays.sort(temp,Collections.reverseOrder());
		
		//Integer [] -> int[] 변환 / 위에거 역순 // of가 그 역할
		Stream.of(temp).mapToInt(Integer::intValue).toArray();
		System.out.println(Arrays.toString(temp));
	}

}
