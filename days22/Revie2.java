package days22;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Revie2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("로또 게임 횟수를 입력하세요");
		int a = sc.nextInt();
		
		ArrayList b = new ArrayList();
		HashSet lotto=null;
		for (int i = 0; i < a; i++) {
			lotto = new HashSet();
			fillLotto(lotto);
			b.add(lotto);
		}
		disLotto(b);
	}

	private static void disLotto(ArrayList b) {
		Iterator ir = b.iterator();
		while (ir.hasNext()) {
			HashSet object = (HashSet) ir.next();
			Iterator ir2 = object.iterator();
			while (ir2.hasNext()) {
				int object2 = (int) ir2.next();
				System.out.println(object2);
			}
			System.out.println();
		}
		
	}

	private static void fillLotto(HashSet lotto) {
		Random rd = new Random();
		
		while (lotto.size()<6) {
			int a = rd.nextInt(45)+1;
			lotto.add(a);
		}
		
	}

}
