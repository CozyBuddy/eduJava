package days21;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author user
 * @date 2024. 1. 29. 오후 4:36:22
 * @subject
 * @contents
 */
public class Ex15 {
	public static void main(String[] args) {
		String my_str = "abc1Addfggg4556b";
		int n = 6;
		String answer[] =solution(my_str,n);

		//[ ]
		System.out.println(Arrays.toString(answer));
		

	}
	/* public static String[] solution(String my_str, int n) {

	        int arraylength = (int)Math.ceil((double)my_str.length()/n);
	        String[] answer = new String[arraylength] ;
	        StringBuilder sb = new StringBuilder(my_str);
	        for (int i = 0; i < answer.length-1; i++) {
	        	answer[i]= sb.substring(0,n); sb.delete(0, n);
			}
	        answer[arraylength-1]= sb.substring(0); 

	        return answer;
	    }


}*/
	public static String[] solution(String my_str, int n) {
		String[] answer = {};
		ArrayList list = new ArrayList<>();
		StringBuilder sb = new StringBuilder(my_str);
		try {
			while (true) {
				list.add(sb.substring(0,n)); sb.delete(0, n);
			}
			
		} catch (Exception e) {
			list.add(sb.substring(0));
		}
		
		
		/*for (int i = 0; i < my_str.length()/n; i++) {
			list.add(sb.substring(0,n)); sb.delete(0, n);
		}*/
		// 문제점 Arraylist -> String[] 변환
		//   	 String[] -> Arraylist변환
		//list.forEach(name -> System.out.println(name));
		//JAVA 8 Stream 사용한 예제
		//answer = (String[]) list.stream().toArray(String[] :: new);
		
		//list.add(sb.substring(0));
		//ArrayList -> String[] 변환.
		answer = (String[])list.toArray(new String[0]);
		return answer;
	}
}
