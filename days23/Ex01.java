package days23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

/**
 * @author user
 * @date 2024. 1. 31. 오전 10:49:53
 * @subject
 * @contents 로또 번호를 내림차순으로 정렬하려면 ? Comparator 인자 알아야할듯.
 */
public class Ex01 {
	public static void main(String[] args) {
		int n = 5;
		LinkedHashSet<Integer> lotto = new LinkedHashSet<>(); // 제네릭 타입은 레퍼런스 타입
		ArrayList<LinkedHashSet<Integer>> lottos = new ArrayList<>();
		int ln = 0;
		//입력 - 문제점
		for (int i = 0; i < n; i++) {
			lotto = new LinkedHashSet();
			while (lotto.size()<6) {
				ln = (int)(Math.random()*45+1);
				lotto.add(ln);
			}
	
			lottos.add(lotto);
			
		}
		//출력
		int count = 1;
		Iterator<LinkedHashSet<Integer>> ir =lottos.iterator();
		ArrayList<Integer> list = null;
		while (ir.hasNext()) {
			lotto = ir.next(); // LinkedHashSet 타입
			list = new ArrayList<Integer>(lotto);
			Collections.sort(list);
			System.out.printf("%d게임 : ",count++);
			Iterator<Integer> ir2 =list.iterator();
			while (ir2.hasNext()) {
				ln = (Integer) ir2.next(); // Integer - > int 오토언박싱
				System.out.printf("[%02d]",ln);
				
			}
			System.out.println();
		}

	}

}
