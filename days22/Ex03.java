package days22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author user
 * @date 2024. 1. 30. 오전 10:46:14
 * @subject
 * @contents
 */
public class Ex03 {
	public static void main(String[] args) {
		//[1]ArrayList -> String [] 변환
		
		ArrayList list = new ArrayList();
		list.add("유진");
		list.add("원대안");
		list.add("윤형준");
		System.out.println(list);
		
		String names[] = (String[])list.toArray(new String[list.size()]);
		
		System.out.println(Arrays.toString(names));
		//[2]String[] -> ArrayList 변환
		List list1 = Arrays.asList(names);
		System.out.println(list1);
		ArrayList list2 = new ArrayList(list1);
		System.out.println(list2);
		
	}

}
