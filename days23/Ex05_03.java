package days23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author user
 * @date 2024. 1. 31. 오후 12:22:06
 * @subject
 * @contents
 */
public class Ex05_03 {
	public static void main(String[] args) {
		int score[] = {80,95,50,85,45,65,10,100};
		// 1) 80점 보다 큰 점수를 얻어와서 출력.
		/*for (int i = 0; i < score.length; i++) {
			if(score[i]>80) System.out.println(score);
		}*/
		
		// int [] -> TreeSet 변환
		/*TreeSet<Integer> ts = new TreeSet<>();
		for (int i = 0; i < score.length; i++) {
			ts.add(score[i]);
		}*/
		//// int [] -> TreeSet 변환 int [] -> integer[] -> List->TreeSet
		//TreeSet ts = new TreeSet();
		//  stream -> IntStream으로 만ㄷ름 - > boxed()로  Stream<Integer> 만듦 -> collect() 로 list로 만듦. -> 강제 형변환 으로 Arraylist로 만듦.
		
        ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(score).boxed().collect(Collectors.toList());
        TreeSet ts = new TreeSet(list);
		System.out.println(ts);
		// 지정된 값 보다 작은 값의 객체를 반환하는 메서드
		ts.headSet(80);
		
		// 지정된 값 보다 큰 값의 객체를 반환하는 메서드
		System.out.println(ts.tailSet(80)); // 80을 포함함
		System.out.println(ts.tailSet(80,false )); // 80 미포함
	}

}
