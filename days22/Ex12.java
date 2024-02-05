package days22;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author user
 * @date 2024. 1. 30. 오후 4:43:26
 * @subject
 * @contents
 */
public class Ex12 {
	public static void main(String[] args) {
		//사람 -> HashSet 
		//사람 -> LinkedHashSet
		Person3 p1 = new Person3("931101-1111111","권맑음",35);
		System.out.println(p1.hashCode());
		Set<Person3> s= new LinkedHashSet<Person3>(); // 순서유지
		s.add(p1);
		s.add(new Person3("222222-2222222","홍길동",20));
		s.add(new Person3("222222-2222223","김길동",21));
		//System.out.println(s.size());
		// 주민등록번호가 같으면 LinkedHashSet에서 중복으로 인식 요구
		// 방법? hashCode(),equals() 오버라이딩...
		Person3 p4  = new Person3("222222-2222222","뉴진스",25);
		System.out.println(p4.hashCode());
		Iterator<Person3> ir = s.iterator();
		while (ir.hasNext()) {
			Person3 p = (Person3) ir.next();
			System.out.println(p);
		}
	}

}
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Person3{
	String rrn;
	String name;
	int age;
	@Override
	public int hashCode() {
		return rrn.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person3) {
			Person3 p= (Person3)obj;
		return rrn.equals(p.rrn);
		}
		 return false;
	}
	
}
