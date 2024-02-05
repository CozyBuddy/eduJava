package days21;

import java.util.ArrayList;
import java.util.Iterator;

public class Revieew4 {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add("이동영");
		al.add("한재호");
		al.add("권맑음");
		al.add("박우현");
		al.add("이시은");
		al.add("조연화");
		
		Iterator it = al.iterator();
		while (it.hasNext()) {
			String object = (String) it.next();
			System.out.println(object);
			
			
		}
		System.out.println(al.size());
		//System.out.println(al.get(1));
		//al.remove(1);
		al.set(1, "홍길동");
		if (al.contains("홍길동")) {
			al.remove("홍길동");
		}
		for (int i = 0; i < al.size(); i++) {
			String a =(String) al.get(i);
			if (a.startsWith("이")) {
				al.remove(i);
			};
		}
		Iterator it1 = al.iterator();
		while (it1.hasNext()) {
			String object = (String) it1.next();
			System.out.println(object);
			
			
		}
		
		
		
		
		
	}

}
