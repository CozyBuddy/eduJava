package days23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Review1 {
	public static void main(String[] args) {
		HashSet hs = new HashSet<>();
		hs.add("가");
		hs.add("나");
		hs.add("다");
		hs.add("라");
		hs.add("마");
		
		System.out.println(hs);
		ArrayList<String> al = new ArrayList<>(hs);
		Collections.sort(al);
		System.out.println(al);
	}

}
