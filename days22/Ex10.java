package days22;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * @author user
 * @date 2024. 1. 30. 오후 2:28:01
 * @subject
 * @contents 시험
 */
public class Ex10 {
	public static void main(String[] args) {
		//로또 게임 횟수를 입력받아사
		// 로또 번호를 출력하는 코딩.
		// days09.Ex02.java 1차원 배열 선언예
		// days12.Ex06.java 2차원 배열 선언 예
		
		/*
		 * 배열 사용X HashSet 으로 중복을 자동으로 걸러줌
		 */
		int gameNumber = 1;
		Scanner sc = new Scanner(System.in);
		System.out.print("게임 횟수 입력>");
		gameNumber = sc.nextInt();
		
		ArrayList lottos = new ArrayList();
		HashSet lotto = null;
		for (int i = 0; i < gameNumber; i++) {
			lotto = new HashSet();	
			fillLotto(lotto);
			lottos.add(lotto);
		}
		
		//fillLotto(lotto);
		disLottos(lottos);
		
	}

	private static void disLottos(ArrayList lottos) {
		int cnt =1;
		Iterator ir = lottos.iterator();
		while (ir.hasNext()) {
			HashSet object = (HashSet) ir.next();
			System.out.printf("%d 게임 : ",cnt++);
			Iterator ir2 = object.iterator();
			while (ir2.hasNext()) {
				int lotto = (int) ir2.next();
				System.out.printf("[%d]",lotto);
				
			}
			System.out.println();
		}
		
	}

	private static void fillLotto(HashSet lotto) {
		Random rnd = new Random();
		
		while (lotto.size()<6) {
			int n = rnd.nextInt(45)+1;
			//System.out.println(n);
			lotto.add(n);
		}
		
	}
	

}

