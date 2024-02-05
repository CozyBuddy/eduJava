package days19;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author user
 * @date 2024. 1. 25. 오전 10:44:55
 * @subject   알아놔라
 * @contents
 */
public class Ex01_03 {
	public static void main(String[] args) {
		String names[] = {"구본혁", "권맑음", "김영진", "김진성"};
		System.out.println(Arrays.toString(names));
		//Arrays.sort(names,Collections.reverseOrder());
		/*Arrays.sort(names,new Comparator<String>() {
		
			@Override
			public int compare(String o1, String o2) {
				
				return o2.compareTo(o1);
			}
		});*/
		
		//위 주석 코딩하고 동일한 코딩. =>람다식 표현
		Arrays.sort(names,(o1,o2)->o2.compareTo(o1));
		System.out.print(Arrays.toString(names)); // T[] => 기본형 자료형은 못들어감.
		
		
		
	}

}
