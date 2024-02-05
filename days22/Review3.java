package days22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Review3 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("로또 게임 횟수를 입력하세요");
	int gameNumber = sc.nextInt();
	HashSet lotto = null;
	ArrayList lottos = new ArrayList();
	for (int i = 0; i < gameNumber; i++) {
		lotto = new HashSet();
		fillLotto(lotto);
		lottos.add(lotto);
	 }
	Arraylist al = new ArrayList(lotto)
	disLotto(lottos);
	}

	private static void disLotto(ArrayList lottos) {
		for (int i = 0; i < lottos.size(); i++) {
			lottos.get(i);
			System.out.printf("%d 게임 : %s",i+1 ,lottos.get(i));
			System.out.println();
		}
		
	}

	private static void fillLotto(HashSet lotto) {
		while ((lotto.size()<6)) {
			Random rd = new Random();
			int a = rd.nextInt(45)+1;
			lotto.add(a);
			
			
		}
		
	}

}
