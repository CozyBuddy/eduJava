package days21;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author user
 * @date 2024. 1. 29. 오후 3:17:30
 * @subject
 * @contents
 */
public class Ex13_02 {
	public static void main(String[] args) {
		// import문은 클래스가 있는 패키지명까지 import 해야함.
//			1조 : 구본혁(팀장),류영은,윤형준,김영진,강명건,김진성,유진,이동찬
//			2조 : 원대안(팀장),이동영,한재호,권맑음,박우현,이시은,조연화
		
		ArrayList team1 = new ArrayList();
		String t1 = "구본혁(팀장),류영은,윤형준,김영진,강명건,김진성,유진,이동찬";
		String t1Names[] = t1.split(",");
		for (int i = 0; i < t1Names.length; i++) {
			team1.add(t1Names[i]);
		}
		System.out.println(team1);
		ArrayList team2 = new ArrayList();
		String t2 = "원대안(팀장),이동영,한재호,권맑음,박우현,이시은,조연화";
		String t2Names[] = t2.split(",");
		for (int i = 0; i < t2Names.length; i++) {
			team2.add(t2Names[i]);
		}
		System.out.println(team2);
		
		ArrayList class5 = new ArrayList(team1);
		//class5.addAll(team2);
		System.out.println(class5.toString());
		System.out.println( class5.containsAll(team2));
		
		ArrayList class5clone = (ArrayList) class5.clone();
		//class5clone.remove(0); //index
		//class5clone.remove("윤형준"); //object
		//class5clone.removeAll(team1);
		//[1] 정렬
		/*class5clone.sort(new Comparator() {
		@Override
		public int compare(Object o1, Object o2) {
		String s1 = (String)o1;
		String s2 = (String)o2;
		return s1.compareTo(s2); //오름차순 정렬
		//return s2.compareTo(s1); //내림차순 정렬
		
		}
	*/
		// 위 코딩과 동일한 코딩 람다식 [2] 정렬
		/*class5clone.sort((o1,o2)->((String) o1).compareTo((String) o2));*/
		
		//[3] 정렬
		//class5clone.sort(String.CASE_INSENSITIVE_ORDER); //Comparator  비교기
		
		//[4]
		//Arrays
		Collections.sort(class5clone); //오름차순 정렬
		
		System.out.println(class5clone.hashCode());
		System.out.println(class5clone);
		System.out.println(class5.hashCode());
		System.out.println(class5);
		
		
		
	}

}
//5강의장 학생들을 정렬하는데 사용하는 Comparator  // ????왜 정렬이 되는건지??


